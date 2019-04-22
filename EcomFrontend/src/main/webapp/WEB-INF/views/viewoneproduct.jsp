<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />

<style type="text/css">
/*
	** Style Simple Ecommerce Theme for Bootstrap 4
	** Created by T-PHP https://t-php.fr/43-theme-ecommerce-bootstrap-4.html
	*/
	body {
		background-image: url("${cr}/resources/images/white.jpg");
}
	
.bloc_left_price {
	color: #c01508;
	text-align: center;
	font-weight: bold;
	font-size: 150%;
}

.category_block li:hover {
	background-color: #007bff;
}

.category_block li:hover a {
	color: #ffffff;
}

.category_block li a {
	color: #343a40;
}

.add_to_cart_block .price {
	color: #c01508;
	text-align: center;
	font-weight: bold;
	font-size: 200%;
	margin-bottom: 0;
}

.add_to_cart_block .price_discounted {
	color: #343a40;
	text-align: center;
	text-decoration: blink;
	font-size: 170%;
}

.product_rassurance {
	padding: 10px;
	margin-top: 15px;
	background: #ffffff;
	border: 1px solid #6c757d;
	color: #6c757d;
}

.product_rassurance .list-inline {
	margin-bottom: 0;
	text-transform: uppercase;
	text-align: center;
}

.product_rassurance .list-inline li:hover {
	color: #343a40;
}

.reviews_product .fa-star {
	color: gold;
}

.pagination {
	margin-top: 20px;
}
</style>

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">

<div class="container" style="margin-top: 5%">
	<div class="row">
		<!-- Image -->
		<div class="col-12 col-lg-6">
			<div class="card bg-light mb-3" style="width: 80%;">
				<div class="card-body">
					<img class="img-fluid"
						src="${cr}/resources/productimages/${myproduct.pdtid}.jpg"
						height="450" style="max-height: 500px;" width="100%" />

				</div>
			</div>
		</div>
		<!-- Add to cart -->
		<div class="col-12 col-lg-6 add_to_cart_block">
			<div class="card bg-light mb-3" style="width: 80%;">
				<div class="card-body">
					<p class="price">${myproduct.pdtname}</p>
					<p class="price_discounted"
						style="color: #0762ff; font-size: 110%;">
						${myproduct.pdtseller.sellername}</p>
					<p class="price_discounted ">Rs.${myproduct.pdtprice}</p>
					<form action="${cr}/AddToCart">
						<div class="form-group">

							<label>Quantity :</label>
							<div class="input-group mb-3">
								<input type="hidden" name="pid" value="${myproduct.pdtid}">
								<input type="hidden" class="form-control" id="quantity"
									name="quantity" min="100" max="1000" value="1">
							</div>
						</div>
						<c:if test="${myproduct.pdtstock>=300}">
							<button
								class="btn btn-success btn-lg btn-block text-uppercase"> <i
									class="fa fa-shopping-cart"></i> Add To Cart
							</button>
						</c:if>
						<c:if test="${myproduct.pdtstock==100}">
							<button
								class="btn btn-success btn-lg btn-block text-uppercase"> <i
									class="fa fa-shopping-cart"></i>
								<p align="center">Add To Cart-Only 100 left</p>
								<font size="5" color="red">HURRY UP!!!</font>
							</button>
						</c:if>
						<c:if test="${myproduct.pdtstock==0}">
							<p>Out of Stock</p>
						</c:if>

					</form>

				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<!-- Description -->
		<div class="col-12">
			<div class="card border-light mb-3">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-align-justify"></i> Description
				</div>
				<div class="card-body">
					<p class="card-text">${myproduct.pdtdesc}</p>
				</div>
			</div>
		</div>

		<!-- Reviews -->
	</div>
</div>
