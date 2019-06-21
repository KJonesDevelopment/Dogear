package com.dogeared.controllers;

import com.dogeared.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController extends AbstractController {

  @RequestMapping(value = "/registration", method = RequestMethod.GET)
  public String registrationForm() {
    return "registration";
  }

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  public String registration(
      @RequestParam String username,
      @RequestParam String password,
      @RequestParam String verify,
      HttpServletRequest request,
      Model model) {

    User newUser = new User(username, password);

    userDao.save(newUser);

    return "redirect:/login";
  }
}
