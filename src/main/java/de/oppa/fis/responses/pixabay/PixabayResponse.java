package de.oppa.fis.responses.pixabay;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PixabayResponse {
  private int total;

  @SerializedName("hits")
  private List<PixabayResult> results;

  public PixabayResponse() {}

  public PixabayResponse(int total, List<PixabayResult> results) {
    this.total = total;
    this.results = results;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<PixabayResult> getResults() {
    return results;
  }

  public void setResults(List<PixabayResult> results) {
    this.results = results;
  }
}
