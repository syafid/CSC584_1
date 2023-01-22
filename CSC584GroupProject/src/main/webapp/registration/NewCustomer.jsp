<%@page import="java.util.ArrayList" %>
<%@page import="java.util.HashSet"%>
<%@page import="customer.*" %>
<%@page import="car.*" %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>New Customer Registration</title>
</head>
<body>
<div class="container">
<h1>New Customer Registration</h1>
<div class="card">
 <div class="card-body">
 <form action="RegisterCustomerServlet" method="post">
 <div class="form-group row"> 
 	<label for="custName" class="col-sm-3 col-form-label">Full Name</label>
 	<input type="text" name="custName" size="50" maxlength="50" required="required">
 	
 </div>
 
  <div class="form-group row"> 
 	<label for="custMyKad" class="col-sm-3 col-form-label">MyKad</label>
 	<input type="text" name="custMyKad" size="12" maxlength="12" required="required"><p class="text-danger">* without (-)</p>
 </div>
 
  <div class="form-group row"> 
 	<label for="custPhoneNo" class="col-sm-3 col-form-label">Mobile No</label>
 	<input type="text" name="custPhoneNo" size="10" maxlength="10" required="required">
 </div>
 
  <div class="form-group row"> 
 	<label for="custAddress" class="col-sm-3 col-form-label">Address</label>
 	<textarea name="custAddress" rows="4" cols="50" required="required"></textarea>
 </div>
 

 
  <div class="form-group row"> 
 	<label for="custEmail" class="col-sm-3 col-form-label">Email</label>
 	<input type="email" name="custEmail" size="20" maxlength="20" required="required"><p class="text-danger">* This email will be use to login Service Appointment System</p>
 </div>
 
  <div class="form-group row"> 
 	<label for="custPasswd" class="col-sm-3 col-form-label">Password</label>
 	<input type="password" name="custPasswd" size="8" maxlength="8" required="required"><p class="text-danger">*8 character password only</p>
 </div>
 
 <div class="form-group row"> 
 <label for="car" class="col-sm-3 col-form-label">Select Car Model/Variant</label>
 
 <select name="car" id="car">
 <%ArrayList car = (ArrayList) request.getAttribute("car"); %>
 
 <% for (int recordCount = 0; recordCount < car.size(); recordCount ++ )  { %>
    <% Car cr = (Car)car.get(recordCount); %>
   
   
 
 <option value="<%= cr.getCarID()%>"><%= cr.getCarModel() %> <%= cr.getCarVariant() %> <%= cr.getCarTransmission() %></option>
<%} %>
    </select>
   
</div>

<div class="form-group row"> 
 	<label for="custCarPlate" class="col-sm-3 col-form-label">Car Plate No</label>
 	<input type="text" name="custCarPlate" size="12" maxlength="12" required="required">
 </div>
 
 <div class="form-group row"> 
 	<label for="custCarMileage" class="col-sm-3 col-form-label">Current Car Mileage (KM)</label>
 	<input type="number" name="custCarMileage" size="6" maxlength="6">
 </div>
 
<!--  <div class="form-group row"> -->
<!--       <label for="date" class="col-sm-4 col-form-label">Appointment Date</label> -->
<!--       <div class="col-sm-7"> -->
<!--        <input type="date" class="form-control" name="date" -->
<!--         placeholder="Pick a date"> -->
<!--       </div> -->
<!--  </div> -->
     
 <button type="submit" class="btn btn-primary" name="newCust">Submit</button>    
 </form> 
</div>

</body>
</html>