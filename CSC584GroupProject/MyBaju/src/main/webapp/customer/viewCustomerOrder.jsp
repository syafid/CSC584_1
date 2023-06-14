<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="java.util.*" %>
    <%@page import="customerServlet.*" %>
    <%@page import="ordersServlet.*" %>
    <%@page import="materialServlet.*" %>
    <%@page import="fashionServlet.*" %>
    <%@page import="colourServlet.*" %>
    <%@page import="paymentServlet.*" %>
    <%@page import="connection.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>

function update1(selectObject) {
	var status = document.getElementById("orderSta");
	  var value1 = selectObject.value;  
	  status.value = value1;
	}
</script>
<title>View Customer Orders</title>
</head>
<body>
<div class="container">
<div class="card">
<%ordersDao ordDao = new ordersDao(); %>
<%ArrayList<Orders> order = ordDao.getCustomerOrder(Integer.parseInt(request.getParameter("id1")));%>
<%if (order.size() == 0) {%>
<div class="card-header">Customer Orders</div>
	<div class="card-body">
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Orders ID</th>
       <th scope="col">Orders Date</th>
      <th scope="col">Orders Status</th>
      <th scope="col">Material</th>
      <th scope="col">Colour</th>
      <th scope="col">Fashion</th>
      <th scope="col">Price (RM)</th>
       <th scope="col">Payment Status</th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
  
  <tbody>
  <tr>
      <td><p>No Data Available</p></td>
  </tr>
 </tbody>
 </table>
<%}else{ %>


	<div class="card-header">Customer Orders</div>
	<div class="card-body">
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Orders ID</th>
      <th scope="col">Orders Date</th>
      <th scope="col">Orders Status</th>
      <th scope="col">Material</th>
      <th scope="col">Colour</th>
      <th scope="col">Fashion</th>
      <th scope="col">Price (RM)</th>
      <th scope="col">Payment Status</th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
 
  <tbody>
  
  <% for (int i = 0; i < order.size(); i ++ )  { %>
  <tr>
   <form action="/MyBaju/UpdateCustomerOrderController" method="POST">
      <td><%=order.get(i).getOrderId() %> </td>
      <input type="hidden" name="orderid" value="<%=order.get(i).getOrderId() %>" >
      <input type="hidden" name="customerid" value="<%=order.get(i).getCustomerId() %>" >
      <td><%=order.get(i).getDateCreated() %> </td>
    
        <td> 
       <!-- <select id="orderSta" name="orderSta">  --> 
           <% 
		   if(order.get(i).getOrders_status()== 0) {
		   %>
		   <!--   <option value="<%=order.get(i).getOrders_status() %>">New Orders</option> -->
		    <!--  <option value="1" >Order In Process</option> -->
		   New Order
		   <%
		   }else if(order.get(i).getOrders_status()== 1){
			   %>
		    <!--<option value="<%=order.get(i).getOrders_status() %>">Order In Process</option>--> 
		     <!--<option value="2" >Order Complete</option>--> 
		     Order In Process
		  <%
		   }else if(order.get(i).getOrders_status()== 2){
			   
			   %>
			  Order Complete
			 <!--<option value="<%=order.get(i).getOrders_status() %>">Order Complete</option>--> 
		    		   
		  <%} %>
		   
		  
		    <!--</select>--> 
		    <input type="hidden" name="orderSta" value="<%=order.get(i).getOrders_status() %>" > 
   		</td>
   		
   	  <%MaterialDao matList = new MaterialDao(); %>      
	  <%ArrayList<material> material = matList.getMaterialName(order.get(i).getMaterial_id()); %>
		<% for (int w = 0; w < material.size(); w ++ )  { %>  
		
       <td> <%=material.get(w).getMaterial_name() %>  </td>
      <%} %>
      
       <%colourDao colList = new colourDao(); %>
        <%ArrayList<colour> colName = colList.getColourName(order.get(i).getColour_id()); %>
        <%
        if(colName.size()== 0) {
		%>
		<td>n/a</td>
		<%}else{ %>
		
	    <% for (int j = 0; j < colName.size(); j ++ )  { %>  
			
        <td><%=colName.get(j).getColour_name() %> <%=colName.size() %> </td>
        
        <%} %>
        <%} %>
    
       <%fashionDao fashList = new fashionDao(); %>      
	   <%ArrayList<fashion> fashion = fashList.getFashion(order.get(i).getDesign_id()); %>
	   
	   <% for (int o = 0; o < fashion.size(); o ++ )  { %>  
		  
        <td><%=fashion.get(o).getFashion_name() %> </td>
        <td><%=fashion.get(o).getPrice()  %></td>
        <%} %>
        
       
        <%
        paymentDao paymnt = new paymentDao();
        ArrayList<payment> payList = paymnt.getPayment(order.get(i).getOrderId());
        %>
       
      <%for(int r=0;r<payList.size();r++) {%>
      	  <%if(payList.get(r).getPayment_status()==1) {%>
      	  		<td>Paid </td>
      	  <%} else { %>
      	        <td> </td>
      	       
      	  
      	  <%} %>
      	  
      	  
        <%} %>
     
       
       
       
       <%if(order.get(i).getOrders_status()!= 2) {%> 
        <td>
         		<!-- <a target="_self" href="/MyBaju/UpdateCustomerOrderController?orderID=<%=order.get(i).getOrderId() %>&orderSta="%>">		
  				<button class="btn btn-primary" type="submit" >Save</button>
  				</a> 
  				<input type="submit" class="btn btn-primary" name="action" value="save">-->
        </td>
      
        <%} else { %>
        <td>
        		<!-- <a target="_self" href="/MyBaju/PaymentController?orderID=<%=order.get(i).getOrderId() %>&customer_id=<%=order.get(i).getCustomerId()%>">
    			<button class="btn btn-warning" name="UpdatePayment">Pay</button>
  				</a>  -->
  				<input type="submit" name="action" class="btn btn-warning" value="pay">
        </td>
        <%} %>
        
          </form>
      </tr>  
     
        
       
 	
 </tbody>
 
 <%} %>
</table>
 <%} %>

	 <div class="col-12">
	 		<a target="_self" href="<%=request.getContextPath()%>/index.html">
    		<button class="btn btn-success">Home</button>
  			</a> 
	 	
			 <a target="_self" href="<%= request.getContextPath() %>/customer/listCustomer.jsp ">
    		<button class="btn btn-success">List Customer</button>
  			</a>  
  			
  	 </div>
	
	
	</div>
</div>
</div>
	
</body>
</html>