package com.example.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.config.DAOSingleTon;
import com.example.entity.Contact;
import com.example.entity.User;

@WebServlet("/managecontact")
public class ManageContact extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		List<Contact> contacts = DAOSingleTon.getContactDAO().findAllContactByUser(user);
		req.setAttribute("contacts", contacts);
		req.getRequestDispatcher("managecontact.jsp").forward(req, resp);
	}
}
