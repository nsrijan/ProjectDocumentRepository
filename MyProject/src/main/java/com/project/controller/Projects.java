package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.Category;
import com.project.model.User;
import com.project.model.UserProject;
import com.project.service.CategoryService;
import com.project.service.UserProjectService;


@Controller
public class Projects {
	
	@Autowired
	UserProjectService userProjectService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="project")
	public ModelAndView getProjectList(){
		List<UserProject> userProjectList = userProjectService.getUserProjectList();
		List<Category> categoryList = categoryService.getCategory();
		ModelAndView mv = new ModelAndView("project-list");
		mv.addObject("projectList", userProjectList);
		mv.addObject("categoryList", categoryList);
		return mv;
	}
	
	@RequestMapping(value="viewProject/{userProjectId}", method=RequestMethod.GET)
	public ModelAndView projectDetail(@PathVariable("userProjectId")int userProjectId, HttpSession session){
		User validUser = (User)session.getAttribute("validUser");
		if(validUser == null) {
			ModelAndView mv = new ModelAndView("login");
			return mv;
		}else {
		UserProject viewProject = userProjectService.viewUserProjectById(userProjectId);
		ModelAndView mv = new ModelAndView("displayProject");
		mv.addObject("viewProject", viewProject);
		return mv;
		}
	}
	
	@RequestMapping(value="listProject", method=RequestMethod.GET)
	public ModelAndView getProjectByCategory(@RequestParam("categoryId")int categoryId){
		
		List<UserProject> projectByCategory = categoryService.getProjectByCategoryIdService(categoryId);
		ModelAndView mv = new ModelAndView("project-list");
		mv.addObject("projectByCategory", projectByCategory);
		return mv;
		
	}
}
