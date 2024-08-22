package com.example.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleTon {
	private static EntityManagerFactory factory;

	private EMFSingleTon()
	{

	}

	public static synchronized EntityManagerFactory getFactory() {
		if(factory==null)
		{
			factory=Persistence.createEntityManagerFactory("contact");
		}
		return factory;
	}
}
