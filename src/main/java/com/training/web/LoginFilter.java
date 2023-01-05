package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import com.training.web.service.LoginService;
import com.training.web.service.LoginServiceImpl;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		String userName = request.getParameter("uName");
		String password1 = request.getParameter("pasw");
	
		LoginService service = new LoginServiceImpl();
		

		if(userName.equals("") || password1.equals("")) {
//			out.print("<h2>**Please enter username and password**</h2> <br>");
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.include(request, response);
				
		}
		
		else if(service.isValidUser(userName, password1)) {
			request.setAttribute("user1", userName);
			chain.doFilter(request, response);

		}
		
		
		else {
//			out.print("<h2>** Incorrect Login Credentials **</h2> ");
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
