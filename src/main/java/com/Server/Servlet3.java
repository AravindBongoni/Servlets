package com.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		ServletContext context = config.getServletContext();
		PrintWriter out = response.getWriter();
		try {
			Class.forName(context.getInitParameter("Driver"));
			Connection con = DriverManager.getConnection(context.getInitParameter("url"),context.getInitParameter("username"),context.getInitParameter("password"));
			String query = "select * from student where email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, "reddy56@gmail.com");
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				out.print("Name: "+rs.getNString(1)+"|| e-mail: "+rs.getNString(2)+"|| Password: "+rs.getNString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}	
}