<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>CSC584</title>
</head>
<body>
<%if (request.getAttribute("message") == "alert-success") { %>
 <div class="alert alert-success" role="alert"> <!--alert alert-success -->
  Success Add New Customer.
</div>

<%} else if (request.getAttribute("message") == "alert-danger") { %>
<div class="alert alert-danger" role="alert">
  Customer Already Exist. Failed To Register. Please Try Again.
</div>
<%} else { %>
<div><%request.getAttribute("message_error");%></div>
<%} %>

<div class="container">
	<h1>Proton Mesra Service Center</h1>
	<div class="card">
 		<div class="card-body">
			<table border="1">
			<th colspan="3">Table Maintenance</th>
			<tr></tr>
			<tr colspan="3">
			<td>Bil</td><td>Table Name</td><td>Action</td>
			
			</tr>
			<tr>
				<td>1</td><td>Customer</td>
				<td>
				<form action="CarServlet">
					<input type="submit" value="New Customer" class="btn">
				</form>
				</td>
			</tr>
			<tr>
				<td>2</td><td>Car</td>
				<td>
				
				</td>
			</tr>
			<tr>
				<td>3</td><td>Service</td><td></td>
			</tr>
			<tr>
				<td>4</td><td>Appointment</td>
				<td>
				<form action="AppointmentAdd">
					<input type="submit" value="New Appointment" class="btn">
				</form>
				</td>
			</tr>
			<tr>
				<td>5</td><td>Employee</td><td></td>
			</tr>
			<tr>
				<td>6</td><td>User</td>
				<td>
				<form action="UserServlet">
					<input type="submit" value="New User" class="btn">
				</form></td>
			</tr>
			</table>
		</div>
	</div>
</div>
</body>
</html>
</html>