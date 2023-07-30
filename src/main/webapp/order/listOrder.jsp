<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.ArrayList" %>
       <%@page import="ordersServlet.*" %>
       <%@page import="customerServlet.*" %>
       <%@page import="tailorServlet.*" %>
       <%@page import="java.sql.Date" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>List All Orders</title>
</head>
<body>
<%if (request.getAttribute("message") == "update_success") { %>
<div class="alert alert-success" role="alert"><h3>
 Update Customer Order Success. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "update_error") { %>
<div class="alert alert-danger" role="alert"><h3>
 Error Update Customer Order. Please Try Again Later
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "success") { %>
<div class="alert alert-success" role="alert"><h3>
 New Order Added. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "error") { %>
<div class="alert alert-danger" role="alert">
 Error When Add New Order. Please Try Again Later
</div><br>
<%}%>

<%if (request.getAttribute("message") == "delete_success") { %>
<div class="alert alert-success" role="alert"><h3>
 Delete Order Success. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "delete_error") { %>
<div class="alert alert-danger" role="alert"><h3>
 Error on Delete Order. Please Try Again Later
</h3></div>
<%}%>
<div class="container">
<div class="card">
	<div class="card-header">List Orders</div>
	<div class="card-body">
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Orders ID</th>
      <th scope="col">Orders Date</th>
     
     
      <th scope="col">Orders Status</th>
      <th scope="col">Customer Name</th>
      <th scope="col">Customer ID</th>
      <th scope="col">Tailor ID</th>
      <th scope="col">Sewn By</th>
      <th scope="col">Action</th>
    </tr>
  </thead>


  <tbody>
<%ordersDao orderDao = new ordersDao(); %>
<%ArrayList<Orders> orderList = orderDao.getCustomerList(); %>
	  <% for (int i = 0; i < orderList.size(); i ++ )  { %>
    <tr>
      <td><%=orderList.get(i).getOrderId() %></td>
      <td><%=orderList.get(i).getDateCreated() %></td>
      
     
      <td> <% 
   if(orderList.get(i).getOrders_status()== 0) {
   %>
   <p color="green">New Orders</p>
   <%
   }else if(orderList.get(i).getOrders_status()== 1){
	   %>
   <p color="yellow">Orders In Process</p>
  <%
   }else if(orderList.get(i).getOrders_status()== 2){
   %>  
    <p color="blue">Orders Complete</p>
    <%} %>
   </td>
      <td>
<%customerDao customer1 = new customerDao(); %>      
<%ArrayList<Customer> cust = customer1.getCustomer(orderList.get(i).getCustomerId()); %>
		<% for (int s = 0; s < cust.size(); s ++ )  { %>
     			<%=cust.get(0).getName()%>
       
      </td>
      <td>
      			<%=cust.get(0).getCustomerId()%>
      </td>
   <%} %>
   
<%tailorDao tailList = new tailorDao(); %>      
<%ArrayList<tailor> tailor = tailList.getTailor(orderList.get(i).getTailor_id()); %>
		<% for (int w = 0; w < tailor.size(); w ++ )  { %>  
		
  			  <td> <%=tailor.get(w).getTailor_id() %>  </td>
    		  <td> <%=tailor.get(w).getTailor_name() %>  </td>
    		  
        
    
    <%} %>
   
   <%
   if((orderList.get(i).getOrders_status()== 2) || (orderList.get(i).getOrders_status()== 1)) {
   %>
   
   <td style="width:30%">
      		
  			<a target="_self" href="<%= request.getContextPath() %>/order/updateOrder.jsp?orderId=<%=orderList.get(i).getOrderId() %>">
    		<button class="btn btn-success">Update</button>
  			</a> 
  			<a target="_self" href="<%= request.getContextPath() %>/order/viewOrder.jsp?orderId=<%=orderList.get(i).getOrderId() %>">
    		<button class="btn btn-warning">View</button>
  			</a> 
  			
  			
      
      
      </td>
   
   <%}else if(orderList.get(i).getOrders_status()== 0) { %>
      <td style="width:30%">
      		<a target="_self" href="<%= request.getContextPath() %>/order/updateOrder.jsp?orderId=<%=orderList.get(i).getOrderId() %>">
    		<button class="btn btn-success">Update</button>
  			</a> 
  			
  			<a target="_self" href="<%= request.getContextPath() %>/order/viewOrder.jsp?orderId=<%=orderList.get(i).getOrderId() %>">
    		<button class="btn btn-warning">View</button>
  			</a> 
  			
  			<a target="_self" href="<%=request.getContextPath()%>/DeleteOrdersController?orderId=<%=orderList.get(i).getOrderId() %>">
    		<button class="btn btn-danger">Delete</button>
  			</a>
      
      
      </td>
      <%} %>
      
    </tr>
    <%} %>
 
  </tbody>
</table>
	 <div class="col-12">
	 	<a target="_self" href="<%= request.getContextPath() %>/index.html">
    		<button class="btn btn-success">Home</button>
  			</a> 
	 	<!-- <button class="btn btn-alert" type="cancel">Add New Order</button> -->
  	 </div>
	
	
	</div>
</div>
</div>

</body>
</html>