package com.dogeared.controllers;

import com.dogeared.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DogearController extends AbstractController {

  @Autowired UserDao userDao;

  @RequestMapping(value = "/dogear")
  public String dogearMain() {
    System.out.println("made it to the dogear controller");
    return "dogear";
  }
}
