<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
 <body>
	<h2>Update || User</h2>
	<hr>
	<pre>
	<form action="/update/${user.id}" method="post">
		<input type="hidden" name="id" value="${user.id}">
		<label for="name">Name:</label>
		<input type="text" id="name" name="name" value="${user.name}" required>
		<label for="email">Email:</label>
		<input type="email" id="email" name="email" value="${user.email}" required>
		<label for="mobileNumber">Mobile Number:</label>
		<input type="text" id="mobileNumber" name="mobileNumber" value="${user.mobileNumber}" required>
		<label for="street">Street:</label>
		<input type="text" id="street" name="address.street" value="${user.address.street}" required>
		<label for="city">City:</label>
		<input type="text" id="city" name="address.city" value="${user.address.city}" required>
		<label for="state">State:</label>
		<input type="text" id="state" name="address.state" value="${user.address.state}" required>
		<label for="country">Country:</label>
		<input type="text" id="country" name="address.country" value="${user.address.country}" required>
		<label for="zipCode">Zip Code:</label>
		<input type="text" id="zipCode" name="address.zipCode" value="${user.address.zip}">
		<input type="submit" value="Update">
	</form>
	</pre>
</body>
 
</html>