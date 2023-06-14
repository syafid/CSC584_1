<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="tailorServlet.*" %>
    <%@page import="fashionServlet.*" %>
    <%@page import="ordersServlet.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>List of Staff</title>
</head>
<body>
<%if (request.getAttribute("message") == "update_success") { %>
<div class="alert alert-success" role="alert"><h3>
 Update Staff Success. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "update_error") { %>
<div class="alert alert-danger" role="alert"><h3>
 Error Update Staff. Please Try Again Later
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "success") { %>
<div class="alert alert-success" role="alert"><h3>
 New Staff Added. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "error") { %>
<div class="alert alert-danger" role="alert">
 Error When Add New Staff. Please Try Again Later
</div><br>
<%}%>

<%if (request.getAttribute("message") == "delete_success") { %>
<div class="alert alert-success" role="alert"><h3>
 Delete Staff Success. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "delete_error") { %>
<div class="alert alert-danger" role="alert"><h3>
 Error on Delete Staff. Please Try Again Later
</h3></div>
<%}%>

<div class="container">
<div class="card">
	<div class="card-header">List Of Staff</div>
	<div class="card-body">
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Staff ID</th>
      <th scope="col">Staff Name</th>
      <th scope="col">Staff Phone No</th>
      <th scope="col">Job ID</th>
      <th scope="col">Tailor Specialization</th>
      <th scope="col">Job Count</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  
  

  <tbody>
  <%int jobCount; %>
  <%tailorDao tailDao = new tailorDao(); %>
  <%ArrayList<tailor> tailorList = tailDao.getTailorList(); %>
  <% for (int i = 0; i < tailorList.size(); i ++ )  { %>
  <tr>
  <td><%=tailorList.get(i).getTailor_id() %></td>
  <td><%=tailorList.get(i).getTailor_name() %></td>
  <td><%=tailorList.get(i).getTailor_phone() %></td>
  <td><%=tailorList.get(i).getJob_id() %></td>
  <td>
   <%String job_spec = tailorList.get(i).getJob_spec();
  int job = Integer.parseInt(job_spec);
  fashionDao fashion = new fashionDao();
  ArrayList<fashion> fashionDetail = fashion.getFashion((job)); 
  for (int e = 0; e < fashionDetail.size(); e ++ )  { 
  %>
  <%=fashionDetail.get(e).getFashion_name() %>
  
  
  <%} %> 
  
  
  </td>
  
  <%ordersDao ordDao = new ordersDao();
  jobCount = ordDao.ordersCount(tailorList.get(i).getTailor_id());
  
  %>
  <td><%=jobCount %></td>
  <td style="width:30%">
      		<a target="_self" href="<%= request.getContextPath() %>/tailor/updateStaff.jsp?tailorId=<%=tailorList.get(i).getTailor_id() %>">
    		<button class="btn btn-success">Update Staff</button>
  			</a> 
  			
  			<a target="_self" href="<%= request.getContextPath() %>/tailor/viewJob.jsp?tailorId=<%=tailorList.get(i).getTailor_id() %>">
    		<button class="btn btn-info">View Job</button>
  			</a> 
  			
  			<a target="_self" href="<%=request.getContextPath()%>/DeleteTailorController?tailorId=<%=tailorList.get(i).getTailor_id() %>">
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