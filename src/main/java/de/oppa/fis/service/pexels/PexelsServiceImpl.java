package de.oppa.fis.service.pexels;

import com.google.gson.Gson;
import de.oppa.fis.responses.pexels.PexelsResponse;
import de.oppa.fis.service.fis.FisServiceImpl;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PexelsServiceImpl implements PexelsService {

  private final Logger logger = LoggerFactory.getLogger(FisServiceImpl.class);

  private static final Gson gson = new Gson();

  @Value("${pexels.api.key}")
  private String apiKey;

  @Override
  @Cacheable("pexelsSearchResults")
  public CompletableFuture<PexelsResponse> getSearchResults(String query, int page, int perPage) {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(PexelsService.SEARCH_API_URL.formatted(query, perPage, page)))
            .header("Authorization", apiKey)
            .build();

    return client
        .sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenApply(body -> gson.fromJson(body, PexelsResponse.class))
        .exceptionally(
            ex -> {
              logger.error("Error while searching pexels images", ex);
              return null;
            });
  }

  @Override
  public CompletableFuture<PexelsResponse> getCuratedResults(int page) {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(PexelsService.CURATED_API_URL.formatted(page)))
            .header("Authorization", apiKey)
            .build();

    return client
        .sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenApply(body -> gson.fromJson(body, PexelsResponse.class))
        .exceptionally(
            ex -> {
              logger.error("Error while fetching curated photos from pexels.", ex);
              return null;
            });
  }
}
