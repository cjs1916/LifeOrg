<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/styleChat.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css"
    rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&family=Roboto+Mono:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3 class=" text-center">Chat</h3>
    <div class="messaging">
      <div class="inbox_msg">
        <div class="inbox_people">
          <div class="headind_srch">
            <div class="recent_heading">
              <h4>Chat Rooms</h4>
            </div>
          </div>
          <div class="inbox_chat">
          	<c:forEach var="room" items="${allRooms}">
	            <div class="chat_list active_chat">
	              <div class="chat_people">
	                <div class="chat_img"> <img src="https://cdn3.iconfinder.com/data/icons/text-messaging-3/512/6-512.png" alt="user"> </div>
	                <div class="chat_ib">
	                  <h5><a href="/rooms/${room.id}" class="fill-div">${room.roomName}</a></h5>
	                </div>
	              </div>
	            </div>
            </c:forEach>
          </div>
        </div>
        <div class="mesgs" style="text-align: center; ">
          <button type="button" class="btn btn-link" style="line-height:500px;" data-toggle="modal" style="background-color: transparent;" data-target="#exampleModal">+Create Chat Room</button>
        </div>
      </div>
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
        <form:form action="/rooms/new" method="post" modelAttribute="room">
          <div class="form-group">
            <form:label path="roomName" for="roomName" class="col-form-label">Chat Room Name:</form:label>
            <form:input type="text" path="roomName" class="form-control"/>
            <form:errors path="roomName"/>
          </div>
          <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="submit" class="btn btn-primary">Create Room</button>
      	  </div>
        </form:form>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
	    $('#exampleModal').on('show.bs.modal', function (event) {
	    	  var button = $(event.relatedTarget) // Button that triggered the modal
	    })
</script>
</body>
</html>