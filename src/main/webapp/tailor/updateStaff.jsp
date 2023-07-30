<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="tailorServlet.*" %>
    <%@page import="fashionServlet.*" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<title>Update Staff</title>
</head>
<body>
<%int tailorId = Integer.parseInt(request.getParameter("tailorId")); %>
<%int ordStatus; %>
<div class="container">
	<div class="card">
		<div class="card-header">Update Staff</div>
			<div class="card-body">
	 			<form action="/MyBaju/UpdateStaffController" method="POST">
	 			
	 			<% tailorDao tailor = new tailorDao(); 
	 			   ArrayList<tailor> tailorDetail = tailor.getTailor(tailorId);
	 			   for (int i = 0; i < tailorDetail.size(); i ++ )  {
	 			
	 			
	 			%>
	 			 <div class="mb-3 row">
			 			  <label for="name" class="col-sm-2 col-form-label">Staff ID</label>
				  			  <div class="col-sm-10">
								     <input type="text" class="form-control" value="<%=tailorDetail.get(i).getTailor_id()%>" disabled>
									 <input type="hidden" name="tailorID" value="<%=tailorDetail.get(i).getTailor_id()%>">
				   			 </div>
		  			 </div>
		  			 
			  			 <div class="mb-3 row">
				 			  <label for="name" class="col-sm-2 col-form-label">Staff Name</label>
					  			  <div class="col-sm-10">
									     <input type="text" name="staff_name" class="form-control" value="<%=tailorDetail.get(i).getTailor_name()%>">
										 
					   			 </div>
			  			 </div>
			  			 
			  			 <div class="mb-3 row">
				 			  <label for="name" class="col-sm-2 col-form-label">Staff Phone No</label>
					  			  <div class="col-sm-10">
									     <input type="text" name="staff_phone" class="form-control" value="<%=tailorDetail.get(i).getTailor_phone()%>">
										 
					   			 </div>
			  			 </div>
			  			 
			  			  <div class="mb-3 row">
				 			  <label for="name" class="col-sm-2 col-form-label">Job ID</label>
					  			  <div class="col-sm-10">
									     <input type="text" name="staff_jobid" class="form-control" value="<%=tailorDetail.get(i).getJob_id()%>" disabled>
										 
					   			 </div>
			  			 </div>
			  			 
			  			 <%
			  			 fashionDao getFashName = new fashionDao();
			  			 ArrayList<fashion> fashion = getFashName.getFashion(Integer.parseInt(tailorDetail.get(i).getJob_spec()));
				 					 for (int f = 0; f < fashion.size(); f ++ )  {
			  			 %>
			  			  <div class="mb-3 row">
				 			  <label for="name" class="col-sm-2 col-form-label">Tailor Specialization</label>
					  			  <div class="col-sm-10">
									     <input type="text" name="staff_special" class="form-control" value="<%=fashion.get(f).getFashion_name()%>" disabled>
										 
					   			 </div>
			  			 </div>
			  			 <%} %>
                 <%} %>
					 <div class="col-12">
					 	<button class="btn btn-primary" type="submit" >Update</button>
					 	<button class="btn btn-alert" type="cancel" value="cancel" >Cancel</button>
				  	 </div>
  				</form>
  			</div>
  		</div>
  		
</div>
  		

</body>
</html>