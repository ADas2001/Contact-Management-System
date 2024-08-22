package com.example.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.config.DAOSingleTon;
import com.example.entity.Contact;
import com.example.entity.User;

@WebServlet("/updatecontact")
public class UpdateContact extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contact contact=new Contact();
		HttpSession session = req.getSession(true);
		User user =(User)session.getAttribute("user");
		int contactid=Integer.parseInt(req.getParameter("contactid"));
		contact.setContactId(contactid);
		String contactname = req.getParameter("contactname");
		contact.setContactName(contactname);
		long contactnumber=Long.parseLong(req.getParameter("contactnumber"));
		contact.setContactNumber(contactnumber);
		contact.setUser(user);
		
		boolean result = DAOSingleTon.getContactDAO().updateContact(contact);
		if (result) {
			resp.sendRedirect("managecontact");
		}
	}
}
