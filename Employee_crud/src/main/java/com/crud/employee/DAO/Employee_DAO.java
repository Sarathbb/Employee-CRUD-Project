package com.crud.employee.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crud.employee.DTO.Employee;

public class Employee_DAO
{
	public static Connection getConnection()
	{
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employee_crud";
			conn = DriverManager.getConnection(url,"root","admin@123");
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
	
    public static int saveEmployee(Employee e1)
    {
    	int i = 0;
  
    	try {
			Connection conn = Employee_DAO.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into employee_table(Name,Password,Email,Country) values(?,?,?,?)");
			pstmt.setString(1, e1.getName());
			pstmt.setString(2, e1.getPwd());
			pstmt.setString(3, e1.getEmail());
			pstmt.setString(4, e1.getCountry());
			
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
    	return i;
    }
    public static List<Employee> viewEmployee()
    {
    	Connection conn = Employee_DAO.getConnection();
    	ArrayList<Employee> arr = new ArrayList<Employee>();
    	try {
			PreparedStatement pstmt = conn.prepareStatement("select * from employee_table");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Employee e1 = new Employee();
				e1.setId(rs.getInt(1));
				e1.setName(rs.getString(2));
				e1.setPwd(rs.getString(3));
				e1.setEmail(rs.getString(4));
				e1.setCountry(rs.getString(5));
				
				arr.add(e1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return arr;
    }
    public static int deleteEmployee(int id)
    {
    	int i = 0;
    	Connection conn = Employee_DAO.getConnection();
    	try {
			PreparedStatement pstmt = conn.prepareStatement("delete from employee_table where id = ?");
			pstmt.setInt(1, id);
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
    	return i;
    }
    public static List<Employee> getEmployee(int id)
    {
    	Connection conn = Employee_DAO.getConnection();
    	ArrayList<Employee> arr = new ArrayList<Employee>();
    	try {
			PreparedStatement pstmt = conn.prepareStatement("select * from employee_table where id = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Employee e1 = new Employee();
				e1.setId(rs.getInt(1));
				e1.setName(rs.getString(2));
				e1.setPwd(rs.getString(3));
				e1.setEmail(rs.getString(4));
				e1.setCountry(rs.getString(5));
				
				arr.add(e1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
    	return arr;
    }
    public static int updateEmployee(Employee e1)
    {
    	int i = 0;
    	Connection conn = Employee_DAO.getConnection();
    	try {
			PreparedStatement pstmt = conn.prepareStatement("update employee_table set Name = ?,Password = ?,Email = ?,Country = ? where Id = ?");
			pstmt.setString(1, e1.getName());
			pstmt.setString(2, e1.getPwd());
			pstmt.setString(3, e1.getEmail());
			pstmt.setString(4, e1.getCountry());
			pstmt.setInt(5, e1.getId());
			
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
    	return i;
    }

	
}
