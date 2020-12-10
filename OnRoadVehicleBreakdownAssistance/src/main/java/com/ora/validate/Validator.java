package com.ora.validate;

import javax.persistence.EntityManager;


import com.ora.entity.Mechanic;
import com.ora.entity.User;
import com.ora.exception.MechanicNotFoundException;
import com.ora.exception.UserNotFoundException;
import com.ora.util.JPAUtil;

public class Validator {
	
	EntityManager entityManager=JPAUtil.getEntityManager();
	public boolean validateAdmin(String adminId,String adminPassword) throws UserNotFoundException{
		boolean flag=false;
		
		try
		{
			if(adminId.equals("Admin") && adminPassword.equals("Admin123"))
			{
				System.out.println("Validated");
				flag=true;
			}
			else
			{
				throw new UserNotFoundException("User Not Found for Given User Name and Password");
			}
		}
		catch(UserNotFoundException e)
		{
			e.getMessage();
		}
		return flag;
	}
public boolean validateMechanic(int loginMechanicId,String loginPassword) throws UserNotFoundException{
	boolean flag=false;
		try
		{
			Mechanic mechanic = entityManager.find(Mechanic.class, loginMechanicId);
			
			if(loginMechanicId==mechanic.getMechanicId() && loginPassword.equals(mechanic.getMechanicPassword()))
			{
				System.out.println("Validated");
				flag=true;
			}
			else
			{
				throw new MechanicNotFoundException("Mechanic Not Found for Given Mechanic Name and Password");
			}
		}
		catch(MechanicNotFoundException e)
		{
			e.getMessage();
		}
		return flag;
	}

public boolean validateUser(int loginUserId,String loginPassword) throws UserNotFoundException{
	boolean flag=false;
		try
		{
			User user = entityManager.find(User.class, loginUserId);
			
			if(loginUserId==user.getUserId() && loginPassword.equals(user.getUserPassword()))
			{
				System.out.println("Validated");
				flag=true;
			}
			else
			{
				throw new UserNotFoundException("User Not Found for Given UserName and Password");
			}
		}
		catch(UserNotFoundException e)
		{
			e.getMessage();
		}
		return flag;
	}

	
	

}
