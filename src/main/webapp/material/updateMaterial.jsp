<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="materialServlet.*" %>
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
<title>Update Material</title>
</head>
<body>
<%int matId = Integer.parseInt(request.getParameter("materialId")); %>
<div class="container">
	<div class="card">
		<div class="card-header">Update Material</div>
			<div class="card-body">
	 			<form action="/MyBaju/UpdateMaterialController" method="POST">
	 			<%
	 			 MaterialDao matDao = new MaterialDao();
	 		      ArrayList<material> matName = matDao.getMaterialName(matId);
	 		      for (int e = 0; e < matName.size(); e++) {			
	 			
	 			%>
	 			
	 			    <div class="mb-3 row">
			 			  <label for="name" class="col-sm-2 col-form-label">Material ID</label>
				  			  <div class="col-sm-10">
								     <input type="text" class="form-control" value="<%=matName.get(e).getMaterial_id() %>" disabled>
									 <input type="hidden" name="materialID" value="<%=matName.get(e).getMaterial_id()%>">
				   			 </div>
		  			 </div>
		  			 
		  			 <div class="mb-3 row">
			 			  <label for="name" class="col-sm-2 col-form-label">Material Code</label>
				  			  <div class="col-sm-10">
								     <input type="text" class="form-control" name="materialCode" value="<%=matName.get(e).getMaterial_code() %>">
									 
				   			 </div>
		  			 </div>
		  			 
		  			 <div class="mb-3 row">
			 			  <label for="name" class="col-sm-2 col-form-label">Material Name</label>
				  			  <div class="col-sm-10">
								     <input type="text" class="form-control" name="materialName" value="<%=matName.get(e).getMaterial_name() %>">
									
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