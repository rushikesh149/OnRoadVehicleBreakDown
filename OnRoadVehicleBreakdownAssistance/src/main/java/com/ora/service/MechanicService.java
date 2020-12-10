package com.ora.service;


import java.util.List;

import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.entity.Service;

public interface MechanicService {
	public List<Service> viewRequest();
	public List<Feedback> viewFeedback();
	public boolean addMechanic(Mechanic mcn);
//	public Mechanic register(Mechanic mechanic);
//	public boolean login(int id,String pass);
//	public Mechanic logOut(Mechanic mechanic);

}