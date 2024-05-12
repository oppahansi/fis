package de.oppa.fis.responses.unsplash;

import com.google.gson.annotations.SerializedName;

public class UnsplashResult {
  private String description;

  @SerializedName("alt_description")
  private String altDescription;

  @SerializedName("urls")
  private UnsplashUrls urls;

  @SerializedName("links")
  private UnsplashLinks links;

  @SerializedName("user")
  private UnsplashPhotographer photographer;

  public UnsplashResult() {}

  public UnsplashResult(
      String description,
      String altDescription,
      UnsplashUrls urls,
      UnsplashLinks links,
      UnsplashPhotographer photographer) {
    this.description = description;
    this.altDescription = description;
    this.urls = urls;
    this.links = links;
    this.photographer = photographer;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAltDescription() {
    return altDescription;
  }

  public void setAltDescription(String altDescription) {
    this.altDescription = altDescription;
  }

  public UnsplashUrls getUrls() {
    return urls;
  }

  public void setUrls(UnsplashUrls urls) {
    this.urls = urls;
  }

  public UnsplashLinks getLinks() {
    return links;
  }

  public void setLinks(UnsplashLinks links) {
    this.links = links;
  }

  public UnsplashPhotographer getPhotographer() {
    return photographer;
  }

  public void setPhotographer(UnsplashPhotographer photographer) {
    this.photographer = photographer;
  }
}
