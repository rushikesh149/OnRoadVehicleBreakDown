package com.ora.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ora.dao.MechanicDAO;
import com.ora.dao.MechanicDAOImpl;
import com.ora.dao.UserDAO;
import com.ora.dao.UserDAOImpl;
import com.ora.entity.Mechanic;

public class AdminServiceImplTest {

	MechanicDAO mda;
	UserDAO uda;
	@Before
	public void setUp()
	{
		mda=new MechanicDAOImpl();
		uda=new UserDAOImpl();
	}
	
	@After
	public void tearDown()
	{
		mda=null;
		uda=null;
	}
	
	@Test
	public void testViewMechanicDetails(Mechanic mcn) {
		
		assertTrue(mda.addMechanic(mcn));
	}
	@Test
	public void testViewMechanicDetails1(Mechanic mcn) {
		
		assertFalse(mda.addMechanic(mcn));
	}
	@Test
	public void testViewUserDetails() {
		assertNotNull(uda.viewUserDetails());
	}

}
