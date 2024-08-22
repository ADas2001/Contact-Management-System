package com.example.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.config.DAOSingleTon;
import com.example.entity.User;

@WebServlet("/register")
public class RegisterUser extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String userName = req.getParameter("username");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			User user=new User();
			user.setUserName(userName);
			user.setEmail(email);
			user.setPassword(password);
			
			boolean result = DAOSingleTon.getUserDAO().saveUser(user);
			
			if (result) {
				resp.sendRedirect("login.jsp");
			}
			else {
				
			}
		}
}
