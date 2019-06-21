package com.dogeared.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController extends AbstractController{

  @RequestMapping(value="dogear/logout")
  public String logout(HttpSession session) {
    removeUserFromSession(session);
    return "redirect:/login";
  }
}
