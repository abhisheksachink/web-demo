package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.web.dao.LoginDao;
import com.training.web.dao.LoginDaoImpl;
import com.training.web.model.User;

/**
 * Servlet implementation class LoginDetailServlet
 */
@WebServlet("/LoginFilter")
public class LoginDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user = (String)request.getAttribute("user1");
		out.print("<h1>Welcome "+user+"! You are successfully logged in </h1>");
		LoginDao dao = new LoginDaoImpl();
		List<User> userList = dao.getUsers();
		out.print("<table> <tr><th>UserName</th><th>Password</th>");
		
		for (User user2 : userList) {
			out.print("<tr><td>"+user2.getUserName()+"</td><td>"+user2.getPassword()+" </td><tr>");
			
			
//			if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
//				isValid = true;
//			}
		}
		out.print("</table>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
