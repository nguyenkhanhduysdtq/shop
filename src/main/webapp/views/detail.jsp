<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="http://localhost:8080/shop/css/style.css" rel="stylesheet" />

<title>Insert title here</title>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>
body {
	background-color: white;
}

.gallery-wrap .img-big-wrap img {
	height: 450px;
	width: auto;
	display: inline-block;
	cursor: zoom-in;
}

.gallery-wrap .img-small-wrap .item-gallery {
	width: 60px;
	height: 60px;
	border: 1px solid #ddd;
	margin: 7px 2px;
	display: inline-block;
	overflow: hidden;
}

.gallery-wrap .img-small-wrap {
	text-align: center;
}

.gallery-wrap .img-small-wrap img {
	max-width: 100%;
	max-height: 100%;
	object-fit: cover;
	border-radius: 4px;
	cursor: zoom-in;
}

.img-big-wrap img {
	width: 100% !important;
	height: auto !important;
}

h2 {
	text-align: center;
}

h6 {
	text-align: center;
	color: #B5B5B5;
}

.header {
	margin-bottom: 20px;
}

.row a img:hover {
	transform: scale(1.1);
	width: 20%;
}
</style>

</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="container">

		<div class="header">
			<h2>Siêu thị công nghệ chất lượng cao</h2>
			<h6>Uy tín tạo thương hiệu hơn 10 năm trên thị trường</h6>

		</div>
		<div class="row">
			<div class="col-sm-9">
				<div style="width: 1500px" class="container">
					<div class="card">
						<div class="row">
							<aside class="col-sm-5 border-right">
								<article class="gallery-wrap">
									<div class="img-big-wrap">
										<div>
											<a href="#"><img src="${detail.image}"></a>
										</div>
									</div>
									<!-- slider-product.// -->
									<div class="img-small-wrap"></div>
									<!-- slider-nav.// -->
								</article>
								<!-- gallery-wrap .end// -->
							</aside>
							<aside class="col-sm-7">
								<article class="card-body p-5">
									<h3 class="title mb-3">${detail.name}</h3>

									<p class="price-detail-wrap">
										<span class="price h3 text-warning"> <span class="num">${detail.price}</span><span
											class="currency">$</span>
										</span>
									</p>
									<!-- price-detail-wrap .// -->
									<dl class="item-property">
										<dt>Miêu tả sản phẩm</dt>
										<dd>
											<p>${detail.description}</p>
										</dd>
									</dl>

									<hr>
									<p style="font-size: 16px;font-weight: bold;">Vận chuyển</p>
									<ul class="place">
									
									
									
									<li class="nav-item dropdown"><a style="text-decoration: none;"
										class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
										role="button" data-bs-toggle="dropdown" aria-expanded="false">Vận chuyển tới <p style="display: inline; margin-left: 5px;font-weight: bold;	">${street}</p>  </a>

										<ul class="dropdown-menu" aria-labelledby="navbarDropdown">


											
												<li id="btn-open"><a style="display: inline;color: black" class="" href="http://localhost:8080/shop/PageProfileMy?ppid=${detail.id}">
												<i  class="fa-solid fa-plus"></i> 
												<p style="display: inline; color: black ; text-decoration: none;">Thêm địa chỉ</p>
												
												
												</a></li>
										

										</ul></li>
										</ul>

									<div style="margin-top: 50px;" class="row">
										<div class="col-sm-5">
											<dl class="param param-inline">
												<dt>Số lượng:</dt>
												<dd>
													<select class="form-control form-control-sm"
														style="width: 90px;">
														<option>1</option>
														<option>2</option>
														<option>3</option>
													</select>
												</dd>
											</dl>
											<!-- item-property .// -->
										</div>
										<!-- col.// -->

									</div>
									<!-- row.// -->
									<hr>
									<a style="width: 400px;background-color : #ff8c00" href="#" class="btn btn-lg btn-primary text-uppercase">
										Mua ngay </a> <a href="addCartControll?pID=${detail.id}"
										class="btn btn-lg btn-outline-primary text-uppercase"> <i
										class="fas fa-shopping-cart"></i> Thêm giỏ hàng
									</a>
								</article>
								<!-- card-body.// -->
							</aside>
							<!-- col.// -->
						</div>
						<!-- row.// -->
					</div>
					<!-- card.// -->


				</div>
			</div>
		</div>


	</div>

<div class="row">
		<div class="col-sm-12">
			<h2 style="margin-top: 30px;">Hàng liên quan</h2>
			<hr />
			<c:forEach items="${listPP}" var="o">
				<a href="relateProductControll?idpp=${o.id}"> <img
					style="width: 300px; height: 300px; margin-bottom: 50px; border: 1px solid grey;"
					alt="" src="${o.image}"></a>
			</c:forEach>
		</div>
	</div>
	
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

	<script src="js/scripts.js"></script>
</body>
</html>