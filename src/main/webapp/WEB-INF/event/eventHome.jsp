<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calendar</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&family=Roboto+Mono:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #f8f8f8">

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
    
    <div class="container">
        <div class="calendar">
            <div class="month">
                <i class="fas fa-angle-left prev"></i>
                <div class="date">
                    <h1>May</h1>
                    <p></p>
                </div>
                <i class="fas fa-angle-right next"></i>
            </div>
            <div class="weekdays">
                <div style="color:red;">Sun</div>
                <div>Mon</div>
                <div>Tue</div>
                <div>Wed</div>
                <div>Thu</div>
                <div>Fri</div>
                <div style="color:blue;">Sat</div>
            </div>
            <div class="days">
                
            </div>
        </div>
        <div class="event-list" style="color:black;">
        	<h3 class="text-center">Event List</h3>
        	<table class="table table-dark">
			  <thead>
			    <tr>
			      <th scope="col">Date</th>
			      <th scope="col">Event</th>
			      <th scope="col">Description</th>
			      <th scope="col">Location</th>
			      
			    </tr>
			  </thead>
			  
			  <tbody>
			  <c:forEach var="event" items="${thisUser.events}">
			    <tr>
			      <th scope="row">${event.date}</th>
			      <td>${event.name}</td>
			      <td>${event.description}</td>
			      <td>${event.location}</td>
			    </tr>
			  </c:forEach>  
			  </tbody>
			</table>
        </div>
    </div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form:form action="/events/new" method="post" modelAttribute="event">
          <div class="form-group">
            <form:label path="name" for="name" class="col-form-label">Event Name:</form:label>
            <form:input type="text" path="name" class="form-control"/>
            <form:errors path="name"/>
          </div>
          <div class="form-group">
            <form:label path="location" for="location" class="col-form-label">Location:</form:label>
            <form:input type="text" path="location" class="form-control"/>
            <form:errors path="location"/>
          </div>
          <div class="form-group">
            <form:label for="description" path="description" class="col-form-label">Description: </form:label>
            <form:textarea class="form-control" path="description"></form:textarea>
            <form:errors path="description"/>
          </div>
          <div class="form-group">
            <form:label path="date" for="date" class="col-form-label">Date:</form:label>
            <form:input type="text" path="date" class="form-control date"/>
          </div>
          	
          <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="submit" class="btn btn-primary">Create Event</button>
      	  </div>
        </form:form>
      </div>
    </div>
  </div>
</div>
	<script src="/js/dashboard.js"></script>
    <script src="/js/script.js"></script>
    <script type="text/javascript">
	    $('#exampleModal').on('show.bs.modal', function (event) {
	    	  var button = $(event.relatedTarget) // Button that triggered the modal
	    	  var recipient = button.data('whatever') // Extract info from data-* attributes
	    	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	    	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	    	  var modal = $(this)
	    	  modal.find('.modal-title').text("Create an Event on " + recipient)
	    	  modal.find('.modal-body input.date').val(recipient)
	    	})
    </script>
</body>
</html>