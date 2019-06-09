package com.dogeared.controllers;

import com.dogeared.models.Dogear;
import com.dogeared.models.data.DogearDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/** Displays login screen */
@Controller
public class HomeController {

  @RequestMapping(value = "user/home")
  public String welcomeHome() {
    return "home";
  }

  @Autowired
  DogearDao dogearDao;

  @RequestMapping(value = "test-data", method = RequestMethod.POST)
  public String testData(@RequestParam String username) {

    System.out.println(username);
//    Dogear entry = new Dogear(username, "test text for now");
//    dogearDao.save(entry);
    return "home";
  }

  //    @RequestMapping(value = "error")
  //    public String loginError(Model model) {
  //        model.addAttribute("loginError", true);
  //        return "login";
  //    }

}
