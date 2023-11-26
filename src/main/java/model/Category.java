package model;

public class Category {
 private int id;
 private String name;
 
 private String cImage;
 
 
 
 
 

public Category() {
	super();
}



public Category(int id, String name, String cImage) {
	super();
	this.id = id;
	this.name = name;
	this.cImage = cImage;
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



public String getcImage() {
	return cImage;
}



public void setcImage(String cImage) {
	this.cImage = cImage;
}



@Override
public String toString() {
	return "Category [id=" + id + ", name=" + name + ", cImage=" + cImage + "]";
}





 
 
 
}
