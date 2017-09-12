package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.User;
import com.project.service.UserService;

@Controller
@SessionAttributes({"validUser"})
public class ValidUser {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="login-user", method=RequestMethod.POST)
	public ModelAndView loginUser(@ModelAttribute User user, HttpSession session){
		User validUser = userService.validateUser(user);
		System.out.println("UserController====>>>>"+validUser);
		ModelAndView mv = new ModelAndView("redirect:index");
		mv.addObject("validUser", validUser);
		return mv;
	}
}
