package com.ora.entity;


import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="UserInfo")
	public class User {
	
	@Id
	@Column (name="userid")
	private int userId;
	
	@Column (name="username")
	private String userName;
	
	
	
	@Column (name="userphonenumber")
	private BigInteger userPhoneNumber;
	
	
	
	@Column (name="useremailid")
	private String userEmailId;
	
	@Column (name="userpassword")
	private String userPassword;
	
	
	public User(int userId,String uname,String upass,String uemail,BigInteger phone){
		this.userId=userId;
		this.userName=uname;
		this.userPassword=upass;
		this.userEmailId=uemail;
		this.userPhoneNumber=phone;
		
		
			
			
		}

	public User() {
		super();
		
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public BigInteger getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(BigInteger userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	
	
	
}
