package de.oppa.fis.service.pexels;

import de.oppa.fis.responses.pexels.PexelsResponse;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;

@Service
public interface PexelsService {

  String SEARCH_API_URL = "https://api.pexels.com/v1/search?query=%s&per_page=%d&page=%d";
  String CURATED_API_URL = "https://api.pexels.com/v1/curated?per_page=10&page=%d";

  CompletableFuture<PexelsResponse> getSearchResults(String query, int page, int perPage);

  CompletableFuture<PexelsResponse> getCuratedResults(int page);
}
