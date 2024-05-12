package de.oppa.fis.responses.pexels;

import com.google.gson.annotations.SerializedName;

public class PexelsResult {
  private String url;

  @SerializedName("src")
  private PexelsSources sources;

  @SerializedName("alt")
  private String description;

  @SerializedName("photographer_url")
  private String photographer;

  public PexelsResult() {}

  public PexelsResult(String url, PexelsSources sources, String description, String photographer) {
    this.url = url;
    this.sources = sources;
    this.description = description;
    this.photographer = photographer;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public PexelsSources getSources() {
    return sources;
  }

  public void setSources(PexelsSources sources) {
    this.sources = sources;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPhotographer() {
    return photographer;
  }

  public void setPhotographer(String photographerUrl) {
    this.photographer = photographerUrl;
  }
}
