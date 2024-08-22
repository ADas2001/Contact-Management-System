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

@WebServlet("/deleteuser")
public class DeleteUser extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		User user=(User)session.getAttribute("user");
		
		
		boolean result = DAOSingleTon.getUserDAO().deleteUser(user.getUserId());
		if (result) {
			//session.removeAttribute("user");
			session.invalidate();
			resp.sendRedirect("index.jsp");
		}
		else {
			
		}
	}
}
