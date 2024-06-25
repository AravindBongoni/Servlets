package com.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Jdbc")
public class Jdbc extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aravind","root","Aravind");
			String s = "select * from employee limit 2";
			PreparedStatement pst = con.prepareStatement(s);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				arg1.getWriter().println(rs.getInt(1)+" "+rs.getString(2));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}}
