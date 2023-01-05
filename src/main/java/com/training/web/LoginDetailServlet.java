package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.web.dao.LoginDao;
import com.training.web.dao.LoginDaoImpl;
import com.training.web.dao.ProductDao;
import com.training.web.dao.ProductDaoImpl;
import com.training.web.model.Product;
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
		ProductDao dao1 = new ProductDaoImpl();
		List<User> userList = dao.getUsers();
		List<Product> productList=dao1.getProducts();
		Product p1=new Product();

		out.print("<a href=\"/web-demo/add.html\">Add Product</a>");
		out.print("<a href=\"/web-demo/delete.html\">Delete Product</a>");
		out.print("<a href=\"/web-demo/update.html\">Update Product</a>");
		out.print("<table border='1'> <tr><th>Product Id</th><th>Product Name</th><th>Product Description</th><th>Price</th><th>Click for add Product</th>");
		
		for (Product product : productList) {
			out.print("<tr><td>"+product.getProdId()+"</td><td>"+product.getProdName()+"</td><td>"+product.getProdDesc()+"</td><td>"+product.getPrice()+"</td><td><a href='ProductDelete?id="+p1.getProdId()+"'>Delete</a></td><tr>");
			
			
			
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
