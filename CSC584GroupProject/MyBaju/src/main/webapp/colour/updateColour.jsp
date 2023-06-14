<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="colourServlet.*" %>
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
<title>Update Colour</title>
</head>
<body>
<%int colourId = Integer.parseInt(request.getParameter("colourId")); %>
<div class="container">
	<div class="card">
		<div class="card-header">Update Colour</div>
			<div class="card-body">
	 			<form action="/MyBaju/UpdateColourController" method="POST">
	 			<%
	 			  colourDao coloDao = new colourDao();
	 		      ArrayList<colour> colName = coloDao.getColourName(colourId);
	 		      for (int e = 0; e < colName.size(); e++) {			
	 			
	 			%>
	 			
	 			    <div class="mb-3 row">
			 			  <label for="name" class="col-sm-2 col-form-label">Colour ID</label>
				  			  <div class="col-sm-10">
								     <input type="text" class="form-control" value="<%=colName.get(e).getColour_id() %>" disabled>
									 <input type="hidden" name="colourID" value="<%=colName.get(e).getColour_id()%>">
				   			 </div>
		  			 </div>
		  			 
		  			 
		  			  <div class="mb-3 row">
			 			  <label for="name" class="col-sm-2 col-form-label">Colour Name</label>
				  			  <div class="col-sm-10">
								     <input type="text" class="form-control" name="colour_name" value="<%=colName.get(e).getColour_name() %>">
								
				   			 </div>
		  			 </div>
		  			 
		  			  <div class="mb-3 row">
			 			  <label for="name" class="col-sm-2 col-form-label">Colour Description</label>
				  			  <div class="col-sm-10">
								     <input type="text" class="form-control" name="colour_desc" value="<%=colName.get(e).getColour_desc() %>">
									
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