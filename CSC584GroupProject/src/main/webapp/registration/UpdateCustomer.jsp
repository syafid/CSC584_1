<%@page import="java.util.ArrayList" %>
<%@page import="java.util.HashSet"%>
<%@page import="customer.*" %>
<%@page import="car.*" %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Update Customer Info</title>
</head>
<body>
<%DaoCust cust = new DaoCust(); %>
<div class="container">
<h1>Update Customer Information</h1>
<div class="card">
 <div class="card-body">
 <form action="UpdateCustomerServlet" method="POST">
 <div class="form-group row"> 
 	<label for="custName" class="col-sm-3 col-form-label">Customer ID</label>
 	<input type="text" name="cusID" value="<%=request.getParameter("cusID")%>" disabled >
 	    <input type="hidden" name="cusID" value="<%=request.getParameter("cusID")%>" >
 	    
 </div>
<%ArrayList<Customer> CustList = cust.getCustomer(Integer.parseInt(request.getParameter("cusID"))); %> 
 <div class="form-group row"> 
 	<label for="custName" class="col-sm-3 col-form-label">Full Name</label>
 	<input type="text" name="custName" value="<%=CustList.get(0).getCusName() %>" required="required">
 	
 </div>
 
  <div class="form-group row"> 
 	<label for="custMyKad" class="col-sm-3 col-form-label">MyKad</label>
 	<input type="text" name="custMyKad" value="<%=CustList.get(0).getCusMyKad() %>" required="required"><p class="text-danger">* without (-)</p>
 </div>
 
  <div class="form-group row"> 
 	<label for="custPhoneNo" class="col-sm-3 col-form-label">Mobile No</label>
 	<input type="text" name="custPhoneNo" value="<%=CustList.get(0).getCusPhoneNo() %>" required="required">
 </div>
 
 
   <div class="form-group row"> 
 	<label for="custAddress" class="col-sm-3 col-form-label">Address</label>
 	<input type="text" name="custAddress" size="100" value="<%=CustList.get(0).getCusAdd() %>" required="required"> </textarea>
 </div>

 
  <div class="form-group row"> 
 	<label for="custEmail" class="col-sm-3 col-form-label">Email</label>
 	<input type="email" name="custEmail" size="50" value="<%=CustList.get(0).getCusEmail() %>" disabled>
 	<input type="hidden" name="custEmail" value="<%=CustList.get(0).getCusEmail()%>" >
 </div>
 

 <div class="form-group row"> 
 <label for="car" class="col-sm-3 col-form-label">Select Car Model/Variant</label>
 
 <select name="car" id="car">
 
 <%DaoCar car = new DaoCar(); %>
 
  <%ArrayList carType = (ArrayList) car.getCarType(CustList.get(0).getCusCarType()); %>
  <% for (int a = 0; a < carType.size(); a ++ )  { %>
    <% Car cr = (Car)carType.get(a); %>
   <option selected value="<%=cr.getCarID()%>"><%=cr.getCarModel()%><%= cr.getCarVariant() %> <%= cr.getCarTransmission() %></option>
   
  
   <%} %>
   <%ArrayList carList = (ArrayList) car.getResultSet(); %>
   <%for (int b=0;b<carList.size();b++) { %>
   			  <% Car cr2 = (Car)carList.get(b); %>
		  <option value="<%= cr2.getCarID()%> "><%=cr2.getCarModel()%> <%= cr2.getCarVariant() %> <%= cr2.getCarTransmission() %> </option>
   <%} %>
    </select>
   
</div>

 
<div class="form-group row"> 
 	<label for="custCarPlate" class="col-sm-3 col-form-label">Car Plate No</label>
 	<input type="text" name="custCarPlate" value="<%=CustList.get(0).getCusCarPlate() %>" required="required">
 </div>
 
 <div class="form-group row"> 
 	<label for="custCarMileage" class="col-sm-3 col-form-label">Current Car Mileage (KM)</label>
 	<input type="number" name="custCarMileage" value="<%=CustList.get(0).getCusCurrMileage() %>">
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