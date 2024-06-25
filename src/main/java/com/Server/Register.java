package com.Server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out =response.getWriter();
		Student s = new Student(name, email, password);
		if(InsertStudentDetails.insert(s)>0) {
			out.println("insert sucessful");
		}
		else{
			out.println("Insertion Failed");
		}
	}

}
