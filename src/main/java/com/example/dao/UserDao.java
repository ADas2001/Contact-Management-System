package com.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.example.config.EMFSingleTon;
import com.example.entity.User;

public class UserDao {
	
	public boolean saveUser(User user) {
		EntityManager manager = EMFSingleTon.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			manager.close();
		}
	}
	
	public boolean updateUser(User user) {
		EntityManager manager = EMFSingleTon.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(user);
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
	
	public boolean deleteUser(int userId) {
		EntityManager manager = EMFSingleTon.getFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			User user = manager.find(User.class, userId);
			manager.remove(user);
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
	
	public User findUser(int userId) {
		EntityManager manager = EMFSingleTon.getFactory().createEntityManager();
		User user = manager.find(User.class, userId);
		manager.close();
		return user;
	}

	public User findUserByEmailAndPassword(String email, String password) {
		EntityManager manager = EMFSingleTon.getFactory().createEntityManager();
		TypedQuery<User> query = manager.createQuery("from User where email=:email and password=:password",User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		User user = query.getSingleResult();
		return user;
	}
}
