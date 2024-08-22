package com.example.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.config.DAOSingleTon;
import com.example.entity.Contact;

@WebServlet("/findcontact")
public class FindContact extends HttpServlet  {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int contactId = Integer.parseInt(req.getParameter("id"));
		Contact contact = DAOSingleTon.getContactDAO().findContactById(contactId);
		req.setAttribute("contact", contact);
		req.getRequestDispatcher("updatecontact.jsp").forward(req, resp);
	}
}
