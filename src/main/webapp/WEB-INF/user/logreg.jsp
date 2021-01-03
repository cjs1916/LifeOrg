<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login and Registration</title>
		<link rel="stylesheet" href="/css/style.css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	</head>
	
	<body>
		<div>
			<h1>Registration</h1>
		</div>
		<div>
			<form:form action="registration" method="post" modelAttribute="user">
				<div>
					<form:label path="firstName">First Name</form:label>
					<form:input path="firstName" />
					<form:errors path="firstName" />
				</div>
				<div>
					<form:label path="lastName">Last Name</form:label>
					<form:input path="lastName" />
					<form:errors path="lastName" />
				</div>
	
				<div>
					<form:label path="email">Email</form:label>
					<form:input path="email" />
					<form:errors path="email" />
				</div>
				<div>
					<div>
						<form:label path="password">Password</form:label>
						<form:input type="password" path="password" />
						<form:errors path="password" />
					</div>
					<div>
						<form:label path="passwordConfirmation">Confirm Password</form:label>
						<form:input type="password" path="passwordConfirmation" />
						<form:errors path="passwordConfirmation" />
					</div>
				</div>
				<input type="submit" value="Submit Registration" />
			</form:form>
		</div>
		<h1>Log in</h1>
		<p>
			<c:out value="${error}" />
		</p>
		<form action="/login" method="post">
			<p>
				<label for="email">Email:</label> <input type="text" id="email"
					name="email" />
	
			</p>
	
			<p>
				<label for="password">Password:</label> <input type="password"
					name="password" id="password" />
			</p>
	
			<input type="submit" value="Login" />
		</form>
	
	</body>
</html>