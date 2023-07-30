<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="materialServlet.*" %>
    <%@page import="ordersServlet.*" %>
    <%@page import="connection.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>List Available Material</title>
</head>
<body>
<%if (request.getAttribute("message") == "update_success") { %>
<div class="alert alert-success" role="alert"><h3>
 Update Material Success. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "update_error") { %>
<div class="alert alert-danger" role="alert"><h3>
 Error Update Material. Please Try Again Later
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "success") { %>
<div class="alert alert-success" role="alert"><h3>
 New Material Added. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "error") { %>
<div class="alert alert-danger" role="alert">
 Error When Add New Material. Please Try Again Later
</div><br>
<%}%>

<%if (request.getAttribute("message") == "delete_success") { %>
<div class="alert alert-success" role="alert"><h3>
 Delete Material Success. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "delete_error") { %>
<div class="alert alert-danger" role="alert"><h3>
 Error on Delete Material. Please Try Again Later
</h3></div>
<%}%>

<div class="container">
<div class="card">
	<div class="card-header">List Material</div>
	<div class="card-body">
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Material ID</th>
      <th scope="col">Material Code</th>
      <th scope="col">Material Name</th>
      <th scope="col">Material Count</th>
      <th scope="col">Action</th>
    </tr>
  </thead>


  <tbody>
  <%MaterialDao matDao = new MaterialDao(); %>
  <%ArrayList<material> matList = matDao.getMaterialList(); %>
  <% for (int i = 0; i < matList.size(); i ++ )  { %>
  <tr>
  <td><%=matList.get(i).getMaterial_id() %></td>
  <td><%=matList.get(i).getMaterial_code() %></td>
  <td><%=matList.get(i).getMaterial_name() %></td>
  
  <%ordersDao matCount = new ordersDao(); %>
  <td><%=matCount.materialCount(matList.get(i).getMaterial_id()) %></td>
   <td style="width:30%">
      		<a target="_self" href="<%= request.getContextPath() %>/material/updateMaterial.jsp?materialId=<%=matList.get(i).getMaterial_id() %>">
    		<button class="btn btn-success">Update</button>
  			</a> 
  			
  			<a target="_self" href="<%= request.getContextPath() %>/material/viewMaterial.jsp?materialId=<%=matList.get(i).getMaterial_id() %>">
    		<button class="btn btn-info">View</button>
  			</a> 
  			
  			<% if(matCount.materialCount(matList.get(i).getMaterial_id()) == 0){ %>
  			 <a target="_self" href="<%=request.getContextPath()%>/DeleteMaterialController?materialId=<%=matList.get(i).getMaterial_id() %>">
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