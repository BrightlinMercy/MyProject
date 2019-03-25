<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="icon" href="resources/images/Capture3.PNG" type="image/gif"
	size="16*16">

<meta charset="ISO-8859-1">
<title>The Card Cottage</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div style="min-height: 400px;">
		<c:if test="${aboutPage}">
			<jsp:include page="aboutus.jsp" />
		</c:if>
		<c:if test="${contactPage}">
			<jsp:include page="contactus.jsp" />
		</c:if>
		<c:if test="${loginPage}">
			<jsp:include page="login.jsp" />
		</c:if>
		<c:if test="${registerPage}">
			<jsp:include page="register.jsp" />
		</c:if>
		<c:if test="${sliderPage}">
			<jsp:include page="slider.jsp" />
		</c:if>
		<c:if test="${categoryPage}">
			<jsp:include page="category.jsp" />
		</c:if>
		<c:if test="${sellerPage}">
			<jsp:include page="seller.jsp" />
		</c:if>

	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>