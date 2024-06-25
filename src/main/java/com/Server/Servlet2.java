package com.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		ServletContext context = config.getServletContext();
		PrintWriter out = response.getWriter();
		try {
			Class.forName(context.getInitParameter("Driver"));
			Connection con = DriverManager.getConnection(context.getInitParameter("url"),context.getInitParameter("username"),context.getInitParameter("password"));
			String query = "delete from student where email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, "aravind13@gmail.com");
			int r = pst.executeUpdate();
			if(r>0) {
				out.println("Deletion successful");
			}else {
				out.println("Deletion failed");
			}
		} catch (Exception e) {		
			e.printStackTrace();
		}
		//doGet(request, response);
	}

}