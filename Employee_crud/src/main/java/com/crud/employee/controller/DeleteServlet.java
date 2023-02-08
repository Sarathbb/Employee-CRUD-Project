package com.crud.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.employee.DAO.Employee_DAO;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		int userId = Integer.parseInt(id);
		
		int i = Employee_DAO.deleteEmployee(userId);
		
		if(i > 0) {
			response.sendRedirect("ViewServlet");
		}else {
			request.getRequestDispatcher("ViewServlet.java").forward(request, response);
			out.println("<h3 style='margin:20px 0;color:green;'>Employee saved successfully</h3>");
		}
	}

}
