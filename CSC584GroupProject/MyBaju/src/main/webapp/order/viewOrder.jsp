<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.ArrayList" %>
     <%@page import="ordersServlet.*" %>
       <%@page import="customerServlet.*" %>
       <%@page import="tailorServlet.*" %>
       <%@page import="materialServlet.*" %>
       <%@page import="fashionServlet.*" %>
       <%@page import="java.sql.Date" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>View Orders</title>
</head>
<body>
<div class="container">
<div class="card">
	<div class="card-header">View Order</div>
	<div class="card-body">
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Order ID</th>
      <th scope="col">Sleeve</th>
      <th scope="col">Shoulder</th>
      <th scope="col">Chest</th>
      <th scope="col">Top Length</th>
      <th scope="col">Waist</th>
      <th scope="col">Hip</th>
      <th scope="col">Bottom Length</th>
      <th scope="col">Customer Name</th>
      <th scope="col">Customer ID</th>
      <th scope="col">Material</th>
      <th scope="col">Fashion</th>
      <th scope="col">Price (RM)</th>
      <th scope="col">Order Status</th>
      <th scope="col">Complete Date</th>
    </tr>
  </thead>


  <tbody>
<%ordersDao orderDao = new ordersDao(); %>
<%ArrayList<Orders> orderList = orderDao.getOrder(Integer.parseInt(request.getParameter("orderId"))); %>
	  <% for (int i = 0; i < orderList.size(); i ++ )  { %>
    <tr>
      <td><%=orderList.get(i).getOrderId() %></td>
    
      <td><%=orderList.get(i).getSleeve() %></td>
      <td><%=orderList.get(i).getShoulder()%></td>
      <td><%=orderList.get(i).getChest() %></td>
      <td><%=orderList.get(i).getTopLength() %></td>
      <td><%=orderList.get(i).getWaist() %></td>
      <td><%=orderList.get(i).getHip() %></td>
      <td><%=orderList.get(i).getBottomLength() %></td>
      <td style="width:15%">
<%customerDao customer1 = new customerDao(); %>      
<%ArrayList<Customer> cust = customer1.getCustomer(orderList.get(i).getCustomerId()); %>
		<% for (int s = 0; s < cust.size(); s ++ )  { %>
     			<%=cust.get(0).getName()%>
       
      </td>
      <td>
      			<%=cust.get(0).getCustomerId()%>
      </td>
      
        <%} %>
      <%MaterialDao matList = new MaterialDao(); %>      
	  <%ArrayList<material> material = matList.getMaterialName(orderList.get(i).getMaterial_id()); %>
		<% for (int w = 0; w < material.size(); w ++ )  { %>  
		
       <td> <%=material.get(w).getMaterial_name() %>  </td>
    <%} %>
         
       <%fashionDao fashList = new fashionDao(); %>      
	   <%ArrayList<fashion> fashion = fashList.getFashion(orderList.get(i).getDesign_id()); %>
	   <% for (int o = 0; o < fashion.size(); o ++ )  { %>  
		  
        <td><%=fashion.get(o).getFashion_name() %> </td>
        <td><%=fashion.get(o).getPrice()  %></td>
        <%} %>
        
       <% if(orderList.get(i).getOrders_status()==0) {%> 
      		 <td>New Order</td>
       <%}else if(orderList.get(i).getOrders_status()==1) {%>
       		<td>Order In Process</td>
       <%}else if (orderList.get(i).getOrders_status()==2){ %>
       		<td>Order Complete</td>
       <%} %>
      <td style="width:30%">
      <%
      if(orderList.get(i).getOrders_status()==2) {
      %>
      <!-- <a target="_self" href="<%= request.getContextPath() %>/order/updateOrder.jsp?orderId=<%=orderList.get(i).getOrderId() %>">
    		<button class="btn btn-success">Update</button>
  			</a>  -->
  			<%=orderList.get(i).getDateCompleted() %>
  		<%} %>	
  			<!-- <a target="_self" href="<%=request.getContextPath()%>/DeleteOrdersController?orderId=<%=orderList.get(i).getOrderId() %>">
    		<button class="btn btn-warning">Delete</button>
  			</a>-->
      
      
      </td>
    </tr>
    <%} %>
 
  </tbody>
</table>
	 <div class="col-12">
	 	<a target="_self" href="<%= request.getContextPath() %>/order/listOrder.jsp">
    		<button class="btn btn-success">List Order</button>
  			</a> 
	 	<!-- <button class="btn btn-alert" type="cancel">Add New Order</button> -->
  	 </div>
	
	
	</div>
</div>
</div>

</body>
</html>