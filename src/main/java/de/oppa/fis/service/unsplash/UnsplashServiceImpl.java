package de.oppa.fis.service.unsplash;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.oppa.fis.responses.unsplash.UnsplashResponse;
import de.oppa.fis.responses.unsplash.UnsplashResult;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UnsplashServiceImpl implements UnsplashService {

  private static final Logger logger = LoggerFactory.getLogger(UnsplashServiceImpl.class);

  private static final Gson gson = new Gson();

  @Value("${unsplash.api.key}")
  private String apiKey;

  @Override
  @Cacheable("unsplashSearchResults")
  public CompletableFuture<UnsplashResponse> getSearchResults(String query, int page, int perPage) {
    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(UnsplashService.SEARCH_API_URL.formatted(apiKey, query, page, perPage)))
            .build();

    return client
        .sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenApply(body -> gson.fromJson(body, UnsplashResponse.class))
        .exceptionally(
            ex -> {
              logger.error("Error while searching unsplash images", ex);
              return null;
            });
  }

  @Override
  public CompletableFuture<UnsplashResponse> getCuratedResults(int page) {
    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(UnsplashService.CURATED_API_URL.formatted(apiKey, page, 10)))
            .build();

    return client
        .sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenApply(
            body -> {
              Type type = new TypeToken<ArrayList<UnsplashResult>>() {}.getType();
              List<UnsplashResult> results = gson.fromJson(body, type);

              return new UnsplashResponse(results.size(), results);
            })
        .exceptionally(
            ex -> {
              logger.error("Error while fetching curated images from unsplash", ex);
              return null;
            });
  }
}
