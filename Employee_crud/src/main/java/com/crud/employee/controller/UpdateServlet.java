package com.crud.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.employee.DAO.Employee_DAO;
import com.crud.employee.DTO.Employee;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		int userId = Integer.parseInt(id);
		String name = request.getParameter("name");
		String pswd = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("ctry");
		
		Employee e1 = new Employee();
		e1.setId(userId);
		e1.setName(name);
		e1.setPwd(pswd);
		e1.setEmail(email);
		e1.setCountry(country);
		
		int i = Employee_DAO.updateEmployee(e1);
		
		if(i > 0) {
			response.sendRedirect("ViewServlet");
		}else {
			request.getRequestDispatcher("EditServlet.java").forward(request, response);
			out.println("<h3 style='margin:20px 0;color:green;'>Employee Update failed</h3>");
		}
	}

}
