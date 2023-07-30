<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Update Design</title>
</head>
<body>
<%int fashionId = Integer.parseInt(request.getParameter("fashionId")); %>
<div class="container">
	<div class="card">
		<div class="card-header">Update Design</div>
			<div class="card-body">
	 			<form action="/MyBaju/UpdateDesignController" method="POST">
	 			<%
	 			 fashionDao fashDao = new fashionDao();
	 		      ArrayList<fashion> fashName = fashDao.getFashion(fashionId);
	 		      for (int e = 0; e < fashName.size(); e++) {			
	 			
	 			%>
	 			
	 			    <div class="mb-3 row">
			 			  <label for="name" class="col-sm-2 col-form-label">Design ID</label>
				  			  <div class="col-sm-10">
								     <input type="text" class="form-control" value="<%=fashName.get(e).getFashion_id()%>" disabled>
									 <input type="hidden" name="fashionID" value="<%=fashName.get(e).getFashion_id()%>">
				   			 </div>
		  			 </div>
		  			 
		  			  <div class="mb-3 row">
			 			  <label for="name" class="col-sm-2 col-form-label">Design Name</label>
				  			  <div class="col-sm-10">
								     <input type="text" name="fashionName" class="form-control" value="<%=fashName.get(e).getFashion_name()%>" disabled>
									
				   			 </div>
		  			  </div>
		  			  
		  			   <div class="mb-3 row">
			 			  <label for="name" class="col-sm-2 col-form-label">Design Description</label>
				  			  <div class="col-sm-10">
								 <input type="text" name="fashionDesc" class="form-control" value="<%=fashName.get(e).getFashion_desc()%>">
								     
									
				   			 </div>
		  			  </div>
		  			  
		  			  <div class="mb-3 row">
			 			  <label for="name" class="col-sm-2 col-form-label">Design Price (RM)</label>
				  			  <div class="col-sm-10">
								 <input type="number" name="fashionPrice" class="form-control" value="<%=fashName.get(e).getPrice()%>">
								     
									
				   			 </div>
		  			  </div>
		  			 
		  			 
		  			 
		  			 
		  			 
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