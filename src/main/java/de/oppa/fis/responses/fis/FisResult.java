package de.oppa.fis.responses.fis;

import java.util.List;
import java.util.Map;

public class FisResult {

  private int total;
  private int page;
  private int perPage;
  private int perSource;
  private Map<String, String> searchSources;
  private List<FisImage> images;

  public FisResult() {}

  public FisResult(
      int total,
      int page,
      int perSource,
      int perPage,
      Map<String, String> searchSources,
      List<FisImage> images) {
    this.total = total;
    this.page = page;
    this.perSource = perSource;
    this.perPage = perPage;
    this.searchSources = searchSources;
    this.images = images;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getPerSource() {
    return perSource;
  }

  public void setPerSource(int perSource) {
    this.perSource = perSource;
  }

  public int getPerPage() {
    return perPage;
  }

  public void setPerPage(int perPage) {
    this.perPage = perPage;
  }

  public Map<String, String> getSearchSources() {
    return searchSources;
  }

  public void setSearchSources(Map<String, String> searches) {
    this.searchSources = searches;
  }

  public List<FisImage> getImages() {
    return images;
  }

  public void setImages(List<FisImage> photos) {
    this.images = photos;
  }
}
