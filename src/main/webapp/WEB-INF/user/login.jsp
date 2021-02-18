<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="/css/loginStyle.css" />
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
	</head>
	
	<body style="background-color: #f8f8f8 ">
		
		<div class="col-8 mx-auto my-5 shadow-sm p-3 mb-5 bg-white rounded" style="background-color: white;">
			<div class="register text-center">
				<h1>Log in</h1>
				<div class="border d-flex flex-column align-items-center">
					<p>New to life organizer?</p>
					<form action="guest" method="post">
						<input type="hidden" name="email" value="guest@guest.com"/>
						<input type="hidden" name="password" value="guest"/>
						<button class="btn btn-secondary">Click to demo</button>
					</form>
				</div>
			</div>
			<div class="d-flex justify-content-between">
				<form class="col-5 col-md-12 col-sm-12" method="post" action="/login">
					<div class="form-group">
						<p class="text-danger"><c:out value="${error}" /></p>
						<div>
							<label for="email">Email</label>
							<input type="text" name="email" class="form-control border-top-0 border-left-0 border-right-0 rounded-0 mb-3"/>
						</div>
						
						<div>
							<label for="password">Password</label>
							<input type="password" name="password" class="form-control border-top-0 border-left-0 border-right-0 rounded-0 mb-3"/>
						</div>
						
						<input type="submit" value="Log in" class="btn btn-primary my-3"/>
					</div>
					<div class="d-flex justify-content-end" >
						<a href="/" class="text-success"><u><strong>Create an account</strong></u></a>
					</div>
					
				</form>
				<div class="signup-image mt-5 mr-5">
                	<figure><img src="/img/signupin/signin-image.jpg" id="loginImg" alt="sing in image"></figure>
                </div>
			</div>
		</div>
	
	</body>
</html>