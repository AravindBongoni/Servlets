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

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		ServletContext context = config.getServletContext();
		PrintWriter out = response.getWriter();
		try {
			Class.forName(context.getInitParameter("Driver"));
			Connection con = DriverManager.getConnection(context.getInitParameter("url"),context.getInitParameter("username"),context.getInitParameter("password"));
			String q = "insert into student values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, "avi");
			pst.setString(2,"aravind123@gmail.com");
			pst.setString(3, "avi@345");
			int r = pst.executeUpdate();
			if(r>0) {
				out.print("Insert SucessFull");
			}
			else {
				out.print("Insert Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
