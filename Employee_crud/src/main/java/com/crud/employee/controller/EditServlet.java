package com.crud.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.employee.DAO.Employee_DAO;
import com.crud.employee.DTO.Employee;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		int userId = Integer.parseInt(id);
		
		List<Employee> arr = Employee_DAO.getEmployee(userId);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='ISO-8859-1'>");
		out.println("<title>View Employee Table</title>");
		out.println("<link rel='stylesheet' type='text/css' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Edit Employee</h1>");
		out.println("<div class='table-container'>");
		out.println("<form action='UpdateServlet' method='post'>");
		out.println("<table class='table'>");
		
		for(Employee e1:arr)
		{
			
			 out.println("<tr>  <td><input type='hidden' name='id' value='"+e1.getId()+"'></td> </tr>");
			 out.println("<tr> <td>Name :</td> <td><input type='text' name='name' value='"+e1.getName()+"'></td> </tr>");
			 out.println("<tr> <td>Password :</td> <td><input type='text' name='password' value='"+e1.getPwd()+"'></td> </tr>");
			 out.println("<tr> <td>Email :</td> <td><input type='email' name='email' value='"+e1.getEmail()+"'></td> </tr>");
		     out.println("<tr> <td>Country :</td> <td><select name='ctry' value='"+e1.getCountry()+"'><option>India</option><option>UAE</option><option>USA</option><option>US</option></select></td> </tr>");
		     
		}
		out.println("</table>");
		out.println("<div class='btn-container'>");
		out.println("<input type='submit' value='Edit Employee'>");
		out.println("<a href='employee.html'>Create new Employee</a>");
		out.println("</div>");
		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
