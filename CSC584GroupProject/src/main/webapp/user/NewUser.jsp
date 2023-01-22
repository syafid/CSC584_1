<%@page import="java.util.ArrayList" %>
<%@page import="user.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body>
<div class="container">
	<h1>New Staff Registration</h1>
		<div class="card">
 			<div class="card-body">
 				<form action="UserServlet" method="post">
 					<div class="form-group row"> 
					 	<label for="userName" class="col-sm-3 col-form-label">Staff Name</label>
					 	<input type="text" name="userName" size="50" maxlength="50" required="required">
 					</div>
 					<div class="form-group row"> 
					 	<label for="userIDNo" class="col-sm-3 col-form-label">Staff MyKAD</label>
					 	<input type="text" name="userIDNo" size="12" maxlength="12" required="required">
 					</div>
 					<div class="form-group row"> 
					 	<label for="userContactNo" class="col-sm-3 col-form-label">Staff Phone No</label>
					 	<input type="text" name="userContactNo" size="10" maxlength="10" required="required">
 					</div>
 					<div class="form-group row"> 
					 	<label for="userDOB" class="col-sm-3 col-form-label">Staff D.O.B</label>
					 	<input type="date" data-date-format="DD-MM-YYYY" name="userDOB" size="10" maxlength="10" required="required">
 					</div>
 					<div class="form-group row"> 
					 	<label for="userEmail" class="col-sm-3 col-form-label">Staff Email</label>
					 	<input type="text" name="userEmail" size="50" maxlength="50" required="required"><p class="text-danger"> *This email will use to login Proton Service Center Appointment System </p>
 					</div>
 					<div class="form-group row"> 
					 	<label for="userPassword" class="col-sm-3 col-form-label">Staff Password</label>
					 	<input type="password" name="userPassword" size="8" maxlength="8" required="required"><p class="text-danger"> *8 character password only</p>
 					</div>
 					<div class="form-group row"> 
					 	<label for="roles" class="col-sm-3 col-form-label">Staff Roles</label>
					 	<select name="roles" id="roles" required="required">
					 	    <option disabled selected value>Please Choose </option>
					        <option value="supervisor">Supervisor</option>
					        <option value="technician">Technician</option>
					        
					      </select>
					</div>      
 				
 				
 				<button type="submit" class="btn btn-primary">Submit</button>    
 				</form>
 			</div>
		 </div>
</div>
</body>
</html>