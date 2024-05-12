package de.oppa.fis.service.fis;

import de.oppa.fis.responses.fis.FisResult;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;

@Service
public interface FisService {
  CompletableFuture<FisResult> getSearchResults(String query, int page, int perSource);

  CompletableFuture<FisResult> getCuratedResults(int page);
}
