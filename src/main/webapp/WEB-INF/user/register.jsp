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
						
						<div class="d-flex justify-content-start align-items-end">
							<div class="col-10">
								<form:label path="city">City</form:label>
								<form:errors class="text-danger" path="city" />
								<form:input path="city" class="form-control border-top-0 border-left-0 border-right-0 rounded-0 mb-3"/>
							</div>
							
							<form:select class="form-control col-2" path="state">
								<option value="AL">AL</option>
								<option value="AK">AK</option>
								<option value="AZ">AZ</option>
								<option value="AR">AR</option>
								<option value="CA">CA</option>
								<option value="CO">CO</option>
								<option value="CT">CT</option>
								<option value="DE">DE</option>
								<option value="DC">DC</option>
								<option value="FL">FL</option>
								<option value="GA">GA</option>
								<option value="HI">HI</option>
								<option value="ID">ID</option>
								<option value="IL">IL</option>
								<option value="IN">IN</option>
								<option value="IA">IA</option>
								<option value="KS">KS</option>
								<option value="KY">KY</option>
								<option value="LA">LA</option>
								<option value="ME">ME</option>
								<option value="MD">MD</option>
								<option value="MA">MA</option>
								<option value="MI">MI</option>
								<option value="MN">MN</option>
								<option value="MS">MS</option>
								<option value="MO">MO</option>
								<option value="MT">MT</option>
								<option value="NE">NE</option>
								<option value="NV">NV</option>
								<option value="NH">NH</option>
								<option value="NJ">NJ</option>
								<option value="NM">NM</option>
								<option value="NY">NY</option>
								<option value="NC">NC</option>
								<option value="ND">ND</option>
								<option value="OH">OH</option>
								<option value="OK">OK</option>
								<option value="OR">OR</option>
								<option value="PA">PA</option>
								<option value="RI">RI</option>
								<option value="SC">SC</option>
								<option value="SD">SD</option>
								<option value="TN">TN</option>
								<option value="TX">TX</option>
								<option value="UT">UT</option>
								<option value="VT">VT</option>
								<option value="VA">VA</option>
								<option value="WA">WA</option>
								<option value="WV">WV</option>
								<option value="WI">WI</option>
								<option value="WY">WY</option>
							</form:select>		
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