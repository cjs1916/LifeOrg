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
		<title>Sign Up</title>
		<link rel="stylesheet" type="text/css" href="/css/loginStyle.css" />
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
	</head>
	
	<body style="background-color: #f8f8f8 ">
		
		<div class="col-8 mx-auto my-3 shadow-sm p-3 mb-5 bg-white rounded" style="background-color: white;">
			<div class="register text-center">
				<h1>Sign Up</h1>
			</div>
			<div class="d-flex justify-content-between">
				<form:form class="col-5" action="registration" method="post" modelAttribute="user">
					<div class="form-group">
						<div>
							<form:label path="firstName">First Name</form:label>
							<form:errors class="text-danger" path="firstName" />
							<form:input path="firstName" class="form-control border-top-0 border-left-0 border-right-0 rounded-0 mb-3"/>
						</div>
						<div>
							<form:label path="lastName">Last Name</form:label>
							<form:errors class="text-danger" path="lastName" />
							<form:input path="lastName" class="form-control border-top-0 border-left-0 border-right-0 rounded-0 mb-3"/>
						</div>
			
						<div>
							<form:label path="email">Email</form:label>
							<form:errors class="text-danger" path="email" />
							<form:input path="email" class="form-control border-top-0 border-left-0 border-right-0 rounded-0 mb-3"/>
						</div>
						<div>
							<div>
								<form:label path="password">Password</form:label>
								<form:errors class="text-danger" path="password" />
								<form:input type="password" path="password" class="form-control border-top-0 border-left-0 border-right-0 rounded-0 mb-3"/>
							</div>
							<div>
								<form:label path="passwordConfirmation">Confirm Password</form:label>
								<form:errors class="text-danger" path="passwordConfirmation" />
								<form:input type="password" path="passwordConfirmation" class="form-control border-top-0 border-left-0 border-right-0 rounded-0"/>
							</div>
						</div>
						<input type="submit" value="Register" class="btn btn-primary my-3"/>
					</div>
				</form:form>
				<div class="signup-image mt-5 mr-5">
                	<figure><img src="/img/signupin/signup-image.jpg" alt="sing up image"></figure>
                    <a href="/login" class="text-success"><u><strong>I am already a member</strong></u></a>
                </div>
			</div>
		</div>
		
		
		
		<%-- <h1>Log in</h1>
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
		</form> --%>
	
	</body>
</html>