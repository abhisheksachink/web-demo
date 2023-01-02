package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import com.training.web.dao.LoginDao;
import com.training.web.dao.LoginDaoImpl;
import com.training.web.dao.ProductDao;
import com.training.web.dao.ProductDaoImpl;
import com.training.web.model.Product;
import com.training.web.model.User;
import com.training.web.service.LoginService;
import com.training.web.service.LoginServiceImpl;

/**
 * Servlet Filter implementation class Product
 */
@WebFilter("/ProductServlet")
public class ProductFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public ProductFilter() {
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
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		int prodId=Integer.parseInt(request.getParameter("prodId"));
		String prodName=request.getParameter("prodName");
		
		String prodDesc = request.getParameter("prodDesc");
		int price = Integer.parseInt(request.getParameter("price"));

		ProductDao dao1 = new ProductDaoImpl();
		List<Product> productList=dao1.getProducts();
		Product p=new Product(prodId,prodName,prodDesc,price);
        int status=ProductDaoImpl.insert(p);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
//            int pid=123;
            out.print("<table border='1'> <tr><th>Product Id</th><th>Product Name</th><th>Product Description</th><th>Price</th><th>Click for Delete Product</th>");
            for (Product product : productList) {
    			out.print("<tr><td>"+product.getProdId()+"</td><td>"+product.getProdName()+"</td><td>"+product.getProdDesc()+"</td><td>"+product.getPrice()+"</td><td><a href='ProductDelete?prod_id='"+product.getProdId()+"\">Delete</a></td><tr>");

            }
            out.print("</table>");
        }else{  
            out.println("Sorry! unable to save record");  
            RequestDispatcher rd = request.getRequestDispatcher("/web-demo/LoginFilter");
			rd.include(request, response);
        }  
//        if(status2>0){  
//            out.print("<p>Record deleted successfully!</p>");  
////            int pid=123;
//            out.print("<table border='1'> <tr><th>Product Id</th><th>Product Name</th><th>Product Description</th><th>Price</th><th>Click for Delete Product</th>");
//            for (Product product : productList) {
//    			out.print("<tr><td>"+product.getProdId()+"</td><td>"+product.getProdName()+"</td><td>"+product.getProdDesc()+"</td><td>"+product.getPrice()+"</td><td><a href=\"/ProductDelete\">Delete</a></td><tr>");
//
//            }
//            out.print("</table>");
//        }else{  
//            out.println("Sorry! unable to delete record");  
//            RequestDispatcher rd = request.getRequestDispatcher("/web-demo/LoginFilter");
//			rd.include(request, response);
//        }
        out.close();  


//        p.getProdId()
		
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
