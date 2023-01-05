package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.training.web.dao.ProductDao;
import com.training.web.dao.ProductDaoImpl;
import com.training.web.model.Product;

/**
 * Servlet Filter implementation class updateFilter
 */
@WebFilter("/updateServlet")
public class updateFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public updateFilter() {
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
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		int prodId=Integer.parseInt(request.getParameter("prodId"));
		String prodName=request.getParameter("prodName");
		
		String prodDesc = request.getParameter("prodDesc");
		int price = Integer.parseInt(request.getParameter("price"));

		ProductDao dao1 = new ProductDaoImpl();
		List<Product> productList=dao1.getProducts();
		Product p=new Product(prodId,prodName,prodDesc,price);
        int status3=ProductDaoImpl.update(p);
        
        if(status3>0){  
            out.print("<p>Record updated successfully!</p>");  
//            int pid=123;
            out.print("<table border='1'> <tr><th>Product Id</th><th>Product Name</th><th>Product Description</th><th>Price</th><th>Click for Delete Product</th>");
            for (Product product : productList) {
    			out.print("<tr><td>"+product.getProdId()+"</td><td>"+product.getProdName()+"</td><td>"+product.getProdDesc()+"</td><td>"+product.getPrice()+"</td><td><a href='ProductDelete?prod_id='"+product.getProdId()+"\">Delete</a></td><tr>");

            }
            out.print("</table>");
        }else{  
            out.println("Sorry! unable to update record");  
            RequestDispatcher rd = request.getRequestDispatcher("/web-demo/LoginFilter");
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
