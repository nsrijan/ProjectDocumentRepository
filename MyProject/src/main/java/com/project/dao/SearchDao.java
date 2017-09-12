package com.project.dao;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.project.model.Category;
import com.project.model.UserProject;
import com.project.utils.HibernateUtils;

@Repository
public class SearchDao {
	
	public List<UserProject> getSearchProject(String search){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.getTransaction().begin();
		// FROM Customer WHERE username LIKE :username
		Query qry = session.createQuery("FROM UserProject WHERE project_title LIKE :search");
		qry.setParameter("search", "%" + search + "%");
		List<UserProject> userProject = qry.list();
		
		for(UserProject up : userProject){
			System.out.println("lists--->>>>" + up.getUserProjectTitle());
		}

		session.getTransaction().commit();
//		session.close();
		return userProject;
	}
}
