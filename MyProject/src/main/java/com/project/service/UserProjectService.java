package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserProjectDao;
import com.project.model.UserProject;

@Service
public class UserProjectService {
	
	@Autowired
	UserProjectDao userProjectDao;
	
	public void addUserProject(UserProject userProject){
		userProjectDao.addUserProject(userProject);
	}
	
	public List<UserProject> getUserProjectList(){
		return userProjectDao.getUserProjectList();
	}
	
	public UserProject viewUserProjectById(int userProjectId){
		return userProjectDao.viewUserProjectById(userProjectId);
	}
}
