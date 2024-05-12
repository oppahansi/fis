package de.oppa.fis.service.pixabay;

import de.oppa.fis.responses.pixabay.PixabayResponse;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;

@Service
public interface PixabayService {

  String SEARCH_API_URL =
      "https://pixabay.com/api/?key=%s&q=%s&image_type=photo&page=%d&per_page=%d";
  String CURATED_API_URL =
      "https://pixabay.com/api/?key=%s&image_type=photo&page=%d&per_page=10&editors_choice=true";

  CompletableFuture<PixabayResponse> getSearchResults(String query, int page, int perPage);

  CompletableFuture<PixabayResponse> getCuratedResults(int page);
}
