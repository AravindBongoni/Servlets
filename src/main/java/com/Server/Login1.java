package com.Server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Login1")
public class Login1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String username = "aravind1321";
	 String password = "naniavi@1321";
	 PrintWriter out = response.getWriter();
	 String s = request.getParameter("username");
	 String p = request.getParameter("password");
	 if(s.contentEquals(username)&&p.contentEquals(password)) {
	 RequestDispatcher rd = request.getRequestDispatcher("login2");
	 rd.forward(request,response);
	 }
	 else {
		 out.print("Invalid Credentials....please try agian");
		 response.setContentType("text/html");
		 RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		 rd.include(request,response);
	 }
	}

}
