package com.example.config;

import com.example.dao.ContactDao;
import com.example.dao.UserDao;

public class DAOSingleTon {
	private static UserDao userDao;
	private static ContactDao contactDao;
	
	private DAOSingleTon() {
		
	}
	
	public static synchronized UserDao getUserDAO() {
		if(userDao==null)
		{
			userDao=new UserDao();
		}
		return userDao;
	}
	
	public static synchronized ContactDao getContactDAO() {
		if(contactDao==null)
		{
			contactDao=new ContactDao();
		}
		return contactDao;
	}
	
}
