package com.training.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.web.model.Product;



public class ProductDaoImpl implements ProductDao{
	public List<Product> getProducts() {
		
		 List<Product> productList = new ArrayList<>();
		 Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 
	        //Scanner sc = new Scanner(System.in);
	        String url = "jdbc:mysql://localhost:3306/infinite";
	        String user = "root";
	        String pass = "india@123";
	        con = DriverManager.getConnection(url,user,pass);
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from PRODUCT order by product_desc");
	        while(rs.next()) {
	        	productList.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
	        	
	        }
	       
		 }  
	        catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return productList;

}
    public static int insert(Product p){  
        int status=0;  
        Connection con = null;
        try{  
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	String url = "jdbc:mysql://localhost:3306/infinite";
	        String user = "root";
	        String pass = "india@123";
	        con = DriverManager.getConnection(url,user,pass);
            PreparedStatement ps=con.prepareStatement(  
                         "insert into product(product_id,product_name,product_desc,price) values (?,?,?,?)");  
            ps.setInt(1,p.getProdId());  
            ps.setString(2,p.getProdName());  
            ps.setString(3,p.getProdDesc());  
            ps.setDouble(4,p.getPrice());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
    
    public static int delete(int id){  
        int status2=0; 
        Connection con = null;
        try{  
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	String url = "jdbc:mysql://localhost:3306/infinite";
	        String user = "root";
	        String pass = "india@123";
	        con = DriverManager.getConnection(url,user,pass);  
            PreparedStatement ps2=con.prepareStatement("delete from product where product_id=?");  
            ps2.setInt(1,id);  
            status2=ps2.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status2;  
    }
    
    
    
    
    public static int update(Product p){  
    	 int status3=0;  
    	 Connection con = null;
        try{ 
        	
        	Class.forName("com.mysql.cj.jdbc.Driver");
     	    String url = "jdbc:mysql://localhost:3306/infinite";
	        String user = "root";
	        String pass = "india@123"; 
            PreparedStatement ps=con.prepareStatement(  
                         "update product set product_name=?,product_desc=?,price=? where product_id=?");  
             
            ps.setString(1,p.getProdName());  
            ps.setString(2,p.getProdDesc());  
            ps.setDouble(3,p.getPrice()); 
            ps.setInt(5,p.getProdId());  
              
            status3=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status3;  
    }  
}
