<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
body {
	margin: 0;
	font-size: .9rem;
	font-weight: 400;
	line-height: 1.6;
	align: center;
	background-image: url("resources/images/white.jpg");
}
</style>



<body>
	<fieldset>
		<div class="container">
		<c:if test="${success}">
			<div class="alert alert-success" role="alert">inserted
				successfully</div>

		</c:if>

		<c:if test="${error}">
			<div class="alert alert-danger" role="alert">${message}</div>

		</c:if>
		
		

			<c:if test="${!editmode}">
				<c:set var="action" value="addproduct"></c:set>
			</c:if>

			<c:if test="${editmode}">
				<c:set var="action" value="updateproduct"></c:set>
			</c:if>


			<form:form action="${action}" modelAttribute="productobject"
				class="form-horizontal">
				<c:if test="${editmode}">
					<form:hidden path="pdtid" />
				</c:if>




				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="product_name">PRODUCT
						NAME</label>
					<div class="col-md-4">
						<form:input type="text" id="product_name" placeholder=" "
							class="form-control input-md" path="pdtname"></form:input>

					</div>
				</div>

				<!-- Textarea -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="product_description">PRODUCT
						DESCRIPTION</label>
					<div class="col-md-4">
						<form:textarea class="form-control" id="product_description"
							name="product_description" path="pdtdesc"></form:textarea>
					</div>
				</div>




				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="price">STOCK</label>
					<div class="col-md-4">
						<form:input id="stock" name="pdtprice" placeholder=" "
							class="form-control input-md" required="" type="text"
							path="pdtstock"></form:input>

					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="price">PRICE</label>
					<div class="col-md-4">
						<form:input id="price" name="pdtprice" placeholder=" "
							class="form-control input-md" required="" type="text"
							path="pdtprice"></form:input>

					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="product_categorie">PRODUCT
						CATEGORY</label>
					<div class="col-md-4">
						<form:select id="product_categorie" name="product_categorie"
							class="form-control" path="pdtcategory.cateid">
							<c:forEach items="${categorylist}" var="cat">

								<form:option value="${cat.cateid}">${cat.catename}</form:option>

							</c:forEach>
						</form:select>
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="product_categorie">PRODUCT
						SELLER</label>
					<div class="col-md-4">
						<form:select id="product_categorie" name="product_categorie"
							class="form-control" path="pdtseller.sellerid">
							<c:forEach items="${sellerlist}" var="sell">

								<form:option value="${sell.sellerid}">${sell.sellername}</form:option>
							</c:forEach>
						</form:select>

					</div>
				</div>


				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton">SUBMIT</label>
					<div class="col-md-4">
						<button id="singlebutton" name="singlebutton"
							class="btn btn-primary">submit</button>
					</div>
				</div>
			</form:form>
			<div class="row">
				<div class="col-lg-12">
					<table class="table table-striped custab">
						<thead>

							<tr>
								<th>PRODUCT ID</th>
								<th>PRODUCT NAME</th>
								<th>PRODUCT DESCRIPTION</th>
								<th>PRODUCT STOCK</th>
								<th>PRODUCT PRICE</th>
								<th>PRODUCT CATEGORY</th>
								<th>PRODUCT SELLER</th>




								<th class="text-center">EDIT/DELETE</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${productlist}" var="product">
								<tr>
									<td>${product.pdtid}</td>
									<td>${product.pdtname}</td>
									<td>${product.pdtdesc}</td>
									<td>${product.pdtstock}</td>
									<td>${product.pdtprice}</td>
									<td>${product.pdtcategory.catename}</td>
									<td>${product.pdtseller.sellername}</td>


									<td class="text-center"><a class='btn btn-info btn-xs'
										href="editproduct?pdtid=${product.pdtid}"><span
											class="glyphicon glyphicon-edit"></span> Edit</a> <a
										href="deleteproduct?pdtid=${product.pdtid}"
										class="btn btn-danger btn-xs"><span
											class="glyphicon glyphicon-remove"></span> Del</a></td>
							</c:forEach>

						</tbody>
					</table>
				</div>

			</div>


		</div>
	</fieldset>
</body>