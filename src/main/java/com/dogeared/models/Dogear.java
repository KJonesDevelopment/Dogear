package com.dogeared.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "dogear")
public class Dogear extends AbstractEntity {

  private String earmark;
  private String note;
  private User user;
  private Date created;
  private Date modified;

  public Dogear() {}

  public Dogear(String earmark, String note, User user) {

    super();

    this.earmark = earmark;
    this.note = note;
    this.user = user;
    this.created = new Date();
    this.updated();
  }

  @NotNull
  @Column(name = "earmark")
  public String getEarmark() {
    return earmark;
  }

  public void setEarmark(String earmark) {
    this.earmark = earmark;
    this.updated();
  }

  @NotNull
  @Column(name = "note")
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
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
