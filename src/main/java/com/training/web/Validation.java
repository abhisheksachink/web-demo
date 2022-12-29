package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validation
 */
@WebServlet("/Validation")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String dob =request.getParameter("dob");
		String pass =request.getParameter("pass");
		String repass =request.getParameter("repass");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		if(firstName.equals("")){
			out.print("<h2>**Please enter First Name");
			
			RequestDispatcher rd = request.getRequestDispatcher("/register.html");
			rd.include(request, response);
		}
		else if(email.equals("")) {
			out.print("<h2>**Please enter Email");
			
			RequestDispatcher rd = request.getRequestDispatcher("/register.html");
			rd.include(request, response);
			
		}
		else if(dob.equals("")) {
			out.print("<h2>**Please enter Date of Birth");
			
			RequestDispatcher rd = request.getRequestDispatcher("/register.html");
			rd.include(request, response);
			
		}
		else if(!(pass.equals(repass))) {
			out.print("<h2>**Please enter Same Password");
			
			RequestDispatcher rd = request.getRequestDispatcher("/register.html");
			rd.include(request, response);
			
		}
		else {
			String userName=firstName+" "+lastName;
			
			request.setAttribute("user", userName);
			request.setAttribute("email", email);
			request.setAttribute("dob", dob);
			RequestDispatcher rd = request.getRequestDispatcher("WelcomeRegister");
			rd.forward(request, response);
			//response.sendRedirect("WelcomeServlet");
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
