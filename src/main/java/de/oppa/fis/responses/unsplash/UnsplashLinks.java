package de.oppa.fis.responses.unsplash;

import com.google.gson.annotations.SerializedName;

public class UnsplashLinks {
  @SerializedName("html")
  private String url;

  public UnsplashLinks() {}

  public UnsplashLinks(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
