<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1>A Welcome Web Application</h1>
  <form method="GET" action="login">
<label for="name" title="Enter the name">Username: </label>
<input type="text" id="txtName" name="txtName"/><br><br>
<label for="passwd" title="Enter the password">Password: </label>
<input type="password" id="passwd" name="passwd"/><br><br>
<input type="submit" value="Submit"/>
</form>
</body>
</html>