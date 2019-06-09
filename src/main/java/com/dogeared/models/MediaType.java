package com.dogeared.models;

public enum MediaType {

  MOVIE ("Movie"),
  BOOK ("Book"),
  AUDIO_BOOK ("Audio Book"),
  PODCAST ("Podcast");

  private final String name;

  MediaType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }


}
