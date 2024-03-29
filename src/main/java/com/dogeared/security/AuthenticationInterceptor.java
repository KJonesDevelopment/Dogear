package com.dogeared.security;

import com.dogeared.controllers.AbstractController;
import com.dogeared.models.User;
import com.dogeared.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

  @Autowired UserDao userDao;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws IOException {

    List<String> authPages = Arrays.asList("/dogear");

    System.out.println("incoming request -> " + request.getRequestURI());

    //     Require sign-in for auth pages
    if (authPages.contains(request.getRequestURI())) {

      boolean isLoggedIn = false;
      User user;
      Integer userId =
          (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

      if (userId != null) {
        user = userDao.findByUid(userId);

        if (user != null) {
          isLoggedIn = true;
        }
      }

      // If user not logged in, redirect to login page
      if (!isLoggedIn) {
        response.sendRedirect("/registration");
        return false;
      }
    }

    return true;
  }
}
