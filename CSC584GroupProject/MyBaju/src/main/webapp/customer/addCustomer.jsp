<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="customerServlet.*" %>
<!DOCTYPE html>
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Add New Customer</title>
</head>
<body>
<div class="container">
<div class="card">
	<div class="card-header">Add New Customer</div>
	<div class="card-body">
	 <form action="/MyBaju/AddCustomerController" method="POST">
	 	<div class="mb-3 row">
		    <label for="name" class="col-sm-2 col-form-label">Name</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="name" required>
		    </div>
  		</div>
  	
  	 	<div class="mb-3 row">
		    <label for="phoneNo" class="col-sm-2 col-form-label">Phone Number</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="phoneNo" required>
		    </div>
  		</div>
  	
  	 	<div class="mb-3 row">
		    <label for="address" class="col-sm-2 col-form-label">Address</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="address" required>
		    </div>
  		</div>
  	
  	 <div class="col-12">
	 	<button class="btn btn-primary" type="submit" value="submit">Save</button>
	 	<button class="btn btn-alert" type="cancel" value="cancel">Cancel</button>
  	 </div>
	 
	 
	 </form>
	 
	
	
	</div>
</div>

<table class="table">

</table>




</div>

</body>
</html>