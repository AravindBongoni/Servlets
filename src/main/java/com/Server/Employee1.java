package com.Server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class Employee1
 */
@WebServlet("/Employee1")
public class Employee1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int salary = Integer.parseInt(request.getParameter("salary"));
		Employee employee = new Employee(name,id,salary);
		PrintWriter out = response.getWriter();
		if((InsertDetails.insert(employee))!=0) {
			out.print("Sucessful");
		}
		else {
			out.print("failure");
		}
		
	
		
		
		
		
	}
		
}
