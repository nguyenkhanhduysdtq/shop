package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DbContext;
import model.Category;
import model.Product;

public class CategoryDao {
 Connection c=null;
 
  PreparedStatement ps=null;
 
 
 public List<Category> getAllCatgory(){
	 
	 try {
		c=DbContext.getConnect();
		
		String query=" select *\r\n"
				+ "    from category;";
		
		ps=c.prepareStatement(query);
		
		ResultSet rs= ps.executeQuery();
		
		List<Category> list=new ArrayList<Category>();
		
		while(rs.next()) {
			
			Category c=new Category(rs.getInt(1),rs.getString(2),rs.getString(4));
			
			list.add(c);
		}
		
		return list;
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 
	 return null;
 }
 
 
 public List<Product> getProductCateId(String id){
		c=DbContext.getConnect();
		try {
			String query=" select *\r\n"
					+ "    from product\r\n"
					+ "    where category_id= ?";
			
			ps=c.prepareStatement(query);
			
			ps.setString(1,id);
		
			
			ResultSet rs =ps.executeQuery();
			
			List<Product> pr=new ArrayList<Product>();
			
			while(rs.next()) {
				Product c= new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4),rs.getString(6),rs.getInt(7),rs.getInt(5));
				
				pr.add(c);
				
				
			}
			return pr;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
 
 public Category findOnebyID(int id) { 
	 c=DbContext.getConnect();
	 
	 String query="select * from category where id = ?";
	 
	 try {
		ps=c.prepareStatement(query);
		 ps.setInt(1,id);
		 
		 ResultSet rs=ps.executeQuery();
		 
		 while(rs.next()) {
			 return new Category(rs.getInt(1),rs.getString(2),rs.getString(3));
			 
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 
	 return null;
 }

}
