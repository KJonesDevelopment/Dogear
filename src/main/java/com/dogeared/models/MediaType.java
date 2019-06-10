package com.dogeared.models;

public enum MediaType {
  MOVIE("movie"),
  BOOK("book"),
  AUDIO_BOOK("audioBook"),
  PODCAST("podcast");

  private final String name;

  MediaType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
