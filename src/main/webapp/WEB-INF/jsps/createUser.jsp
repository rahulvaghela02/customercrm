<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create User</title>
</head>

<body>
	<h2>Create || User</h2>
	<hr>
	<pre>
	<form action="/save" method="post" enctype="multipart/form-data">
		<label for="name">Name:</label>
		<input type="text" id="name" name="name" required>
		<label for="email">Email:</label>
		<input type="email" id="email" name="email" required>
		<label for="mobileNumber">Mobile Number:</label>
		<input type="text" id="mobileNumber" name="mobileNumber" required>
		<label for="image">Image:</label>
		<input type="file" id="image" name="image">
		<label for="street">Street:</label>
		<input type="text" id="street" name="address.street" required>
		<label for="city">City:</label>
		<input type="text" id="city" name="address.city" required>
		<label for="state">State:</label>
		<input type="text" id="state" name="address.state" required>
		<label for="country">Country:</label>
		<input type="text" id="country" name="address.country" required>
		<label for="zip">Zip Code:</label>
		<input type="text" id="zip" name="address.zip">
		<input type="submit" value="Create">
	</form>
	</pre>
</body>
 

  
  
 
</html>