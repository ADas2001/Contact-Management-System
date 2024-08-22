package com.example.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.config.DAOSingleTon;

@WebServlet("/deletecontact")
public class DeleteContact extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		boolean result = DAOSingleTon.getContactDAO().deleteContact(id);
		if (result) {
			resp.sendRedirect("managecontact");		}
	}
}
