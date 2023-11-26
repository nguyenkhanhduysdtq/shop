<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gio hang</title>
<link href="http://localhost:8080/shop/css/style.css" rel="stylesheet" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style >

body{

background-color: white;
}

.cart{
padding-top:20px;

font-size: 20px;

width: 1500px;

height: auto;



}

.cart table tr td img{
width: 200px;
}

.cartTitle h1{
text-align: center;
font-family:"Times New Roman", Times, serif; 
}

.cart table{
width: 100%;

margin-bottom: 30px
}

.cart button{
 color: white;
 background-color: #FF4500;
 
 height: 40px;
 
 margin-bottom: 30px;
 
 cursor: pointer;
 
 font-size: 20px;

display: block;
margin-top: 30px;

width: 330px;
 
 
}

.cart button :hover{

background-color: white;

}

.cart table tr td input{
width: 40px;

outline: none;




}

.cart a{
color: red;
}

.cart h4{

margin-left: 970px;

 
}

hr{
 border: none;
}

h1{
border: 1px solid grey;

height: 70px;
padding-top: 5px;



}


</style>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div class="cartTitle">
	       <h1><img style="width: 40px; height: 40px ; margin-right: 10px" alt="" src="https://tse2.mm.bing.net/th?id=OIP.Rf_tvwaoBWL_LPUtB5iVAAHaHa&pid=Api&P=0&h=180">Cart</h1>
	  
	      </div>
	<div class="cart">
	  <form action="http://localhost:8080/shop/InputProfileControll?Paymoney=${paySumMoney}" method="post">
	  
	     <table class="CartIterm">
	     <c:forEach items="${list}" var="o">
	       <tr>
	         <td class="imageProduct" name="image" ><img alt="" src="${o.image}"></td>
	         <td class="nameProduct" name="name" style="margin-right: 20px">${o.name}</td>
	         <td>
	         <input style="width: 70px" type="number" name="quality" value="1" min="0"/>
	         </td>
	         <td class="price" style="font-weight: bold;">${o.price}$</td>
	         <td>
	          <a style=" margin-left : 40px" href="#" >Xóa</a>
	         </td>
	       
	       </tr>
	       
	       </c:forEach>
	       
	     
	     </table>
	     
	     <div class ="passMoney">
	       <div class="title">
	         <h3 style="background-color : grey; padding-top:5px ;padding-left :20px ;height: 40px ;width: 340px;font-size: 20px ; margin-bottom: 50px ; margin-top: 50px ; border: 1px solid grey; ">Thành tiền</h3>
	         </div>
	          <div class="SumMoney">
	           <p style="display: inline;">Tổng tiền hàng :</p>
	             <p style=" margin-left:130px ;font-weight :bold;display: inline;">${sumMoney}$</p>
	             <hr style="border: 1px solid grey; width: 300px" >
	             <p style="display: inline;">Phí di chuyển : </p>
	               <p style=" margin-left:120px ;font-weight :bold ;display: inline;">Free Ship</p>
	               <hr style="border: 1px solid grey; width: 300px">
	               <p style="display: inline;">VAT:</p>
	               <p style="margin-left:245px ;font-weight :bold;display: inline;">10%</p>
	               <hr style="border: 1px solid grey; width: 300px">
	               <p style="display: inline;">Tổng tiền thanh toán:</p>
	                <p style="margin-left:90px ;font-weight :bold;display: inline;">${paySumMoney}$</p>
	               <button id="btn-open" type="submit" class="mua" name="payMoney">Mua hàng</button> 
	               
	          </div>
               	      
	          
	      
	     
	     
	     </div>
	  </form>
	
	</div>
	 <hr>
	 <hr>
	 <hr>


	 
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>