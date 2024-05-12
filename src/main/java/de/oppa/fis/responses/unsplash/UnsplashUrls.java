package de.oppa.fis.responses.unsplash;

import com.google.gson.annotations.SerializedName;

public class UnsplashUrls {
  @SerializedName("small")
  private String preview;

  public UnsplashUrls() {}

  public UnsplashUrls(String preview) {
    this.preview = preview;
  }

  public String getPreview() {
    return preview;
  }

  public void setPreview(String preview) {
    this.preview = preview;
  }
}
