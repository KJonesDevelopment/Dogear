package com.dogeared.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/css/**", "/index")
        .permitAll()
        .antMatchers("/user/**")
        .hasRole("USER")
        .antMatchers("/admin/**")
        .hasRole("ADMIN")
        .and()
        .formLogin()
        .loginPage("/user/home")
        .defaultSuccessUrl("/user/home")
        .failureUrl("/login-error");
  }
}
