package com.project.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.project.model.Category;
import com.project.model.UserProject;
import com.project.utils.HibernateUtils;

@Repository
public class CategoryDao {
	
	public List<Category> getCategory() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.getTransaction().begin();
		Query qry = session.createQuery("from Category");
		List<Category> categoryList = qry.list();
		System.out.println("categoryList====>>>>"+categoryList);
		session.getTransaction().commit();
//		session.close();
		return categoryList;
	}
	
	public List<UserProject> getProjectByCategoryIdDao(int categoryId){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.getTransaction().begin();
		Query qry = session.createQuery("from UserProject where categoryId= :id");
		qry.setParameter("id", categoryId);
		List<UserProject> project = (List<UserProject>)qry.list().get(0);
		session.getTransaction().commit();
//		session.close();
		return project;
	}
}
