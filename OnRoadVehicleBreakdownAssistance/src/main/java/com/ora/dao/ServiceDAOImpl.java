package com.ora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.ora.entity.Mechanic;
import com.ora.entity.Service;
import com.ora.entity.User;
import com.ora.exception.EmptyListException;
import com.ora.service.MechanicServiceImpl;
import com.ora.util.JPAUtil;

public class ServiceDAOImpl implements ServiceDAO{
	final static Logger logger = Logger.getLogger(ServiceDAOImpl.class);
	public boolean addService(Service service) {
		logger.info("Adding service");
		EntityManager entityManager =JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(service);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	public List<Service> viewService(){
		logger.info("Viewing Service");
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM Service");
		List<Service> list=q.getResultList();
		try{if(list.equals(null))
		{
			 throw new EmptyListException("Service not Found");
		}
		}
		catch(EmptyListException e)
		{
			logger.error(e);
		}
		finally {	return list;}
		
		
	
	}
	

}
