package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.Category;
import com.project.model.User;
import com.project.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="upload")
	public ModelAndView requestUpload(HttpSession session){
		User validUser = (User)session.getAttribute("validUser");
		if(validUser == null) {
			ModelAndView mv = new ModelAndView("login");
			return mv;
		}else {
		List<Category> categoryList = categoryService.getCategory();
		System.out.println("Inside Controlller categoryList ====>>>>"+categoryList);
		ModelAndView mv = new ModelAndView("upload");
		mv.addObject("categoryList", categoryList);
		return mv;
		}
	}
}
