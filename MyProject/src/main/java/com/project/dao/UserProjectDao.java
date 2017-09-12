package com.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.project.model.UserProject;
import com.project.utils.HibernateUtils;

@Repository
public class UserProjectDao {
	
	public void addUserProject(UserProject userProject){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.save(userProject);
		session.getTransaction().commit();
//		session.close();
	}
	
	public List<UserProject> getUserProjectList(){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.getTransaction().begin();
		Query qry = session.createQuery("from UserProject");
		List<UserProject> userProjectList = qry.list();
		session.getTransaction().commit();
//		session.close();
		return userProjectList;
	}
	
	public UserProject viewUserProjectById(int userProjectId){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.getTransaction().begin();
		Query qry = session.createQuery("from UserProject where userProjectId= :id");
		qry.setParameter("id", userProjectId);
		UserProject userProject = (UserProject)qry.list().get(0);
		session.getTransaction().commit();
//		session.close();
		return userProject;
	}
	
}
