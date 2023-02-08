package com.crud.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.employee.DAO.Employee_DAO;
import com.crud.employee.DTO.Employee;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='ISO-8859-1'>");
		out.println("<title>View Employee Table</title>");
		out.println("<link rel='stylesheet' type='text/css' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='btn-container'>");
		out.println("<a href='employee.html'>Create new Employee</a>");
		out.println("</div>");
		out.println("<h1>Employee Table</h1>");
		out.println("<table class='table view-table'>");
		out.println("<tr> <th>ID</th> <th>NAME</th> <th>PASSWORD</th> <th>EMAIL</th> <th>COUNTRY</th> <th>EDIT</th> <th>DELETE</th> </tr>");
		List<Employee> arr = Employee_DAO.viewEmployee();
		for(Employee e1:arr)
		{
			out.println("<tr> <td>"+e1.getId()+"</td> <td>"+e1.getName()+"</td> <td>"+e1.getPwd()+"</td> <td>"+e1.getEmail()+"</td> <td>"+e1.getCountry()+"</td> <td><a href='EditServlet?id="+e1.getId()+"'>Edit</a></td> <td><a href='DeleteServlet?id="+e1.getId()+"'>Delete</a></td> </tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
