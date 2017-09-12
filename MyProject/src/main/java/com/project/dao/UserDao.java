package com.project.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


import com.project.model.User;
import com.project.utils.HibernateUtils;

@Repository
public class UserDao {
	
	
	
	public void addUser(User user){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.save(user);
		session.getTransaction().commit();
//		session.close();
	}
	
	public User validateUser(User user){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.getTransaction().begin();
		System.out.println("UserDao=====>>>"+user);
		Query qry = session.createQuery("from User where userEmail= :email and userPassword= :password ");
		qry.setParameter("email", user.getUserEmail());
		qry.setParameter("password", user.getUserPassword());
		User validatedUser = (User)qry.list().get(0);
		session.getTransaction().commit();
//		session.close();
		return validatedUser;
	}
}
