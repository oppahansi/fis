package de.oppa.fis.responses.pexels;

import com.google.gson.annotations.SerializedName;

public class PexelsSources {

  @SerializedName("large")
  private String preview;

  public PexelsSources() {}

  public PexelsSources(String preview) {
    this.preview = preview;
  }

  public String getPreview() {
    return preview;
  }

  public void setPreview(String preview) {
    this.preview = preview;
  }
}
