package com.dogeared.controllers;

import com.dogeared.models.User;
import com.dogeared.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends AbstractController {

  @Autowired UserDao userDao;

  @RequestMapping(value = "")
  public String login() {
    return "login";
  }

  @RequestMapping(value = "login", method = RequestMethod.POST)
  public String login(
      @RequestParam String username, @RequestParam String password, HttpSession session)
      throws Exception {

    System.out.println(username);
    System.out.println(password);

    User user = userDao.findByUsername(username);

    if (!user.isMatchingPassword(password)) {
      throw new Exception("Username or password does not match");
    }

    System.out.println(user);
    System.out.println(session);

    setUserInSession(session, user);

    return "redirect:dogear";
  }
}
