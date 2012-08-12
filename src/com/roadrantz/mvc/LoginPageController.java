package com.roadrantz.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class LoginPageController extends AbstractController {
  public LoginPageController() {}
  
  protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)throws Exception {
    return new ModelAndView("login");
  }
  
}
