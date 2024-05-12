package de.oppa.fis.service.unsplash;

import de.oppa.fis.responses.unsplash.UnsplashResponse;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;

@Service
public interface UnsplashService {

  String SEARCH_API_URL =
      "https://api.unsplash.com/search/photos/?client_id=%s&query=%s&page=%d&per_page=%d";
  String CURATED_API_URL = "https://api.unsplash.com/photos?client_id=%s&page=%d&per_page=%d";

  CompletableFuture<UnsplashResponse> getSearchResults(String query, int page, int perPage);

  CompletableFuture<UnsplashResponse> getCuratedResults(int page);
}
