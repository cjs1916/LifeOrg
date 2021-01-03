<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To Do Lists</title>
</head>
<body>

	<div>
		Create new To Do list->
			<form action="/create" method="post">
			
			<input type="submit" value="Click here"/></form>
	</div>
	<c:if test="${isEmpty=false}">
		<c:forEach items="${toDos}" var="list">
				<a href="/todo/${list.id}">List ${list.id} </a>
		</c:forEach>
	</c:if>
	<c:if test="${isEmpty=true}">
			<p>No items yet!</p>
			<p>Add an item</p>
	</c:if>
</body>
</html>