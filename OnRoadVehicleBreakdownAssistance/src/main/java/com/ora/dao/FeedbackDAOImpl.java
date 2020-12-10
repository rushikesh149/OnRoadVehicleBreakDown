package com.ora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ora.entity.Feedback;
import com.ora.entity.User;
import com.ora.util.JPAUtil;

public class FeedbackDAOImpl implements FeedbackDAO{

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
		
		return list;
	}

		

	
	
}
