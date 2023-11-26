package model;

import java.math.BigDecimal;

public class Product {
 private int id;
 
 private String name;
 
 private String description;
 
 private BigDecimal price ;
 
 private String  image;
 
 private int sell_id;
 
 private int quantity;
 
 private int cId;
 
 
 

public int getQuantity() {
	return quantity;
}



public void setQuantity(int quantity) {
	this.quantity = quantity;
}



public Product() {
	super();
}








public Product(int id, String name, String description, BigDecimal price, String image, int sell_id,
		int cId) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.price = price;
	this.image = image;
	this.sell_id = sell_id;
	this.cId = cId;
}



public int getcId() {
	return cId;
}



public void setcId(int cId) {
	this.cId = cId;
}



public int getId() {
	return id;
}




public void setId(int id) {
	this.id = id;
}




public String getName() {
	return name;
}




public void setName(String name) {
	this.name = name;
}




public String getDescription() {
	return description;
}




public void setDescription(String description) {
	this.description = description;
}




public BigDecimal getPrice() {
	return price;
}




public void setPrice(BigDecimal price) {
	this.price = price;
}




public String getImage() {
	return image;
}




public void setImage(String image) {
	this.image = image;
}





public int getSell_id() {
	return sell_id;
}



public void setSell_id(int sell_id) {
	this.sell_id = sell_id;
}



@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", image="
			+ image + ", sell_id=" + sell_id + "]";
}





 


 
 
}
