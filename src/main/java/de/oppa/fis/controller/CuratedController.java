package de.oppa.fis.controller;

import de.oppa.fis.responses.fis.FisResult;
import de.oppa.fis.service.fis.FisService;
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
public class CuratedController {

  private static final Logger logger = LoggerFactory.getLogger(CuratedController.class);

  private final FisService fisService;

  public CuratedController(FisService fisService) {
    this.fisService = fisService;
  }

  @CrossOrigin(origins = {"*"})
  @GetMapping(value = "/curated", produces = "application/json")
  public CompletableFuture<ResponseEntity<FisResult>> fetchCurated(
      @RequestParam(name = "page", required = false, defaultValue = "1") int page) {

    logger.info("Fetching curated images page: {}", page);

    return fisService
        .getCuratedResults(page)
        .thenApply(ResponseEntity::ok)
        .exceptionally(
            ex -> {
              logger.error("Error while fetching curated images", ex);
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            });
  }
}
