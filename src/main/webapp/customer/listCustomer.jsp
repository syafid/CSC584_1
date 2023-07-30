<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="customerServlet.*" %>
    <%@page import="connection.*" %>
  
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
</script>
<title>List Available Customers</title>
</head>
<body>
<%if (request.getAttribute("message") == "success_add") { %>
<div class="alert alert-success" role="alert"><h3>
 New Customer Added. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "error_add") { %>
<div class="alert alert-danger" role="alert"><h3>
 Error Adding Customer Into Database. Please Try Again Later
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "update_success") { %>
<div class="alert alert-success" role="alert"><h3>
 Update Customer Information Success. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "update_error") { %>
<div class="alert alert-danger" role="alert"><h3>
 Error Update Customer Information. Please Try Again Later
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
 Delete Customer Record Successful. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "delete_error") { %>
<div class="alert alert-danger" role="alert">
 Error When Deleting Customer Record. Please Try Again Later
</div><br>
<%}%>
<div class="container">
<div class="card">
	<div class="card-header">List Of Customer</div>
	<div class="card-body">
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Customer ID</th>
      <th scope="col">Name</th>
      <th scope="col">Phone No</th>
      <th scope="col">Address</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
   
  	 <%customerDao cDao = new customerDao(); %>
	  <%ArrayList<Customer> customer = cDao.getCustomerList();%>
	  <% for (int i = 0; i < customer.size(); i ++ )  { %>
	    <tr>
	      <td><%=customer.get(i).getCustomerId() %></td>
	      <td><%=customer.get(i).getName() %></td>
	      <td><%=customer.get(i).getPhoneNumber() %></td>
	      <td><%=customer.get(i).getAddress() %></td>
	      <td> 
	            <a target="_self" href="/MyBaju/order/addOrder.jsp?id1=<%=customer.get(i).getCustomerId() %>">
    			<button class="btn btn-success" name="newOrder" type="submit">New Order</button>
  				</a>
  				
  				<a target="_self" href="/MyBaju/customer/viewCustomerOrder.jsp?id1=<%=customer.get(i).getCustomerId() %>">
    			<button class="btn btn-warning" name="viewCustomerOrder" type="submit">View Customer Orders</button>
  				</a>
  				
  				 
	  				<a target="_self" href="/MyBaju/customer/updateCustomer.jsp?id1=<%=customer.get(i).getCustomerId() %>&name1=<%=customer.get(i).getName() %>&phone1=<%=customer.get(i).getPhoneNumber() %>&address1=<%=customer.get(i).getAddress() %>">
	    			<button class="btn btn-info" name="updateCustomer" type="submit">Update</button>
	  				</a>
  				 
  				 
  				<a target="_self" href="/MyBaju/DeleteCustomerController?id1=<%=customer.get(i).getCustomerId() %>">
    			<button class="btn btn-danger" name="deleteCustomer">Delete</button>
  				</a> 
  				
  		 </td>
	      
	    </tr>
	    <%} %>
     

  
   
  </tbody>
</table>
	 <div class="col-12">
	 		<a target="_self" href="<%= request.getContextPath() %>/index.html">
    		<button class="btn btn-success">Home</button>
  			</a> 
	 	
			<a target="_self" href="<%= request.getContextPath() %>/customer/addCustomer.jsp">
    		<button class="btn btn-success">Add New Customer</button>
  			</a>
  			
  	 </div>
	
	
	</div>
</div>
</div>
	
</body>
</html>