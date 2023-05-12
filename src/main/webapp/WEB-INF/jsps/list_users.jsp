<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Users</title>
</head>
<title>All Users</title>
</head>
 
 	<body>
	<h2>All || Users</h2>
	<hr>
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Mobile Number</th>
			<th>Address</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td>${user.mobileNumber}</td>
				<td>${user.address.street}, ${user.address.city}, ${user.address.state}, ${user.address.country}, ${user.address.zip}</td>
				<td><a href="${pageContext.request.contextPath}/deleteUser?id=${user.id}">Delete</a></td>
				<td><a href="${pageContext.request.contextPath}/update/${user.id}">Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>


 	