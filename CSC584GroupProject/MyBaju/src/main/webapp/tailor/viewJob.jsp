<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList" %>
     <%@page import="ordersServlet.*" %>
       <%@page import="customerServlet.*" %>
       <%@page import="tailorServlet.*" %>
       <%@page import="materialServlet.*" %>
       <%@page import="fashionServlet.*" %>
       <%@page import="colourServlet.*" %>
       <%@page import="java.sql.Date" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>View Tailor Job</title>
</head>
<body>
<div class="container">
<div class="card">
	<div class="card-header">View Tailor Job</div>
	<div class="card-body">
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Order ID</th>
      <th scope="col">Customer ID</th>
      <th scope="col">Customer Name</th>
      <th scope="col">Material</th>
      <th scope="col">Fashion</th>
      <th scope="col">Price (RM)</th>
      <th scope="col">Colour</th>
      <th scope="col">Status</th>
      
    </tr>
  </thead>


  <tbody>
<%ordersDao orderDao = new ordersDao(); %>
<%ArrayList<Orders> tailOrder = orderDao.getTailorOrder(Integer.parseInt(request.getParameter("tailorId"))); 
  for (int i = 0; i < tailOrder.size(); i ++ )  {%>
  <tr>
      <td><%=tailOrder.get(i).getOrderId() %></td>
      
      <%
      customerDao getCustName = new customerDao();
      ArrayList<Customer> custDetail = getCustName.getCustomer(tailOrder.get(i).getCustomerId());
      for (int c = 0; c < custDetail.size(); c++) {
      %>
      <td><%=custDetail.get(c).getCustomerId() %></td>
      <td><%=custDetail.get(c).getName() %></td>
      
      <%} %>
      
      <%
      MaterialDao matDao = new MaterialDao();
      ArrayList<material> mater = matDao.getMaterialName(tailOrder.get(i).getMaterial_id());
      for (int d = 0; d < mater.size(); d++) {
      %>
      <td><%=mater.get(d).getMaterial_name() %></td>
      
      <%} %>
      
      <%
      fashionDao fashDao = new fashionDao();
      ArrayList<fashion> fashName = fashDao.getFashion(tailOrder.get(i).getDesign_id());
      for (int e = 0; e < fashName.size(); e++) {
      %>
      <td><%=fashName.get(e).getFashion_name() %></td>
      <td><%=fashName.get(e).getPrice() %></td>
      
      <%} %>
      
      <%
      colourDao colDao = new colourDao();
      ArrayList<colour> colourName = colDao.getColourName(tailOrder.get(i).getColour_id());
      for (int f = 0; f < colourName.size(); f++) {
      %>
      <td><%=colourName.get(f).getColour_name() %></td>
      
      <%} %>
      
	      <%
	  if(tailOrder.get(i).getOrders_status()==0) {  
	  %>
	 	 <td>New Order</td>
	  <%}else if(tailOrder.get(i).getOrders_status()==1) { %>
	 	 <td>Order In Process</td>
	  <%}else if(tailOrder.get(i).getOrders_status()==2) {%>
	  	<td>Order Complete</td>
	  <%} %>
	  
      
      
           
 </tr> 
  
<%} %>  
  </tbody>
</table>
	 <div class="col-12">
	 	<a target="_self" href="<%=request.getContextPath() %>/tailor/listTailor.jsp">
    		<button class="btn btn-success">List Order</button>
  			</a> 
	 	<!-- <button class="btn btn-alert" type="cancel">Add New Order</button> -->
  	 </div>
	
	
	</div>
</div>
</div>
</body>
</html>