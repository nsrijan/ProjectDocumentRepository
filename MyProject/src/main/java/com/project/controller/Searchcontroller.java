package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.User;
import com.project.model.UserProject;
import com.project.service.SearchService;

@Controller
public class Searchcontroller {

	@Autowired
	SearchService searchService;

	@RequestMapping(value = "searchProject", method = RequestMethod.GET)
	public ModelAndView searchProject(@RequestParam(value = "search") String searchProject) {
		System.out.println("Searching  ==== >>>>>" + searchProject);
		List<UserProject> projectList = searchService.getSearchResult(searchProject);

		if (projectList.isEmpty()) {
			return new ModelAndView("noProject");
		}

		else {
			ModelAndView mv = new ModelAndView("project-list");
			mv.addObject("projectList", projectList);
			return mv;
		}
	}
}
