package com.dogeared.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {

  private String username;
  private String pwHash;
  private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  private List<Dogear> dogears;

  public User() {}

  public User(String username, String password) {

    super();

    //    if (!isValidUsername(username)) {
    //      throw new IllegalArgumentException("Invalid username");
    //    }

    this.username = username;
    this.pwHash = hashPassword(password);
  }

  @NotNull
  @Column(name = "pwhash")
  public String getPwHash() {
    return pwHash;
  }

  @SuppressWarnings("unused")
  public void setPwHash(String pwHash) {
    this.pwHash = pwHash;
  }

  @NotNull
  @Column(name = "username", unique = true)
  public String getUsername() {
    return username;
  }

  private static String hashPassword(String password) {
    return encoder.encode(password);
  }

  @SuppressWarnings("unused")
  public void setUsername(String username) {
    this.username = username;
  }

  public boolean isMatchingPassword(String password) {
    return encoder.matches(password, pwHash);
  }

  public static boolean isValidPassword(String password) {
    Pattern validUsernamePattern = Pattern.compile("(\\S){6,20}");
    Matcher matcher = validUsernamePattern.matcher(password);
    return matcher.matches();
  }

  public static boolean isValidUsername(String username) {
    Pattern validUsernamePattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]{4,11}");
    Matcher matcher = validUsernamePattern.matcher(username);
    return matcher.matches();
  }

  protected void addDogear(Dogear dogear) {
    dogears.add(dogear);
  }

  @OneToMany
  @JoinColumn(name = "user_uid")
  public List<Dogear> getDogears() {
    return dogears;
  }

  public void setDogears(List<Dogear> dogears) {
    this.dogears = dogears;
  }
}
