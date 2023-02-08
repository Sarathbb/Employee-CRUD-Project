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


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String pswd = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("ctry");
		
		Employee e = new Employee();
		
		if(name.isEmpty()==false && pswd.isEmpty()==false && email.isEmpty()==false && country.isEmpty()==false)
		{
			e.setName(name);
			e.setPwd(pswd);
			e.setEmail(email);
			e.setCountry(country);
		}
		else {
			request.getRequestDispatcher("employee.html").forward(request, response);
			out.println("<h3 style='margin:20px 0;color:red;'>Please fill the fields!!!</h3>");
		}
		
		
		int i = Employee_DAO.saveEmployee(e);
		
		if(i > 0) {
			request.getRequestDispatcher("employee.html").include(request, response);
			out.println("<h3 style='margin:20px 0;color:green;'>Employee saved successfully</h3>");
		}else {
			request.getRequestDispatcher("employee.html").include(request, response);
			out.println("Sorry!!!Employee saved failed");
		}
	}

}
