<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My favorite movies</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/moviestyle.css">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/movies">Movie Search</a>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h3 class="text-center">My movies</h3>
							<c:if test="${isEmpty==false}">
					<c:forEach items="${movies}" var="movie">
						<div class="col-md-3">
							<div class="well text-center">
								<img src="${movie.poster}">
								<h5>${movie.title}</h5>
								<a onclick="movieSelected('${movie.imdbId}')"
									class="btn btn-primary" href="#">Movie Details</a>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${isEmpty==true}">
							<h3>No favorites yet!</h3>
				</c:if>
		</div>
	</div>
	<div class="container">
		<div class="jumbotron">
			<h3 class="text-center">Search For Any Movie</h3>
			<form id="searchForm">
				<input type="text" class="form-control" id="searchText"
					placeholder="Search Movies...">
			</form>
		</div>
	</div>

	<div class="container">
		<div id="movies" class="row"></div>
	</div>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script src="/js/moviescript.js"></script>
</body>
</body>
</html>