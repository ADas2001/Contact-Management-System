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

@WebServlet("/login")
public class LoginUser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		try {
		User user = DAOSingleTon.getUserDAO().findUserByEmailAndPassword(email,password);
		if (user!=null) {
			HttpSession session = req.getSession(true);
			List<Contact> contacts = DAOSingleTon.getContactDAO().findAllContactByUser(user);
			session.setAttribute("user", user);
			session.setAttribute("contacts", contacts);
			//resp.sendRedirect("index.jsp");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		}
		catch (Exception e) {
			req.setAttribute("error", "Email or Password Is Incorrect!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
