<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!-- Navigation--> 
    <!DOCTYPE html>
<html>
<head>
       
 <style >
 
.input-group {
	
height: 40px;
    margin-top: 10px;
    margin-right: 20px;
}




 
 
 </style>
                  



</head>
 <body>  
	<nav style="height:140px;width: 100%; " class="navbar navbar-expand-lg navbar-light bg-light">
		<div style="position: fixed;z-index: 1;max-width: 100%;background-color:#FF8C00;height: 140px;top: 0px;" class="container px-4 px-lg-5">
			
			<a class="navbar-brand" href="http://localhost:8080/shop/HoneControll"  style="color: white; text-transform:uppercase; font-weight: bold; "> <img style="width: 90px; height: 90px ;" alt="" src="https://static.mediacdn.vn/marketingai.vn/image/logo.svg">Shop.vn</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul  class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				
				<c:if test="${sessionScope.acc.isAdmin == 1}">
				<li style="color: white;" class="nav-item"><a class="nav-link active"
						aria-current="page" href="ManagerAccountControll?message=empty ">Manager account</a></li>
						
				  </c:if>
						
				<c:if test="${sessionScope.acc.isSell == 1}">
				<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="ManagerControll">Manager product</a></li>
						
				  </c:if>
				  <c:if test="${sessionScope.acc.username != null}">
					<li class="nav-item"><img style="width: 40px;height: 40px; border:1px solid red; border-radius: 25px" alt="" src="https://tse3.mm.bing.net/th?id=OIP.dIF3iIIIuK5HeBCq_aoxZwAAAA&pid=Api&P=0&h=180"> <a style="display: inline;" class="nav-link active"
						aria-current="page" href="http://localhost:8080/shop/profileControll">Home ${sessionScope.acc.username}</a></li>
					</c:if>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">Categories</a>

						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">


							<c:forEach items="${listC}" var="o">
								<li style="width:250px;"><img style="width: 35px; height: 35px ; margin-bottom: 20px " alt="" src="${o.cImage}"><a style="display: inline; margin-bottom: 10px; width: auto"  class="dropdown-item ${ tag==o.id ?"active" :"" }" href="CategoryControll?id=${o.id}">${o.name}</a></li>
							</c:forEach>

						</ul></li>
				</ul>
				
					
					
				<form  action="SearchControll" method="post" class="d-flex">
				 
				   <div style="width: 420px" class="input-group">
                     <input  value="${txt}"    type="text" class="form-control rounded" name="productName" placeholder="Search" aria-label="Search" aria-describedby="search-addo" />
                     <button   type="submit" class="btn btn-outline-primary">search</button>
                   </div>
				
				</form>
				
				<form action="loadCartProduct" method="post" class="d-flex">
                  
					<button class="btn btn-outline-dark" type="submit">
						<i class="bi-cart-fill me-1"></i> Cart <span
							class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.addCart}</span>
					</button>
				</form>
				
				
				<c:if test="${sessionScope.acc == null}">
				<a class="nav-link" href="http://localhost:8080/shop/views/login.jsp" style="padding-left: 20px ;">Đăng nhập</a>
				</c:if>
				
				<c:if test="${sessionScope.acc != null}">
				<img style="width: 30px;height: 30px; border:1px solid black; border-radius: 25px;margin-left: 10px;" alt="" src="https://tse3.mm.bing.net/th?id=OIP.ytoxA-CY6UoLLJH3jvWYxAHaHU&pid=Api&P=0&h=180"><a class="nav-link" href="http://localhost:8080/shop/views/login.jsp" style="padding-left : 30px ; color: #000000;">Đăng xuất</a>
				</c:if>
			</div>
			
		</div>
	</nav>
	</body> 
</html>