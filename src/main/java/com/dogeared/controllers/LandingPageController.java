package com.dogeared.controllers;

import com.dogeared.models.Dogear;
import com.dogeared.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LandingPageController extends AbstractController {

  @RequestMapping(value = "")
  public String dogearMain(Model model, HttpSession session) {

    User user = getUserFromSession(session);
    if (user != null) {
      return "redirect:dogear";
    }
    return "landingPage";
  }
}
