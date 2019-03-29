<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
@import url(https://fonts.googleapis.com/css?family=Raleway:300,400,600)
	;

body {
	margin: 0;
	font-size: .9rem;
	font-weight: 400;
	line-height: 1.6;
	text-align: center;
	background-image: url("resources/images/white.jpg");
}

.card {
	color: black;
}

.card-header {
	font-weight: bold;
}

.card-body {
	font-weight: bold;
}

.navbar-laravel {
	box-shadow: 0 2px 4px rgba(0, 0, 0, .04);
	color: blue;
}

.navbar-brand, .nav-link, .my-form, .login-form {
	font-family: Raleway, sans-serif;
}

.checkbox {
	font-weight: bold;
}

.col-md-6 offset-md-4 {
	font-weight: bold;
}

.my-form {
	padding-top: 10rem;
	padding-bottom: 10rem;
}

.my-form .row {
	margin-center: 10rem;
	margin-center: 10rem;
}

.login-form {
	padding-top: 10rem;
	padding-bottom: 10rem;
}

.login-form .row {
	margin-left: 0;
	margin-right: 0; . custab { border : 1px solid #ccc;
	padding: 5px;
	margin: 5% 0;
	box-shadow: 3px 3px 2px #ccc;
	transition: 0.5s;
}

.custab:hover {
	box-shadow: 3px 3px 0px transparent;
	transition: 0.5s;
}
}
</style>



<title>Login</title>
</head>
<body>



	<main class="login-form">
	<div class="cotainer">
		<c:if test="${success}">
			<div class="alert alert-success" role="alert">inserted
				successfully</div>

		</c:if>

		<c:if test="${error}">
			<div class="alert alert-danger" role="alert">${message}</div>

		</c:if>


		<div class="row justify-content-center">

			<div class="col-md-10">
				<div class="card">
					<div class="card-header">SELLER</div>
					<div class="card-body">
						<div class="row">
							<c:if test="${!editmode}">
								<c:set var="action" value="addseller"></c:set>
							</c:if>

							<c:if test="${editmode}">
								<c:set var="action" value="updateseller"></c:set>
							</c:if>


							<form:form action="${action}" modelAttribute="sellobject">
								<c:if test="${editmode}">
									<form:hidden path="sellerid" />
								</c:if>
								<div class="form-group row">
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">SELLER
										NAME</label>
									<div class="col-md-6">
										<form:input type="text" id="email_address"
											class="form-control" name="email-address" path="sellername" />
									</div>
								</div>

								<div class="form-group row">
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">SELLER
										DESCRIPTION</label>
									<div class="col-md-6">
										<form:input type="text" id="email_address"
											class="form-control" name="email-address" path="sellerdesc" />

									</div>
								</div>





								<div class="col-md-6 offset-md-4">
									<button type="submit" class="btn btn-primary">SUBMIT</button>

								</div>

							</form:form>
						</div>
						<div class="row">
							<div class="col-lg-12">
								<table class="table table-striped custab">
									<thead>

										<tr>
											<th>SELLER ID</th>
											<th>SELLER NAME</th>
											<th>SELLER DESCRIPTION</th>
											<th class="text-center">EDIT/DELETE</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${sellerlist}" var="sell">
											<tr>
												<td>${sell.sellerid}</td>
												<td>${sell.sellername}</td>
												<td>${sell.sellerdesc}</td>
												<td class="text-center"><a class='btn btn-info btn-xs'
													href="editseller?sellname=${sell.sellername}"><span
														class="glyphicon glyphicon-edit"></span> Edit</a> <a
													href="deleteseller?sellname=${sell.sellername}"
													class="btn btn-danger btn-xs"><span
														class="glyphicon glyphicon-remove"></span> Del</a></td>
										</c:forEach>

									</tbody>
								</table>
							</div>

						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>

	</main>







</body>
</html>