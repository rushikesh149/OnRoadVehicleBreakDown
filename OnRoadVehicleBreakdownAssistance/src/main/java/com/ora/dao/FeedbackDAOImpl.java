package com.ora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.ora.entity.Feedback;
import com.ora.entity.User;
import com.ora.exception.EmptyListException;
import com.ora.service.MechanicServiceImpl;
import com.ora.service.UserServiceImpl;
import com.ora.util.JPAUtil;

public class FeedbackDAOImpl implements FeedbackDAO{
	final static Logger logger = Logger.getLogger(MechanicServiceImpl.class);
	public boolean addFeedback(Feedback feedback) {
		EntityManager entityManager =JPAUtil.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(feedback);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
		
	}
	
	public List<Feedback> viewFeedback()
	{
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM Feedback");
		List<Feedback> list=q.getResultList();
		try{if(list.equals(null))
		{
			 throw new EmptyListException("No Feedback Found");
		}
		}
		catch(EmptyListException e)
		{
			logger.error(e);
		}
		finally {	return list;}
	}

		

	
	
}
