package de.oppa.fis.responses.fis;

import de.oppa.fis.responses.pexels.PexelsResult;
import de.oppa.fis.responses.pixabay.PixabayResult;
import de.oppa.fis.responses.unsplash.UnsplashResult;

public class FisImage {

  private String url;
  private String preview;
  private String description;
  private String photographer;
  private String license;
  private String source;

  public FisImage() {}

  public FisImage(
      String url,
      String preview,
      String description,
      String photographer,
      String license,
      String source) {
    this.url = url;
    this.preview = preview;
    this.description = description;
    this.photographer = photographer;
    this.license = license;
    this.source = source;
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

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String licenseUrl) {
    this.license = licenseUrl;
  }

  public static FisImage fromPexelsResult(PexelsResult result) {
    return new FisImage(
        result.getUrl(),
        result.getSources().getPreview(),
        result.getDescription(),
        result.getPhotographer(),
        getLicenseUrl(ImageSource.PEXELS),
        ImageSource.PEXELS.getUrl());
  }

  public static FisImage fromUnsplashResult(UnsplashResult result) {
    String description = result.getDescription();

    if (description == null) {
      description = result.getAltDescription();
    }

    return new FisImage(
        result.getLinks().getUrl(),
        result.getUrls().getPreview(),
        description == null ? "" : description,
        result.getPhotographer().getLinks().getUrl(),
        getLicenseUrl(ImageSource.UNSPLASH),
        ImageSource.UNSPLASH.getUrl());
  }

  public static FisImage fromPixabayResult(PixabayResult result) {
    return new FisImage(
        result.getUrl(),
        result.getPreview(),
        "",
        "https://pixabay.com/users/%s".formatted(result.getUser()),
        getLicenseUrl(ImageSource.PIXABAY),
        ImageSource.PIXABAY.getUrl());
  }

  private static String getLicenseUrl(ImageSource source) {
    return switch (source) {
      case PEXELS -> "https://www.pexels.com/license/";
      case UNSPLASH -> "https://www.unsplash.com/license/";
      case PIXABAY -> "https://www.pixabay.com/service/license-summary/";
    };
  }
}
