<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Item</title>
</head>
<body>
	<form:form action="/addItem" method="post" modelAttribute="course">
		<div>
			<form:label path="item">Add item</form:label>
			<form:input path="item" />
			<form:errors path="item" />
		</div>
		<input type="submit" value="->" />
	</form:form>
	<table>
		<tr>
			<th>Item</th>
			<th>Action</th>
		</tr>
		<c:if test="${isEmpty=false}">
			<c:forEach items="${items}" var="item">
				<tr>
					<td><h1>${item.content}</h1></td>
					<td><a href="/todo/${todo.id}/remove/${item.id}">Remove</a></td>
			</c:forEach>
		</c:if>
		<c:otherwise>
			<tr>
				<td>No items yet!</td>
				<td>Add an item</td>
			</tr>
		</c:otherwise>
	</table>
</body>
</html>