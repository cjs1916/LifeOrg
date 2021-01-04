<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Welcome, <c:out value="${user.firstName}" /></title>
		<link rel="stylesheet" href="/css/style.css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
	
	<body>
		<div class="header">
			<img class="brandIcon" src="img/icon.png">
			
			<!-- nav links -->
			<ul class="nav-links">
	            <li><a href="/dashboard">Home</a></li>
	            <li><a href="/rooms">Chat</a>
	            <li><a href="/events">Calendar</a></li>
	            <li><a href="#">Notes</a></li>
	            <li><a href="/todo">Lists</a></li>
	            <li><a href="/movies">Movies</a></li>
	            <li><a href="#">Weather</a></li>
	            <li><a href="/logout">Logout</a></li>
	        </ul>
	        
	        <!-- burger icon for mobile devices -->
	        <div class="burger">
	            <div class="line1"></div>
	            <div class="line2"></div>
	            <div class="line3"></div>
	        </div>
		</div>

		<div class="wrapper">
		
		<div class="main">
		
			<!-- Weather Widget -->
			<div class="weatherWidget">
				<div class="location">
			        <h1 class="location-timezone">${city}</h1>
			    </div>
		
			    <div class="temperature">
			        <div class="degree-section">
			            <h2 class="temperature-degree">${currentTemp}</h2>
			            <h2>° F</h2>
			        </div>
			       	<div class="weather-icon"><img class="icon" src="/img/weatherIcons/${icon}.png" /></div>
			        <div class="temperature-description">${desc}</div>
			    </div>
		    </div>
		    
		    <!-- Add Note Button -->
		    <div class="addWidget">
		    	<input type="image" data-toggle="modal" data-target="#addNoteModal" src="/img/widgetIcons/greyPlus.png" />
		    	<h3>Add Note</h3>
	    	</div>
	    	
	    	<!-- Modal pop-up for adding Note -->
	    	<div class="modal fade" id="addNoteModal" tabindex="-1" aria-labelledby="addNoteModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
					        <h5 class="modal-title" id="addNoteModalLabel">Add New Note</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
						</div>
						
						<div class="modal-body">
							<form:form action="/addNote" method="post" modelAttribute="note">
								<div class="form-group">
								  <form:label path="title" for="title" class="col-form-label">Title:</form:label>
								  <form:input type="text" path="title" class="form-control"/>
								  <form:errors path="title"/>
								</div>
								<div class="form-group">
								  <form:label path="content" for="content" class="col-form-label">Content:</form:label>
								  <form:textarea path="content" class="form-control"></form:textarea>
								  <form:errors path="content"/>
								 </div>
								 	
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
									<button type="submit" class="btn btn-primary">Add Note</button>
								</div>
							</form:form>
				      </div>
				    </div>
				  </div>
				</div>
		
		<!-- Display all notes from current User -->
		<c:forEach items="${user.getNotes()}" var="note">
		<div class="noteWidget">
			<h3>${note.title}</h3>
			<p>${note.content}</p>
			<div class="d-flex justify-content-end">
				<input type="button" data-toggle="modal" data-target="#exampleModal2" class="btn btn-outline-dark" value="Edit" />
			</div>
		</div>
		</c:forEach>
	
		</div>
		
		</div>
		
		<script src="js/dashboard.js"></script>
	    <script type="text/javascript">
		    // function for addNote modal
		    $('#addNoteModal').on('show.bs.modal', function (e) {
		    	  var button = $(e.relatedTarget)
		    })
		    
		    // funtion for editNote modal
		    $('#exampleModal2').on('show.bs.modal', function (e) {
		    	  var button = $(e.relatedTarget)
		    })
	    </script>
	</body>
</html>