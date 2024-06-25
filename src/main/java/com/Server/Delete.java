package com.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String st =request.getParameter("email");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aravind"
					+ "","root","Aravind");
			String s = "delete from student where email=?";
			PreparedStatement pst = con.prepareStatement(s);
			pst.setString(1,st);
			int r = pst.executeUpdate();
			
			if(r>0) {
				out.print("Delete Successful");
			}
			else {
				out.print("Delete Failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
