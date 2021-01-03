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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-between">
	    <h3 class="text-center"><c:out value="${thisRoom.roomName}"/></h3>
	    <a href="/rooms" style="padding-top:30px;">Chat Main</a>
	</div>
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
          		<c:if test="${thisRoom.id == room.id}">
	            <div class="chat_list active_chat" style="background-color: white;">
	              <div class="chat_people">
	                <div class="chat_img"> <img src="https://cdn3.iconfinder.com/data/icons/text-messaging-3/512/6-512.png" alt="user"> </div>
	                <div class="chat_ib">
	                  <h5><a href="/rooms/${room.id}" class="fill-div">${room.roomName}</a></h5>
	                </div>
	              </div>
	            </div>
	            </c:if>
	            <c:if test="${thisRoom.id != room.id }">
		            <div class="chat_list active_chat">
		              <div class="chat_people">
		                <div class="chat_img"> <img src="https://cdn3.iconfinder.com/data/icons/text-messaging-3/512/6-512.png" alt="user"> </div>
		                <div class="chat_ib">
		                  <h5><a href="/rooms/${room.id}" class="fill-div">${room.roomName}</a></h5>
		                </div>
		              </div>
		            </div>
	            </c:if>
            </c:forEach>
          </div>
        </div>
        <div class="mesgs">
          <div class="msg_history">
          
            <c:forEach var="message" items="${thisRoom.messages}">
            	<c:if test="${message.author.equals(user) }">
		            <div class="outgoing_msg">
		              <div class="sent_msg">
		                <p>${message.content}</p>
		                <span class="time_date"> ${message.createdAt}</span>
		              </div>
		            </div>
	            </c:if>
	            <c:if test="${!message.author.equals(user)}">
		            <div class="incoming_msg">
		              <div class="incoming_msg_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="user">
		              </div>
		              <span>${message.author.firstName} ${message.author.lastName}</span>
		              <div class="received_msg">
		                <div class="received_withd_msg">
		                  <p>${message.content}</p>
		                  <span class="time_date"> ${message.createdAt}</span>
		                </div>
		              </div>
		            </div>
	            </c:if>
            </c:forEach>
            

          </div>
          <div class="type_msg">
            <div class="input_msg_write">
              <div class="form-group">
	              <form:form action="/rooms/${thisRoom.id}/message" method="post" modelAttribute="message">
		              <form:input type="text" path="content" class="write_msg form-control" placeholder="Type a message" />
		              <form:button class="msg_send_btn" type="submit"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></form:button>
	              </form:form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>