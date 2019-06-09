package com.dogeared.controllers;

import com.dogeared.models.User;
import com.dogeared.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public abstract class AbstractController {

  @Autowired protected UserDao userDao;

  public static final String userSessionKey = "user_id";

  protected User getUserFromSession(HttpSession session) {

    Integer userId = (Integer) session.getAttribute(userSessionKey);
    return userId == null ? null : userDao.findByUid(userId);
  }

  protected void setUserInSession(HttpSession session, User user) {
    session.setAttribute(userSessionKey, user.getUid());
  }
}
