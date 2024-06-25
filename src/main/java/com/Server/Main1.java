package com.Server;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main1
 */
@WebServlet("/Main1")
public class Main1 extends GenericServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int a = Integer.parseInt(arg0.getParameter("num1"));
		int b = Integer.parseInt(arg0.getParameter("num2"));
		arg1.getWriter().print(a-b);
		
	}

}
