package de.oppa.fis.responses.fis;

public enum ImageSource {
  PEXELS("https://www.pexels.com/"),
  UNSPLASH("https://www.unsplash.com/"),
  PIXABAY("https://www.pixabay.com/");

  private String url;

  ImageSource(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }
}
