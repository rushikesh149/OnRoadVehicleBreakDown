package com.ora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.ora.entity.User;
import com.ora.exception.EmptyListException;
import com.ora.exception.InvalidException;
import com.ora.service.UserServiceImpl;
import com.ora.util.JPAUtil;


public class UserDAOImpl implements UserDAO{
	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	public boolean addUser(User user) {
		EntityManager entityManager =JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			entityManager.close();
			return true;
		
		}
	
	public List<User> viewUserDetails() {
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM User");
		List<User> list=q.getResultList();
		try{if(list.equals(null))
		{
			 throw new EmptyListException("No any user found");
		}
		}
		catch(EmptyListException e)
		{
			logger.error(e);
		}
		finally {	return list;}
	
		
	}
	
	public boolean updateUser(User user) {
		EntityManager entityManager= JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		entityManager.close();
		return true;
	}

}
