package com.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				ServletConfig sc = getServletConfig();
				PrintWriter out = response.getWriter();
				try {
					Class.forName("Driver");
					Connection con = DriverManager.getConnection(sc.getInitParameter("url"),sc.getInitParameter("username"),sc.getInitParameter("password"));
					String query = "select * from employee";
					PreparedStatement pst = con.prepareStatement( query );
					ResultSet res =	pst.executeQuery();
					while(res.next()) {
						out.println("id: "+res.getInt(1)+"name: "+res.getString(2)+"Salary: "+res.getInt(3));
					}
					pst.close();
					con.close();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
	}

}
