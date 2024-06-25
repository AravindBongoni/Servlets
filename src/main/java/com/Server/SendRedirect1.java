package com.Server;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SendRedirect1")
public class SendRedirect1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = "aravind123";
		String password = "avi1321";
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		if(un.contentEquals(username)&& pass.contentEquals(password)){	
			response.sendRedirect("SendRedirect2");
		}
		else {
			response.getWriter().print("Invalid Credentails..please try again");
			response.sendRedirect("Login.html");
				
		}
		
	}

}
