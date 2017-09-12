package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.SearchDao;
import com.project.model.UserProject;

@Service
public class SearchService {
	
	@Autowired
	SearchDao searchDao;
		
	public List<UserProject> getSearchResult(String search){
		return searchDao.getSearchProject(search);
	}
}
