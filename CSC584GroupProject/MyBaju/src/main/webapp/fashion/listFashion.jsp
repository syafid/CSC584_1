<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList" %>
    <%@page import="fashionServlet.*" %>
    <%@page import="ordersServlet.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>List Available Design</title>
</head>
<body>
<%if (request.getAttribute("message") == "update_success") { %>
<div class="alert alert-success" role="alert"><h3>
 Update Design Success. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "update_error") { %>
<div class="alert alert-danger" role="alert"><h3>
 Error Update Design. Please Try Again Later
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "success") { %>
<div class="alert alert-success" role="alert"><h3>
 New Design Added. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "error") { %>
<div class="alert alert-danger" role="alert">
 Error When Add New Design. Please Try Again Later
</div><br>
<%}%>

<%if (request.getAttribute("message") == "delete_success") { %>
<div class="alert alert-success" role="alert"><h3>
 Delete Design Success. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "delete_error") { %>
<div class="alert alert-danger" role="alert"><h3>
 Error on Delete Design. Please Try Again Later
</h3></div>
<%}%>

<div class="container">
<div class="card">
	<div class="card-header">List Design</div>
	<div class="card-body">
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Design ID</th>
      <th scope="col">Design Name</th>
      <th scope="col">Design Description</th>
      <th scope="col">Order Count</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  
  

  <tbody>
  <%fashionDao fashDao = new fashionDao(); %>
  <%ArrayList<fashion> fashList = fashDao.getFashionList(); %>
  <% for (int i = 0; i < fashList.size(); i ++ )  { %>
  <tr>
  <td><%=fashList.get(i).getFashion_id() %></td>
  <td><%=fashList.get(i).getFashion_name() %></td>
  <td><%=fashList.get(i).getFashion_desc() %></td>
  
  <%
  ordersDao designOrd = new ordersDao();
 
  
  %>
  <td><%=designOrd.designCount(fashList.get(i).getFashion_id()) %></td>
  
  
   <td style="width:30%">
      		<a target="_self" href="<%= request.getContextPath() %>/fashion/updateFashion.jsp?fashionId=<%=fashList.get(i).getFashion_id() %>">
    		<button class="btn btn-success">Update</button>
  			</a> 
  			
  			<a target="_self" href="<%= request.getContextPath() %>/fashion/viewFashion.jsp?fashionId=<%=fashList.get(i).getFashion_id() %>">
    		<button class="btn btn-info">View</button>
  			</a> 
  			
  			<a target="_self" href="<%=request.getContextPath()%>/DeleteFashionController?fashionId=<%=fashList.get(i).getFashion_id() %>">
    		<button class="btn btn-warning">Delete</button>
  			</a>
      
      
      </td>
         </tr>
          <%} %>
  </tbody>
</table>
	 <div class="col-12">
	 	<a target="_self" href="<%=request.getContextPath() %>/index.html">
    		<button class="btn btn-success">Home</button>
  			</a> 
	 	<!-- <button class="btn btn-alert" type="cancel">Add New Order</button> -->
  	 </div>
	
	
	</div>
</div>
</div>
  
  
</body>
</html>