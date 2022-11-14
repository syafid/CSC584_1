<%@page import="java.util.ArrayList" %>
<%@page import="java.util.HashSet"%>
<%@page import="customer.Customer" %>
<%@page import="car.Car" %>


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
 <form action="CustomerServlet" method="get">
 <div class="form-group row"> 
 	<label for="custName" class="col-sm-4 col-form-label">Customer Name</label>
 	<input type="text" name="custName" size="50" maxlength="50" required="required">
 	
 </div>
 
  <div class="form-group row"> 
 	<label for="custMyKad" class="col-sm-4 col-form-label">Customer MyKad</label>
 	<input type="text" name="custMyKad" size="12" maxlength="12" required="required"><p class="text-danger">* without (-)</p>
 </div>
 
  <div class="form-group row"> 
 	<label for="custPhoneNo" class="col-sm-4 col-form-label">Customer Mobile No</label>
 	<input type="text" name="custPhoneNo" size="10" maxlength="10" required="required">
 </div>
 
  <div class="form-group row"> 
 	<label for="custEmail" class="col-sm-4 col-form-label">Customer Email</label>
 	<input type="email" name="custEmail" size="20" maxlength="20" required="required">
 </div>
 
 <div class="form-group row"> 
 <label for="car" class="col-sm-4 col-form-label">Pick Car Model/Variant</label>
 
 <select name="car" id="car">
 <%ArrayList car = (ArrayList) request.getAttribute("car"); %>
 
 <% for (int recordCount = 0; recordCount < car.size(); recordCount ++ )  { %>
    <% Car cr = (Car)car.get(recordCount); %>
   
   
 
 <option value="<%= cr.getCarID()%>"><%= cr.getCarModel() %> <%= cr.getCarVariant() %> <%= cr.getCarTransmission() %></option>
<%} %>
    </select>
   
</div>

<div class="form-group row"> 
 	<label for="custCarPlate" class="col-sm-4 col-form-label">Customer Car Plate No</label>
 	<input type="text" name="custCarPlate" size="12" maxlength="12" required="required">
 </div>
 
 <div class="form-group row"> 
 	<label for="custCarMileage" class="col-sm-4 col-form-label">Customer Car Mileage (KM)</label>
 	<input type="number" name="custCarMileage" size="6" maxlength="6">
 </div>
 
<!--  <div class="form-group row"> -->
<!--       <label for="date" class="col-sm-4 col-form-label">Appointment Date</label> -->
<!--       <div class="col-sm-7"> -->
<!--        <input type="date" class="form-control" name="date" -->
<!--         placeholder="Pick a date"> -->
<!--       </div> -->
<!--  </div> -->
     
 <button type="submit" class="btn btn-primary">Submit</button>    
 </form> 
</div>

</body>
</html>