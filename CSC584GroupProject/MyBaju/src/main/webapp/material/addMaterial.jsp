<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<title>Add Material</title>
</head>
<body>
<div class="container">
<div class="card">
	<div class="card-header">Add New Material</div>
	<div class="card-body">
	 <form action="/MyBaju/AddMaterialController" method="POST">
	   	 
	 	<div class="mb-3 row">
		    <label for="matCode" class="col-sm-2 col-form-label">Material Code</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" name="matCode" id="mateCode" required>
		    </div>
  		</div>
  		
  		<div class="mb-3 row">
		    <label for="amount" class="col-sm-2 col-form-label">Material Name</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" name="matName" required>
		    </div>
  		</div>
  	
  	
  	
  	 <div class="col-12">
	 	<button class="btn btn-primary" type="submit" value="submit">Save</button>
	 	<button class="btn btn-alert" type="reset">Reset</button>
  	 </div>
	 
	 
	 </form>
	 
	
	
	</div>
</div>

<table class="table">

</table>




</div>
</body>
</html>