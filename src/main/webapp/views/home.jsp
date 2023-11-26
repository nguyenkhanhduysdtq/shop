<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shop Homepage - Start Bootstrap Template</title>
<!-- Favicon-->
<!-- <link rel="icon" type="image/x-icon" href="assets/favicon.ico" /> -->
<!-- Bootstrap icons-->
<link href="http://localhost:8080/shop/css/style.css" rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->


<style type="text/css">


body{
background-color: white;
}

.display-area{
overflow: hidden;
height: 417px;
width: 900px;
margin: 0;

}

.gallery-wrap{
width: 500%;
animation : slideShow 16s infinite;

}


.images img{
width: 900px;
height: 417px;

float: left;
display: flex;

justify-content: center;

align-items: center;

-webkit-box-reflect: blow 1px -webkit-gradient(linear,right top,right bottom,
form(transparent),to(rgb(255,255,255,0.3)))




}

@keyframes slideShow{
 20%{
   margin-left :0;
 }
 
 30%{
   margin-left :-100%;
 }
 
 40%{
   margin-left :-100%;
}

50%{
   margin-left :-200%;
 }
 60%{
   margin-left :-200%;
 }
 
  70%{
   margin-left :-300%;
 }
 
  80%{
   margin-left :-300%;
 }
 
  90%{
   margin-left :-400%;
 }
 
  100%{
   margin-left :-400%;
 }
}

.image1 img{
width: 100px;
height: 90px;

margin-left:200px;
margin-top: 30px;



}

.image1 p{

width:300px;

margin-top:5px;

font-weight: bold;

margin-left: 170px;

font-size: 15px;

}

.image1 h6{

width: 200px;

margin-left: 185px;

}

.image1{
width:20%;
display:inline;
float: left;


}
.imformation{
height: 300px;
width: 1500px;
}

.row img:hover {
transform :scale(1.1);
width: 100%;
}

.image1 img:hover {
	transform :scale(1.1);
width: 30%;
}




</style>



</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<!-- Header-->
	<header>
		<div style="display:block ; " class="containers">
       <div class="display-area">
           <div class="gallery-wrap">
             <div class="images">
                 <img alt="" src="https://itop10.info/wp-content/uploads/2019/03/website-thuong-mai-dien-tu-hang-dau-viet-nam.jpg">
             </div>
              
             <div class="images">
                 <img alt="" src="https://st.quantrimang.com/photos/image/2020/07/08/Hinh-nen-anime-nam-3.jpg">
             </div>
             
             <div class="images">
                 <img alt="" src="https://anhdep123.com/wp-content/uploads/2021/01/anh-giay-adidas.jpg">
             </div>
             
             <div class="images">
                 <img alt="" src="https://2.bp.blogspot.com/-HQJi6Wndnlk/WNnsuJa19QI/AAAAAAAABlI/I8I7SE8vamknH4g0X0G6D36hsv-9EctTgCLcB/s1600/nhung-mau-giay-nike-dep-nhat.jpg">
             </div>
             
             <div class="images">
                 <img alt="" src="https://toplisthanoi.com/wp-content/uploads/2022/02/giay-da-nam-ha-noi-5-min.jpg">
             </div>
             
           
           </div>
       
       
       </div>
       
   
   </div>
  
   
	</header>
	
	
	
            
	
	<div class="imformation">
	   <div  class="image1">
	     <img style="display: inline;" alt="" src="https://tse4.mm.bing.net/th?id=OIP.wTb9aVW9nvq7iyX3OnP1-QHaGQ&pid=Api&P=0&h=180">
	    <p>GIAO HÀNG TOÀN QUỐC</p>
	    <h6>Miễn phí vận chuyển</h6>
	   
	   </div>
	   
	   
	   <div class="image1">
	     <img alt="" src="https://bizweb.dktcdn.net/100/422/920/themes/833407/assets/service_2.jpg?1655967208097">
	    <p>THANH TOÁN KHI NHẬN</p>
	    <h6>Nhận hàng rồi trả</h6>
	   
	   </div>
	   
	   <div class="image1">
	     <img alt="" src="https://clipground.com/images/loading-logo-clipart-5.png">
	    <p>ĐỔI HÀNG DỄ DÀNG</p>
	    <h6>Đổi tra khi gặp vấn đề</h6>
	   
	   </div>
	   
	   
	   <div class="image1">
	     <img alt="" src="https://xeruanhua.com/wp-content/uploads/2020/06/b%E1%BA%A3o-h%C3%A0nh.png">
	    <p>BẢO HÀNH SẢN PHẨM</p>
	    <h6>bảo hành lỗi sản phẩm</h6>
	   
	   </div>
	   
	   <hr/>
	   
	   
	   
	
	</div>
	
	
	<div class="Banner">
	<a href="#"> <img style="text-align: center; margin-left: 120px;" width="1200" height="100" loading="lazy" class=" ls-is-cached lazyloaded" data-src="https://img.tgdd.vn/imgt/f_webp,fit_outside,quality_100/https://cdn.tgdd.vn/2023/08/banner/banner-ngang-lenovo-desk-1200x100.png" alt="Promote B2S - HP" 
src="https://img.tgdd.vn/imgt/f_webp,fit_outside,quality_100/https://cdn.tgdd.vn/2023/08/banner/banner-ngang-lenovo-desk-1200x100.png"></a>
	
	</div>
	
	<div class="row">
          <div style="display: inline ; " class= "col-sm-12">
             <h2  style="margin-top: 30px; font-weight: bold; font-size: 20px">Danh mục</h2>
             <hr />
             <c:forEach items="${listC}" var="o">
             <div style="display: inline;" class="cateIterm">
             <img  style="width: 80px; height: 80px ; margin-bottom: 50px; border: 1px solid grey; margin-left: 70px;" alt="" src="${o.cImage}">
             <a  style="color: black; text-decoration: none;margin-left: 2px" href="CategoryControll?id=${o.id}"> ${o.name}</a>
             </div>
             </c:forEach>
          </div>
        </div>
	    
	    <hr/>
        
        <h2 style="font-weight: bold;text-align:center;text-transform: uppercase;">SẢN PHẨM</h2>
	<!-- Section-->
	<section class="py-5">
		<div style="text-align: center;" class="container px-4 px-lg-5 mt-5">

			<div 
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<c:forEach items="${listP}" var="o">
					<div  class="col mb-5">
						<div class="card h-100">
							<!-- Product image-->
							<img style="height: 250px" class="card-img-top " src="${o.image}"
								alt="..." />
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 class="fw-bolder">${o.name}</h5>

									<div
										class="d-flex justify-content-center small text-warning mb-2">
										<div class="bi-star-fill"></div>
										<div class="bi-star-fill"></div>
										<div class="bi-star-fill"></div>
										<div class="bi-star-fill"></div>
										<div class="bi-star-fill"></div>
									</div>
									<!-- Product price-->
									<p>${o.description}</p>
									<p style="color: #FF4500 ; font-size: 20px">${o.price}$</p>
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-  transparent">
								<div class="text-center">
									<a class="btn btn-outline-dark mt-auto"
										href="detailControll?pid=${o.id}">View options</a>
								</div>
							</div>
						</div>
					</div>


				</c:forEach>

			</div>
		</div>
		<nav style="margin-left: 600px" aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
				</a></li>
				<c:forEach begin="1" end="${page}" var="i">
				<li class="page-item"><a class="page-link ${index==i ? "active" :""}" href="HoneControll?pages=${i}"> ${i}</a></li>
				</c:forEach>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Next</span>
				</a></li>
			</ul>
		</nav>

	</section>
	<jsp:include page="footer.jsp"></jsp:include>
	
	
	<!-- Bootstrap core JS-->
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>