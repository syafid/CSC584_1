<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="reporting.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>REPORT</title>
</head>
<body>
<div class="container">
<table>
 <%int cust_count = (Integer)session.getAttribute("cust_count");  %>
 <%int app_count = (Integer)session.getAttribute("app_count");  %> 
  <%int staff_count = (Integer)session.getAttribute("staff_count");  %> 
<thead><h3>REPORT ANALYSIS</h3></thead>
<tr>
<td><div class="card border-primary mb-3" style="max-width: 18rem;">
  <div class="card-header">Total No Of Customers</div>
  <div class="card-body text-primary">
    <h5 class="card-title"></h5>
    <p class="card-text"><%=cust_count %></p>
  </div>
</div>
</td>

<td>
<div class="card border-success mb-3" style="max-width: 18rem;">
  <div class="card-header">Total No Of Appointments</div>
  <div class="card-body text-success">
    <h5 class="card-title"></h5>
    <p class="card-text"><%=app_count %></p>
  </div>
</div>
</td>

<td>
<div class="card border-warning mb-3" style="max-width: 18rem;">
  <div class="card-header">Total No Of Staffs</div>
  <div class="card-body text-warning">
    <h5 class="card-title"></h5>
    <p class="card-text"><%=staff_count %></p>
  </div>
</div>
</td>

</tr>
</table>
</div>
</body>
</html>