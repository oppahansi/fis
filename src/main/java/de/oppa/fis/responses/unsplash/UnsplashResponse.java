package de.oppa.fis.responses.unsplash;

import java.util.List;

public class UnsplashResponse {
  private int total;
  private List<UnsplashResult> results;

  public UnsplashResponse() {}

  public UnsplashResponse(int total, List<UnsplashResult> results) {
    this.total = total;
    this.results = results;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<UnsplashResult> getResults() {
    return results;
  }

  public void setResults(List<UnsplashResult> results) {
    this.results = results;
  }
}
