package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.CategoryDao;
import com.project.model.Category;
import com.project.model.UserProject;


@Service
public class CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	public List<Category> getCategory(){
		return categoryDao.getCategory();
	}
	
	public List<UserProject> getProjectByCategoryIdService(int categoryId){
		return categoryDao.getProjectByCategoryIdDao(categoryId);
	}
}
