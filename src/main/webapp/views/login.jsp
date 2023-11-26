<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="http://localhost:8080/shop/css/styleLogin.css">
<link href="http://localhost:8080/shop/css/style.css" rel="stylesheet" />

<style type="text/css">

.text-danger{
padding-left: 220px;
}


body {
	background-color: #ffccd5
}



</style>

</head>
<body>
<header style="background-color: #ffccd5">
  
  <img style=" width: 90px; height: 90px" alt="" src="https://static.mediacdn.vn/marketingai.vn/image/logo.svg">
  <p style="font-weight: bold;text-transform: uppercase;color: #FF9900;display: inline; margin-left: 10px;margin-right: 30px;font-size: 30px">Shop.vn</p>
  <p style="display: inline; font-size: 25px;font-weight: bold;">Đăng nhập</p>
  <a style="margin-left: 900px ;display: inline;color: black" href="#">bạn cần giúp đỡ?</a>
  
  </header>
	
	
	
	<div style="display:flex; background-color: #fc7400" class="row">
	
	
	<img  style="width: 500px;height: 500px;margin-left: 250px;margin-top: 50px" alt="" src="https://gudlogo.com/wp-content/uploads/2019/04/logo-mau-cam-26.png">
	 
	
	<div style="margin-left: 300px; height: 500px" id="logreg-forms">
		<form action="http://localhost:8080/shop/LoginControll" method="post">
			<h1  class="h3 mb-3 font-weight-normal" style="">
				Đăng nhập <a style="color: red;font-size: 15px;display: inline; margin-left: 30px" href="#">đăng nhập mã QR <img style="width: 40px;height: 40px" alt="" src="https://i.vdoc.vn/data/image/2017/11/23/cach-tao-ma-qr-code.png"></a> </h1>
			<input type="text"  value="${user}"   name="username" id="inputUsername" class="form-control"
				placeholder="Username" required="" autofocus="" style="margin-bottom: 30px;margin-top: 40px;"> <input
				type="password" name="password" id="inputPassword" class="form-control"
				placeholder="Password" required="">
				
			<p class="text-danger">${check}</p>

			<button class="btn btn-success btn-block" type="submit" style="background-color : #FF9900">
				<i class="fas fa-sign-in-alt"></i>ĐĂNG NHẬP
			</button>
			<a href="#" id="forgot_pswd" style="text-decoration: none;">Quên mật khẩu?</a>
	
			
			<!-- <p>Don't have an account!</p>  -->
			
		</form>
		
		<form action="http://localhost:8080/shop/views/signup.jsp">
		<button style="margin-top: 50px" class="btn btn-primary btn-block" type="submit"
				id="btn-signup">
				<i class="fas fa-user-plus"></i> Đăng ký tài khoản
			</button>
		</form>
		
		
		
	

		<form action="/reset/password/" class="form-reset">
			<input type="email" id="resetEmail" class="form-control"
				placeholder="Email address" required="" autofocus="">
			<button class="btn btn-primary btn-block" type="submit">Reset
				Password</button>
			<a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i>
				Back</a>
		</form>

		<form action="/signup/" class="form-signup">
			<div class="social-login">
				<button class="btn facebook-btn social-btn" type="button">
					<span><i class="fab fa-facebook-f"></i> Sign up with
						Facebook</span>
				</button>
			</div>
			<div class="social-login">
				<button class="btn google-btn social-btn" type="button">
					<span><i class="fab fa-google-plus-g"></i> Sign up with
						Google+</span>
				</button>
			</div>

			<p style="text-align: center">OR</p>

			<input type="text" id="user-name" class="form-control"
				placeholder="Full name" required="" autofocus=""> <input
				type="email" id="user-email" class="form-control"
				placeholder="Email address" required autofocus=""> <input
				type="password" id="user-pass" class="form-control"
				placeholder="Password" required autofocus=""> <input
				type="password" id="user-repeatpass" class="form-control"
				placeholder="Repeat Password" required autofocus="">

			<button class="btn btn-primary btn-block" type="submit">
				<i class="fas fa-user-plus"></i> Sign Up
			</button>
			<a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i>
				Back</a>
		</form>
		<br>

	</div>
	</div>
	<p style="text-align: center">
		<a
			href="http://bit.ly/2RjWFMfunction toggleResetPswd(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle() // display:block or none
    $('#logreg-forms .form-reset').toggle() // display:block or none
}

function toggleSignUp(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle(); // display:block or none
    $('#logreg-forms .form-signup').toggle(); // display:block or none
}

$(()=>{
    // Login Register Form
    $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
    $('#logreg-forms #cancel_reset').click(toggleResetPswd);
    $('#logreg-forms #btn-signup').click(toggleSignUp);
    $('#logreg-forms #cancel_signup').click(toggleSignUp);
})g"
			target="_blank" style="color: black">By Artin</a>
	</p>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="/js/script.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>