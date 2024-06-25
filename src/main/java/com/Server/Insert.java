package com.Server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aravind","root","Aravind");
			String s = "insert into student values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(s);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3,pass);
			int r=pst.executeUpdate();
			if(r>0) {
				response.getWriter().println("Insertion Successful");
			}
			else {
				response.getWriter().println("Insertion Failed");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
