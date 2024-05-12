package de.oppa.fis.responses.pexels;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PexelsResponse {
  @SerializedName("total_results")
  private int total;

  @SerializedName("photos")
  private List<PexelsResult> results;

  public PexelsResponse() {}

  public PexelsResponse(int total, List<PexelsResult> results) {
    this.total = total;
    this.results = results;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int totalResults) {
    this.total = totalResults;
  }

  public List<PexelsResult> getResults() {
    return results;
  }

  public void setResults(List<PexelsResult> results) {
    this.results = results;
  }
}
