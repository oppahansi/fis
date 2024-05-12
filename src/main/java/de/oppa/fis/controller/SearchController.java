package de.oppa.fis.controller;

import de.oppa.fis.responses.fis.FisResult;
import de.oppa.fis.service.fis.FisService;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

  private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

  private final FisService fisService;

  public SearchController(FisService fisService) {
    this.fisService = fisService;
  }

  @CrossOrigin(origins = {"*"})
  @GetMapping(value = "/search", produces = "application/json")
  public CompletableFuture<ResponseEntity<FisResult>> search(
      @RequestParam(name = "query") String query,
      @RequestParam(name = "page", required = false, defaultValue = "1") int page,
      @RequestParam(name = "perSource", required = false, defaultValue = "10") int perSource) {

    String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8).replace("+", "%20");

    logger.info(
        "Searching for images with query: {}, page: {}, perSource: {}", query, page, perSource);

    return fisService
        .getSearchResults(encodedQuery, page, perSource)
        .thenApply(ResponseEntity::ok)
        .exceptionally(
            ex -> {
              logger.error("Error while searching for images", ex);
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            });
  }
}
