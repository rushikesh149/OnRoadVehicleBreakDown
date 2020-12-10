package com.ora.service;
import com.ora.dao.*;
import java.util.List;

import org.apache.log4j.Logger;

import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.entity.Service;
public class MechanicServiceImpl implements MechanicService {
	final static Logger logger = Logger.getLogger(MechanicServiceImpl.class);
	MechanicDAO dao;
	ServiceDAO sd=new ServiceDAOImpl();
	FeedbackDAO fd=new FeedbackDAOImpl();
	public MechanicServiceImpl()
	{
		dao= new MechanicDAOImpl();
	}
	public List<Service> viewRequest() {
		logger.info("Viewing request");
		return sd.viewService();
		
	}
	public List<Feedback> viewFeedback() {
		logger.info("ViewingFeedback");
		return fd.viewFeedback();
		
	}
	public boolean addMechanic(Mechanic mcn){
		dao.addMechanic(mcn);
		return true;
}
public boolean login(int id, String pass) {
	
	//	return dao.login(id, pass);
		return false;
	}

	public Mechanic logOut(Mechanic mechanic) {

		//return dao.logOut(mechanic);
		return null;
	}
	
	

}