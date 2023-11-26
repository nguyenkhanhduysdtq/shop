<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Nhập thông tín</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="http://localhost:8080/shop/css/styleSendEmail.css"  rel="stylesheet" />
</head>

<body>

<form action="http://localhost:8080/shop/addPlaceControll?pid=${pid}" method="post">
  <div class="container-login" >
    <div class="login-container">
       <img class="image-profile" alt="chưa co anh" src="https://tse3.mm.bing.net/th?id=OIP.dIF3iIIIuK5HeBCq_aoxZwAAAA&pid=Api&P=0&h=180"/>
      <div class="body-container">
        <div class="username" >
         <p>Họ và tên</p>
         <input type="text" name="username" required />
        </div>
        <div class="phone" >
         <p>Số điện thoại</p>
         <input type="text" name="phone" required />
        </div>
        
        <div class="street" >
         <p>Địa chỉ</p>
         <input type="text" name="street" required />
        </div>
        
        <div class="email" >
         <p>Email</p>
         <input type="text" name="email" required />
        </div>
      </div>
    
    <div class="body-button">
    <button type="submit">xác nhận</button>
    </div>
    
    </div>
  
  
  </div>
  
 
 </form>
 
</body>
</html>