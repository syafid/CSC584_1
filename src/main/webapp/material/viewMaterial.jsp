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
<title>View Material Count</title>
</head>
<div class="container">
<div class="card">
	<div class="card-header">View Material Count</div>
	<div class="card-body">
	<table class="table">
  <thead>
    <tr>
    	<th scope="col">Order ID</th>
    	<th scope="col">Order Date</th>
    	<th scope="col">Customer Name</th>
    	<th scope="col">Material</th>
    	
    	
    </tr>
  </thead>


  <tbody>
   <%
  ordersDao orderDao = new ordersDao();
  ArrayList<Orders> material = orderDao.getMaterialOrder(Integer.parseInt(request.getParameter("materialId"))); 
  for (int a=0; a<material.size(); a++) {
  %>
  <tr>
  <td><%=material.get(a).getOrderId() %></td>
  <td><%=material.get(a).getDateCreated() %></td>
  
  <%customerDao customer1 = new customerDao(); %>      
 <%ArrayList<Customer> cust = customer1.getCustomer(material.get(a).getCustomerId()); %>
		<% for (int s = 0; s < cust.size(); s ++ )  { %>
  			<td><%=cust.get(s).getName() %></td>
  		<%} %>
  
  <%MaterialDao matList = new MaterialDao();     
  ArrayList<material> mater = matList.getMaterialName(material.get(a).getMaterial_id());
   	for (int w = 0; w < mater.size(); w ++ )  { %>  		
  		<td><%=mater.get(w).getMaterial_name() %></td>
  		<%} %>
  
  
  <%} %>
  </tr>
 </tbody>
</table>
	 <div class="col-12">
	 	<a target="_self" href="<%= request.getContextPath() %>/material/listMaterial.jsp">
    		<button class="btn btn-success">List Material</button>
  			</a> 
	 	<!-- <button class="btn btn-alert" type="cancel">Add New Order</button> -->
  	 </div>
	
	
	</div>
</div>
</div>

</body>
</html>