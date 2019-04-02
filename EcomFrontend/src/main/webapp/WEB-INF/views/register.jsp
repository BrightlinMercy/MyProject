<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<style>
body {
	font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	color: #fff;
	background-repeat: no-repeat;
	background-size: cover;
	background-color: white;
	background-image: url("${cr}/resources/images/white.jpg");
}

.page-container {
	margin: 120px auto 0 auto;
}

h1 {
	font-size: 30px;
	font-weight: 700;
	color: black;
	text-shadow: 0 1px 4px rgba(0, 0, 0, .2);
	text-align: center;
}

form {
	position: relative;
	width: 305px;
	margin: 15px auto 0 auto;
	text-align: center;
}

input {
	width: 270px;
	height: 42px;
	margin-top: 25px;
	padding: 0 15px;
	background: #2d2d2d;
	background: rgba(45, 45, 45, .15);
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	text-align: center;
	border-radius: 6px;
	border: 1px solid #3d3d3d;
	border: 1px solid rgba(255, 255, 255, .15);
	-moz-box-shadow: 0 2px 3px 0 rgba(0, 0, 0, .1) inset;
	-webkit-box-shadow: 0 2px 3px 0 rgba(0, 0, 0, .1) inset;
	box-shadow: 0 2px 3px 0 rgba(0, 0, 0, .1) inset;
	font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	font-size: 16px;
	color: black;
	text-shadow: 0 1px 2px rgba(0, 0, 0, .1);
	-o-transition: all .2s;
	-moz-transition: all .2s;
	-webkit-transition: all .2s;
	-ms-transition: all .2s;
}

input:-moz-placeholder {
	color: black;
}

input:-ms-input-placeholder {
	color: black;
}

input::-webkit-input-placeholder {
	color: black;
}

input:focus {
	outline: none;
	-moz-box-shadow: 0 2px 3px 0 rgba(0, 0, 0, .1) inset, 0 2px 7px 0
		rgba(0, 0, 0, .2);
	-webkit-box-shadow: 0 2px 3px 0 rgba(0, 0, 0, .1) inset, 0 2px 7px 0
		rgba(0, 0, 0, .2);
	box-shadow: 0 2px 3px 0 rgba(0, 0, 0, .1) inset, 0 2px 7px 0
		rgba(0, 0, 0, .2);
}

button {
	cursor: pointer;
	width: 300px;
	height: 44px;
	margin-top: 25px;
	padding: 0;
	background: #ef4300;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	border: 1px solid #ff730e;
	-moz-box-shadow: 0 15px 30px 0 rgba(255, 255, 255, .25) inset, 0 2px 7px
		0 rgba(0, 0, 0, .2);
	-webkit-box-shadow: 0 15px 30px 0 rgba(255, 255, 255, .25) inset, 0 2px
		7px 0 rgba(0, 0, 0, .2);
	box-shadow: 0 15px 30px 0 rgba(255, 255, 255, .25) inset, 0 2px 7px 0
		rgba(0, 0, 0, .2);
	font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	font-size: 14px;
	font-weight: 700;
	color: black;
	text-shadow: 0 1px 2px rgba(0, 0, 0, .1);
	-o-transition: all .2s;
	-moz-transition: all .2s;
	-webkit-transition: all .2s;
	-ms-transition: all .2s;
}

button:hover {
	-moz-box-shadow: 0 15px 30px 0 rgba(255, 255, 255, .15) inset, 0 2px 7px
		0 rgba(0, 0, 0, .2);
	-webkit-box-shadow: 0 15px 30px 0 rgba(255, 255, 255, .15) inset, 0 2px
		7px 0 rgba(0, 0, 0, .2);
	box-shadow: 0 15px 30px 0 rgba(255, 255, 255, .15) inset, 0 2px 7px 0
		rgba(0, 0, 0, .2);
}

button:active {
	-moz-box-shadow: 0 15px 30px 0 rgba(255, 255, 255, .15) inset, 0 2px 7px
		0 rgba(0, 0, 0, .2);
	-webkit-box-shadow: 0 15px 30px 0 rgba(255, 255, 255, .15) inset, 0 2px
		7px 0 rgba(0, 0, 0, .2);
	box-shadow: 0 5px 8px 0 rgba(0, 0, 0, .1) inset, 0 1px 4px 0
		rgba(0, 0, 0, .1);
	border: 0px solid #ef4300;
}

.navbar {
	overflow: hidden;
	background-color: #333;
	font-family: Arial;
}

.navbar a {
	float: left;
	font-size: 16px;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: black;
	padding: 14px 16px;
	background-color: inherit;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: red
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: black;
	width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: black;
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>

<html>
<head>
<title>Register</title>
<link href="CSS/style.css" rel="stylesheet" type="text/css" />




</head>
<body>


	<div class="page-container">
		<c:if test="${success}">
			<div class="alert alert-success" role="alert">Inserted
				Successfully</div>
		</c:if>

		<c:if test="${error}">
			<div class="alert alert-danger" role="alert">${message}</div>

		</c:if>





		<form:form action="addcustomer" modelAttribute="regobject">
			<h1>Register With Us</h1>
			<form:input type="text" name="name" class="Name" path="custname"
				placeholder="Enter your Name" />
			<form:errors path="custname" cssStyle="color:Red"></form:errors>

			<form:input type="text" name="tele" class="Tele" path="custphno"
				placeholder="Enter your Number" />
			<form:errors path="custphno" cssStyle="color:Red"></form:errors>


			<form:input type="text" name="email" class="Email" path="custemailid"
				placeholder="Enter your Email" />
			<form:errors path="custemailid" cssStyle="color:Red"></form:errors>


			<form:input type="password" name="password" class="Address"
				path="custpassword" placeholder="Enter password" />
			<form:errors path="custpassword" cssStyle="color:Red"></form:errors>


			<button type="submit" value="Add" name="submit">Submit</button>
		</form:form>
	</div>


</body>
</html>