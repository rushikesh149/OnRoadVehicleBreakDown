package com.ora.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Test;

import com.ora.entity.Feedback;
import com.ora.util.JPAUtil;

public class FeedbackDAOImplTest {


	@Test
	public void testAddFeedback(Feedback feedback) {
		EntityManager entityManager =JPAUtil.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(feedback);
		entityManager.getTransaction().commit();
		entityManager.close();
		Query q = entityManager.createQuery("FROM Feedback");
		List<Feedback> list=q.getResultList();
		assertNotNull(list);
		
	}
	@Test
	public void testAddFeedback1(Feedback feedback) {
		EntityManager entityManager =JPAUtil.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(feedback);
		entityManager.getTransaction().commit();
		entityManager.close();
		Query q = entityManager.createQuery("FROM Feedback");
		List<Feedback> list=q.getResultList();
		assertNull(list);
		
	}

	@Test
	public void testViewFeedback() {
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM Feedback");
		List<Feedback> list=q.getResultList();
		assertNotNull(list);
	}
	@Test
	public void testViewFeedback1() {
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM Feedback");
		List<Feedback> list=q.getResultList();
		assertNull(list);;
	}

}
