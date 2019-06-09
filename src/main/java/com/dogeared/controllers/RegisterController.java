package com.dogeared.controllers;

import com.dogeared.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
public class RegisterController extends AbstractController{

  @RequestMapping(value="/registration", method= RequestMethod.GET)
  public String registrationForm() {
    return "registration";
  }

  @RequestMapping(value="/registration", method=RequestMethod.POST)
  public String registration(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String verify,
//                             @ModelAttribute @Valid User newUser,
//                             Errors errors,
                             HttpServletRequest request,
                             Model model) {

//    if (errors.hasErrors()) {
//      model.addAttribute(errors);
//      System.out.println(errors);
//      return "registration";
//    }
//
//    userDao.save(newUser);
//    System.out.println(newUser);

    return "redirect:home";
  }

}
