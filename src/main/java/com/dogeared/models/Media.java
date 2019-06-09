package com.dogeared.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "media")
public class Media extends AbstractEntity {

  private String title;
  private MediaType mediaType;
  private User user;
  private Date created;
  private Date modified;

  public Media() {}

  public Media(String title, MediaType mediaType, User user) {

    super();

    this.title = title;
    this.mediaType = mediaType;
    this.user = user;
    this.created = new Date();
    this.updated();
  }

  @NotNull
  @Column(name = "title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
    this.updated();
  }

  @NotNull
  @Column(name = "mediaType")
  public MediaType getMediaType() {
    return mediaType;
  }

  public void setMediaType(MediaType mediaType) {
    this.mediaType = mediaType;
    this.updated();
  }

  @ManyToOne
  public User getUser() {
    return user;
  }

  @SuppressWarnings("unused")
  private void setUser(User user) {
    this.user = user;
  }

  @NotNull
  @OrderColumn
  @Column(name = "created")
  public Date getCreated() {
    return created;
  }

  @SuppressWarnings("unused")
  private void setCreated(Date created) {
    this.created = created;
  }

  @NotNull
  @Column(name = "modified")
  public Date getModified() {
    return modified;
  }

  @SuppressWarnings("unused")
  private void setModified(Date modified) {
    this.modified = modified;
  }

  private void updated() {
    this.modified = new Date();
  }
}
