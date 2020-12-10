package com.ora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ora.entity.Mechanic;
import com.ora.entity.Service;
import com.ora.entity.User;
import com.ora.util.JPAUtil;

public class ServiceDAOImpl implements ServiceDAO{

	public boolean addService(Service service) {
		EntityManager entityManager =JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(service);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	public List<Service> viewService(){
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM Service");
		List<Service> list=q.getResultList();
		
		return list;
	}
	

}
