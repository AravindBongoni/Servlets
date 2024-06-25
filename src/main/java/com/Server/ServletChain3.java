package com.Server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletChain3")
public class ServletChain3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("3)Good   ");
		RequestDispatcher rd = request.getRequestDispatcher("ServletChain4");
		rd.include(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
