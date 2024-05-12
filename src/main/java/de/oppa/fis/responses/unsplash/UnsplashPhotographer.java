package de.oppa.fis.responses.unsplash;

import com.google.gson.annotations.SerializedName;

public class UnsplashPhotographer {

  @SerializedName("links")
  private UnsplashLinks links;

  public UnsplashPhotographer() {}

  public UnsplashPhotographer(UnsplashLinks links) {
    this.links = links;
  }

  public UnsplashLinks getLinks() {
    return links;
  }

  public void setLinks(UnsplashLinks links) {
    this.links = links;
  }
}
