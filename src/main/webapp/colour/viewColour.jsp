<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="fashionServlet.*" %>
    <%@page import="ordersServlet.*" %>
    <%@page import="customerServlet.*" %>
    <%@page import="materialServlet.*" %>
    <%@page import="tailorServlet.*" %>
     <%@page import="colourServlet.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>View Colour By Orders</title>
</head>
<body>
<div class="container">
<div class="card">
	<div class="card-header">View Colour By Orders</div>
	<div class="card-body">
	<table class="table">
  <thead>
    <tr>
    	<th scope="col">Order ID</th>
    	<th scope="col">Order Date</th>
    	<th scope="col">Customer Name</th>
    	<th scope="col">Material</th>
    	<th scope="col">Tailor</th>
    	<th scope="col">Colour</th>
    	<th scope="col">Order Status</th>
    	<th scope="col">Complete Date</th>
    	
    </tr>
  </thead>


  <tbody>
<%
  ordersDao orderDao = new ordersDao();
  ArrayList<Orders> color = orderDao.getColourOrder(Integer.parseInt(request.getParameter("colourId"))); 
  for (int a=0; a<color.size(); a++) {
  %>
  <tr>
  <td><%=color.get(a).getOrderId() %></td>
  <td><%=color.get(a).getDateCreated() %></td>
  
 <%customerDao customer1 = new customerDao(); %>      
 <%ArrayList<Customer> cust = customer1.getCustomer(color.get(a).getCustomerId()); %>
		<% for (int s = 0; s < cust.size(); s ++ )  { %>
  			<td><%=cust.get(s).getName() %></td>
  		<%} %>
  		
 <%MaterialDao matList = new MaterialDao();     
   ArrayList<material> material = matList.getMaterialName(color.get(a).getMaterial_id());
   	for (int w = 0; w < material.size(); w ++ )  { %>  		
  		<td><%=material.get(w).getMaterial_name() %></td>
  		<%} %>
  		
  		
 <%
 tailorDao tailor = new tailorDao();
 ArrayList<tailor> tailors = tailor.getTailor(color.get(a).getTailor_id());
		 for(int t = 0; t < tailors.size();t++ ) {
 %> 		
  <td><%=tailors.get(t).getTailor_name() %></td>
  
  <%} %>
  
  <%
  colourDao colour = new colourDao();
  ArrayList<colour> colours = colour.getColourName(color.get(a).getColour_id());
  		for(int y=0; y < colours.size(); y++) {
  %>
  <td><%=colours.get(y).getColour_name() %></td>
  <%} %>
  
  <%
  if(color.get(a).getOrders_status()==0) {  
  %>
  <td>New Order</td>
  <%}else if(color.get(a).getOrders_status()==1) { %>
  <td>Order In Process</td>
  <%}else if(color.get(a).getOrders_status()==2) {%>
  <td>Order Complete</td>
  <%} %>
  
  
  <%
  if(color.get(a).getOrders_status()==2) {
  %>
  <td><%=color.get(a).getDateCompleted() %></td>
  <%} else { %>
  
  <td>n/a</td>
  
  <%} %>
  
  </tr>
  <%} %>
 </tbody>
</table>
	 <div class="col-12">
	 	<a target="_self" href="<%= request.getContextPath() %>/colour/listColour.jsp">
    		<button class="btn btn-success">List Colour</button>
  			</a> 
	 	<!-- <button class="btn btn-alert" type="cancel">Add New Order</button> -->
  	 </div>
	
	
	</div>
</div>
</div>

</body>
</html>