<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>leadInfo</title>
</head>

	<body>
    <h2>User Info</h2>
    <hr>
    First Name: ${user.name }<br />
    Email: ${user.email }<br />
    Mobile Number: ${user.mobileNumber }<br />
    <hr>
    Address:<br>
    Street: ${user.address.street }<br>
    City: ${user.address.city }<br>
    State: ${user.address.state }<br>
    Country: ${user.address.country }<br>
    Zip Code: ${user.address.zip }<br>
    <hr>
    <img src="<c:url value='/image/${user.id}'/>" alt="User Image">
    <hr>
    ${msg }<br />
</body>

</html>