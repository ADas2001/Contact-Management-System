package com.example.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.config.DAOSingleTon;
import com.example.entity.User;

@WebServlet("/updateuser")
public class UpdateUser extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user=new User();
		
		int id = Integer.parseInt(req.getParameter("userid"));
		user.setUserId(id);
		
		String username = req.getParameter("username");
		user.setUserName(username);
		
		String email = req.getParameter("email");
		user.setEmail(email);
		
		String password = req.getParameter("password");
		user.setPassword(password);
		
		boolean result = DAOSingleTon.getUserDAO().updateUser(user);
		
		if (result) {
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user);
			resp.sendRedirect("manageprofile.jsp");
		}
	}
}
