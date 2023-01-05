package com.training.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.web.service.LoginService;
import com.training.web.service.LoginServiceImpl;

/**
 * Servlet implementation class jspLogin
 */
@WebServlet("/jspLogin")
public class jspLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jspLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userid");
		String phone = request.getParameter("phone");

		LoginService service = new LoginServiceImpl();
		if(((LoginServiceImpl) service).isValidUser(userId, phone)) {
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.include(request, response);


		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.include(request, response);
			
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
