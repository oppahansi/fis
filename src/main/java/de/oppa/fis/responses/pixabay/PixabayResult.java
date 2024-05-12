package de.oppa.fis.responses.pixabay;

import com.google.gson.annotations.SerializedName;

public class PixabayResult {
  @SerializedName("pageURL")
  private String url;

  @SerializedName("webformatURL")
  private String preview;

  private String user;

  public PixabayResult() {}

  public PixabayResult(String url, String preview, String user) {
    this.url = url;
    this.preview = preview;
    this.user = user;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getPreview() {
    return preview;
  }

  public void setPreview(String preview) {
    this.preview = preview;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }
}
