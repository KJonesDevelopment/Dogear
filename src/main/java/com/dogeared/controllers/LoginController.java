package com.dogeared.controllers;

import com.dogeared.models.User;
import com.dogeared.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends AbstractController {

  @Autowired UserDao userDao;

  @RequestMapping(value = "login")
  public String login() {
    return "login";
  }

  @RequestMapping(value = "login", method = RequestMethod.POST)
  public String login(
      @RequestParam String username, @RequestParam String password, HttpSession session, Model model)
      {

    System.out.println(username);
    System.out.println(password);

    User user = userDao.findByUsername(username);

    if (!user.isMatchingPassword(password)) {
      String loginError = "Username or Password did not match";
      model.addAttribute("loginError", loginError);
      return "login";
    }

    System.out.println(user);
    System.out.println(session);

    setUserInSession(session, user);

    return "redirect:dogear";
  }
}
