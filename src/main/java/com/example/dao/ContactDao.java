package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.example.config.EMFSingleTon;
import com.example.entity.Contact;
import com.example.entity.User;

public class ContactDao {
	
	public boolean saveContact(Contact contact) {
		EntityManager manager = EMFSingleTon.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(contact);
			transaction.commit(); 
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			manager.close();
		}
	}
	
	public boolean updateContact(Contact contact) {
		EntityManager manager = EMFSingleTon.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(contact);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			manager.close();
		}
	}
	
	public boolean deleteContact(int contactId) {
		EntityManager manager = EMFSingleTon.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Contact contact = manager.find(Contact.class, contactId);
			manager.remove(contact);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			manager.close();
		}
	}
	
	public List<Contact> findAllContactByUser(User user) {
		EntityManager manager = EMFSingleTon.getFactory().createEntityManager();
		TypedQuery<Contact> query = manager.createQuery("from Contact where user=?1",Contact.class);
		query.setParameter(1, user);
		List<Contact> contacts = query.getResultList();
		manager.close();
		return contacts;
	}

	public Contact findContactById(int contactId) {
		EntityManager manager = EMFSingleTon.getFactory().createEntityManager();
		Contact contact = manager.find(Contact.class, contactId);
		manager.close();
		return contact;
	}
}
