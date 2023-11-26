package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DbContext;
import model.Product;

public class ProductDao {

	Connection c=null;
	
	PreparedStatement ps=null;
	
	
	public List<Product> listProduct(){
		c=DbContext.getConnect();
		try {
			String query="select *\r\n"
					+ "   from product";
			
			ps=c.prepareStatement(query);
		
			
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
	
	
	public Product getProductId(String id){
		c=DbContext.getConnect();
		try {
			String query="select *\r\n"
					+ "    from product\r\n"
					+ "    where id= ?";
			
			ps=c.prepareStatement(query);
		
			ps.setString(1,id);
			 ResultSet rs=ps.executeQuery();
			 Product product = null;
			 while(rs.next()) {
			
			 product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4),rs.getString(6),rs.getInt(7),rs.getInt(5));
			
			 }
			return  product;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	
	public List<Product> searchProduct(String name){
		c=DbContext.getConnect();
		
		String query=" select * from product  where name like ? ";
		
		try {
			ps=c.prepareStatement(query);
			ps.setString(1, "%"+name+"%");
			
			ResultSet rs= ps.executeQuery();
			
		 List<Product> list=new ArrayList<Product>();
		 
		 while(rs.next()) {
			Product product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4),rs.getString(6),rs.getInt(7),rs.getInt(5));
			list.add(product);
		 }
		 
		 return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	public List<Product> getProductSellId(String id){
		c=DbContext.getConnect();
		try {
			String query="select *\r\n"
					+ "    from product\r\n"
					+ "    where sell_ID= ?";
			
			ps=c.prepareStatement(query);
		
			ps.setString(1,id);
			 ResultSet rs=ps.executeQuery();
			 List<Product> list=new ArrayList<Product>();
			 while(rs.next()) {
			
				 Product  product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4),rs.getString(6),rs.getInt(7),rs.getInt(5));
			  list.add(product);
			 }
			return  list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	
	public void deleteProductId(String id) {
		c=DbContext.getConnect();
		
		String query="delete from product \r\n"
				+ "    where id=?";
		
		try {
			ps=c.prepareStatement(query);
			
			ps.setString(1,id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void updateProduct(String id,String name,String description,String price,String image,String cId) {
		   c= DbContext.getConnect();
		   
		   String query="update product \r\n"
		   		+ "set name=?,description=?,price=?,image=?,category_id=?\r\n"
		   		+ "where id=?\r\n"
		   		+ "";
		   try {
			ps=c.prepareStatement(query);
			
			ps.setString(1,name);
			ps.setString(2,description);
			ps.setString(3,price);
			ps.setString(4,image);
			ps.setString(5, cId);
			ps.setString(6,id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   
	}
	
	
	public void insertProduct(String name,String description,String price,String category,String image,String aId){
		
		c=DbContext.getConnect();
		
		String query="insert into product(name,description,price,category_id,image,sell_id)\r\n"
				+ "   values(?,?,?,?,?,?)";
		
		
		try {
			ps=c.prepareStatement(query);
			
			ps.setString(1,name);
			ps.setString(2,description);
			ps.setString(3,price);
			ps.setString(4,category);
			ps.setString(5,image);
			ps.setString(6,aId);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getQuantityProduct() {
		
		c=DbContext.getConnect();
		
		String query=" select max(k.r)\r\n"
				+ "   from (select row_number() over(order by id) as r  , id \r\n"
				+ "from product) as k;";
		
		
		try {
			ps=c.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
		
	
	public List<Product> pagingProduct(int index,int page,int parameter){
		
		c=DbContext.getConnect();
		
		String query="select *\r\n"
				+ "from (select *,row_number() over(order by id) as r \r\n"
				+ "from product) as k\r\n"
				+ "where r between ?*?-? and ?*?"; 
		
		try {
			ps=c.prepareStatement(query);
			
			ps.setInt(1, index);
			ps.setInt(2, page);
			ps.setInt(3,parameter);
			ps.setInt(4, index);
			ps.setInt(5, page);
			
			
			
			
			
			
			ResultSet rs=ps.executeQuery();
			
			List<Product> list=new ArrayList<Product>();
			
			while(rs.next()) {
				 Product  product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4),rs.getString(6),rs.getInt(7),rs.getInt(5));
				 
			list.add(product);
			
			
			
			}
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int getQuantityProductSellId(String id) {
		
		c=DbContext.getConnect();
		
		String query="select count(*)\r\n"
				+ "from product\r\n"
				+ "where sell_ID=?";
		
		
		try {
			ps=c.prepareStatement(query);
			
			ps.setString(1,id);
			 ResultSet rs=  ps.executeQuery();
			
			 while(rs.next()) {
				 return rs.getInt(1);
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	
public List<Product> pagingProductSellId(int index,int page,int parameter ,int id){
		
		c=DbContext.getConnect();
		
		String query="select *\r\n"
				+ "from (select *,row_number() over(order by id) as r \r\n"
				+ "from product WHERE sell_ID=? ) as k\r\n"
				+ "where r between ?*?-? and ?*?"; 
		
		try {
			ps=c.prepareStatement(query);
			
			ps.setInt(1, id);
			ps.setInt(2, index);
			ps.setInt(3,page);
			ps.setInt(4, parameter);
			ps.setInt(5, index);
			ps.setInt(6,page);
			
			
			
			
			
			
			ResultSet rs=ps.executeQuery();
			
			List<Product> list=new ArrayList<Product>();
			
			while(rs.next()) {
				 Product  product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4),rs.getString(6),rs.getInt(7),rs.getInt(5));
				 
			list.add(product);
			
			
			
			}
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

public List<Product> get5ProductCid(int cId){
	c=DbContext.getConnect();
	
	String query="select*\r\n"
			+ "from product\r\n"
			+ "where category_id =?\r\n"
			+ "limit 5";
	
	try {
		ps=c.prepareStatement(query);
		
		ps.setInt(1, cId);
		
		 ResultSet rs= ps.executeQuery();
		 
		 List<Product> list=new ArrayList<Product>();
		 
		 while(rs.next()) {
			 Product  product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4),rs.getString(6),rs.getInt(7),rs.getInt(5));
			 
			 list.add(product);
			 
		 }
		return list;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return null;
	
}
	
}
