<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.ArrayList" %>
    <%@page import="colourServlet.*" %>
    <%@page import="ordersServlet.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>List Available Colour</title>
</head>
<body>
<%if (request.getAttribute("message") == "update_success") { %>
<div class="alert alert-success" role="alert"><h3>
 Update Colour Success. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "update_error") { %>
<div class="alert alert-danger" role="alert"><h3>
 Error Update Colour. Please Try Again Later
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "success") { %>
<div class="alert alert-success" role="alert"><h3>
 New Colour Added. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "error") { %>
<div class="alert alert-danger" role="alert">
 Error When Add New Colour. Please Try Again Later
</div><br>
<%}%>

<%if (request.getAttribute("message") == "delete_success") { %>
<div class="alert alert-success" role="alert"><h3>
 Delete Colour Success. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "delete_error") { %>
<div class="alert alert-danger" role="alert"><h3>
 Error on Delete Colour. Please Try Again Later
</h3></div>
<%}%>

<div class="container">
<div class="card">
	<div class="card-header">List Available Colour</div>
	<div class="card-body">
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Colour ID</th>
      <th scope="col">Colour Name</th>
      <th scope="col">Colour Description</th>
      <th scope="col">Colour Count By Orders</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  
  

  <tbody>
  <%colourDao colDao = new colourDao(); %>
  <%ArrayList<colour> colourList = colDao.getColourList(); %>
  <% for (int i = 0; i < colourList.size(); i ++ )  { %>
  <tr>
  <td><%=colourList.get(i).getColour_id() %></td>
  <td><%=colourList.get(i).getColour_name() %></td>
  <td><%=colourList.get(i).getColour_desc() %></td>
  
  <%
  ordersDao colourCount = new ordersDao();
  
  %>
  <td><%=colourCount.colourCount(colourList.get(i).getColour_id()) %></td>
  
  <td style="width:30%">
      		<a target="_self" href="<%= request.getContextPath() %>/colour/updateColour.jsp?colourId=<%=colourList.get(i).getColour_id() %>">
    		<button class="btn btn-success">Update</button>
  			</a> 
  			
  			<a target="_self" href="<%= request.getContextPath() %>/colour/viewColour.jsp?colourId=<%=colourList.get(i).getColour_id() %>">
    		<button class="btn btn-info">View</button>
  			</a> 
  			
  			<% if(colourCount.colourCount(colourList.get(i).getColour_id())== 0){ %>
  			<a target="_self" href="<%=request.getContextPath()%>/DeleteColourController?colourId=<%=colourList.get(i).getColour_id() %>">
    		<button class="btn btn-warning">Delete</button>
  			</a>
            <%} %>
      
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