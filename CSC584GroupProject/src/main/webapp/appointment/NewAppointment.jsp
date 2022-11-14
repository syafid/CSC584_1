<%@page import="java.util.ArrayList" %>
<%@page import="appointment.Appointment" %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>New Appointment Registration</title>
</head>
<body>
<div class="container">
<h1>New Appointment Registration</h1>
<div class="card">
 <div class="card-body">
 <form action="" method="get">
 <div class="form-group row"> 
 <label for="service" class="col-sm-2 col-form-label">Pick Service Type</label>
 
 <select name="service" id="service">
 <%ArrayList service = (ArrayList) request.getAttribute("service"); %>
 
 <% for (int recordCount = 0; recordCount < service.size(); recordCount ++ )  { %>
    <% Appointment appt = (Appointment)service.get(recordCount); %>
   
 
 <option value="<%= appt.getServiceID() %>"><%= appt.getServiceName() %></option>
<%} %>
    </select>
   

 </div>
 
 <div class="form-group row">
      <label for="date" class="col-sm-2 col-form-label">Appointment Date</label>
      <div class="col-sm-7">
       <input type="date" class="form-control" name="date"
        placeholder="Pick a date">
      </div>
 </div>
     
 <button type="submit" class="btn btn-primary">Submit</button>    
 </form> 
</div>

</body>
</html>