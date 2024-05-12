package de.oppa.fis.service.fis;

import de.oppa.fis.responses.fis.FisImage;
import de.oppa.fis.responses.fis.FisResult;
import de.oppa.fis.responses.fis.ImageSource;
import de.oppa.fis.responses.pexels.PexelsResponse;
import de.oppa.fis.responses.pixabay.PixabayResponse;
import de.oppa.fis.responses.unsplash.UnsplashResponse;
import de.oppa.fis.service.pexels.PexelsService;
import de.oppa.fis.service.pixabay.PixabayService;
import de.oppa.fis.service.unsplash.UnsplashService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class FisServiceImpl implements FisService {

  private final Logger logger = LoggerFactory.getLogger(FisServiceImpl.class);

  private final PexelsService pexelsService;
  private final UnsplashService unsplashService;
  private final PixabayService pixabayService;

  public FisServiceImpl(
      PexelsService pexelsService, UnsplashService unsplashService, PixabayService pixabayService) {
    this.pexelsService = pexelsService;
    this.unsplashService = unsplashService;
    this.pixabayService = pixabayService;
  }

  @Override
  @Cacheable("fisSearchResults")
  public CompletableFuture<FisResult> getSearchResults(String query, int page, int perSource) {
    CompletableFuture<PexelsResponse> pexelsSearchResult =
        pexelsService.getSearchResults(query, page, perSource);
    CompletableFuture<UnsplashResponse> unsplashSearchResult =
        unsplashService.getSearchResults(query, page, perSource);
    CompletableFuture<PixabayResponse> pixabaySearchResult =
        pixabayService.getSearchResults(query, page, perSource);

    return CompletableFuture.supplyAsync(
            () -> {
              List<FisImage> fisImages = new ArrayList<>();
              Map<String, String> searchSources = setSearchSources(query);
              int total = 0;

              total += processResult(pexelsSearchResult, fisImages, "Pexels");
              total += processResult(unsplashSearchResult, fisImages, "Unsplash");
              total += processResult(pixabaySearchResult, fisImages, "Pixabay");

              Collections.shuffle(fisImages);

              return new FisResult(
                  total, page, perSource, fisImages.size(), searchSources, fisImages);
            })
        .exceptionally(
            ex -> {
              logger.error("Error while searching for images", ex);
              return null;
            });
  }

  @Override
  @Cacheable("fisCuratedResults")
  public CompletableFuture<FisResult> getCuratedResults(int page) {
    CompletableFuture<PexelsResponse> pexelsCuratedResult = pexelsService.getCuratedResults(page);
    CompletableFuture<UnsplashResponse> unsplashCuratedResult =
        unsplashService.getCuratedResults(page);
    CompletableFuture<PixabayResponse> pixabayCuratedResult =
        pixabayService.getCuratedResults(page);

    return CompletableFuture.supplyAsync(
            () -> {
              List<FisImage> fisImages = new ArrayList<>();
              Map<String, String> curatedSources = setCuratedSources();
              int total = 0;

              total += processResult(pexelsCuratedResult, fisImages, "Pexels");
              total += processResult(unsplashCuratedResult, fisImages, "Unsplash");
              total += processResult(pixabayCuratedResult, fisImages, "Pixabay");

              Collections.shuffle(fisImages);

              return new FisResult(total, page, 10, fisImages.size(), curatedSources, fisImages);
            })
        .exceptionally(
            ex -> {
              logger.error("Error while fetching curated photos", ex);
              return null;
            });
  }

  private Map<String, String> setSearchSources(String query) {
    Map<String, String> sources = new HashMap<>();

    sources.put(
        ImageSource.PEXELS.name().toLowerCase(),
        "https://www.pexels.com/search/%s".formatted(query));
    sources.put(
        ImageSource.UNSPLASH.name().toLowerCase(),
        "https://unsplash.com/s/photos/%s".formatted(query.replace("%20", "-")));
    sources.put(
        ImageSource.PIXABAY.name().toLowerCase(),
        "https://pixabay.com/images/search/%s".formatted(query));

    return sources;
  }

  private Map<String, String> setCuratedSources() {
    Map<String, String> sources = new HashMap<>();

    sources.put(ImageSource.PEXELS.name().toLowerCase(), ImageSource.PEXELS.getUrl());
    sources.put(ImageSource.UNSPLASH.name().toLowerCase(), ImageSource.UNSPLASH.getUrl());
    sources.put(ImageSource.PIXABAY.name().toLowerCase(), ImageSource.PIXABAY.getUrl());

    return sources;
  }

  private int processResult(
      CompletableFuture<? extends Object> resultFuture,
      List<FisImage> fisImages,
      String serviceName) {
    try {
      Object results = resultFuture.get();
      List<FisImage> images = new ArrayList<>();
      int total = 0;

      if (results instanceof PexelsResponse pexelsResponse) {
        images = pexelsResponse.getResults().stream().map(FisImage::fromPexelsResult).toList();
        total = pexelsResponse.getTotal();
      } else if (results instanceof UnsplashResponse unsplashResponse) {
        images = unsplashResponse.getResults().stream().map(FisImage::fromUnsplashResult).toList();
        total = unsplashResponse.getTotal();
      } else if (results instanceof PixabayResponse pixabayResponse) {
        images = pixabayResponse.getResults().stream().map(FisImage::fromPixabayResult).toList();
        total = pixabayResponse.getTotal();
      }

      fisImages.addAll(images);

      return total;
    } catch (InterruptedException | ExecutionException ex) {
      logger.warn("Fetching " + serviceName + " results failed.", ex);
      return 0;
    }
  }
}
