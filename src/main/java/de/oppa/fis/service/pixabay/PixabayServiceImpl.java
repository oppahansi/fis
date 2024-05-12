package de.oppa.fis.service.pixabay;

import com.google.gson.Gson;
import de.oppa.fis.responses.pixabay.PixabayResponse;
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
public class PixabayServiceImpl implements PixabayService {

  private static final Logger logger = LoggerFactory.getLogger(PixabayServiceImpl.class);

  private static final Gson gson = new Gson();

  @Value("${pixabay.api.key}")
  private String apiKey;

  @Override
  @Cacheable("pixabaySearchResults")
  public CompletableFuture<PixabayResponse> getSearchResults(String query, int page, int perPage) {
    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(PixabayService.SEARCH_API_URL.formatted(apiKey, query, page, perPage)))
            .build();

    return client
        .sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenApply(body -> gson.fromJson(body, PixabayResponse.class))
        .exceptionally(
            ex -> {
              logger.error("Error while searching pixabay images", ex);
              return null;
            });
  }

  @Override
  public CompletableFuture<PixabayResponse> getCuratedResults(int page) {
    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(PixabayService.CURATED_API_URL.formatted(apiKey, page)))
            .build();

    return client
        .sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenApply(body -> gson.fromJson(body, PixabayResponse.class))
        .exceptionally(
            ex -> {
              logger.error("Error while fetching curated images from pixabay", ex);
              return null;
            });
  }
}
