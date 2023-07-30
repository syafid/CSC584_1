<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="fashionServlet.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>

function question1(){
//	window.onload = function() {
//	$('#job_id').change(function () {
//		if($(this).is(":checked")) {
//	        $('#fashion').attr('required');
//	        
//	    } else {
//	        $('#fashion').removeAttr('required');
//	    }
	console.log("loaded");
//});
	//if(document.getElementById('radio2').checked == true) {
	//	alert("radio 2 is selected");
	//	$('#fashion').attr('required');
	//}
	
	const var1 = document.getElementById('job_id');
	const var2 = document.getElementById('job_spez');
	const var3 = document.getElementById('subbutt');
	const var4 = document.getElementById('job_spec').value;
	const var5 = document.getElementById('job_spec');
	
	
	
	if(var1.value === "Admin") {   
		   //document.querySelector( 'input[name="fashName"]:required');
			//document.querySelector('#fashName select'); 
			var2.style.display  = 'none';
			var3.style.display = 'inline';
			var4.value = "0";
			var5.setAttribute('display','none');
	}
	      // var selectedValue = document.getElementById('fashName').value; 
	      // if (selectedValue == ""){
	      // 		alert("Selected Radio Button is: " + selectedValue);  
	      // 		document.getElementById('subbutt').disabled = true;
	       		
	      // }
	       else if(var1.value === "Tailor")  {
	    	   	//var3.disabled = 'true';
	    	   	var2.style.display = 'flex';
	    	   if(var4.value != null){
	    	  		var2.style.display  = 'inline';
					//var3.style.display = 'inline';
					var3.disabled = 'false';
	    	   }
	}  
	
	
	//window.onload = function() {
	//	'use strict';

		// Add an event handler to the master checkbox:
		//document.getElementById('toggle').onchange = toggleCheckboxes;

		//document.getElementByName('subbutt').disabled = true;

		//document.getElementById('terms').onchange = disabled;

	//	};
}


</script>

<title>Add New Staff</title>
</head>
<body>
<div class="container">
<div class="card">
	<div class="card-header">Add New Staff</div>
	<div class="card-body">
	 <form action="/MyBaju/AddTailorController" method="POST">
	   	 
	 	<div class="mb-3 row">
		    <label for="tailName" class="col-sm-2 col-form-label">Staff Name</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" name="tailName" id="TailorName" required>
		    </div>
  		</div>
  		
  		<div class="mb-3 row">
		    <label for="tailPhone" class="col-sm-2 col-form-label">Staff Phone No</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" name="tailPhone" required>
		    </div>
  		</div>
  		
  		<%fashionDao fashDao = new fashionDao(); %>
		<%ArrayList<fashion> fashList = fashDao.getFashionList(); %>
  		<div class="mb-3 row">
		    <label for="job_id" class="col-sm-2 col-form-label">Job ID</label>
		    <div class="col-sm-5">
		   		
		     	<select name="job_id" id="job_id" onchange="question1()">
		     		 <option value="">--Please select Job ID--</option>
		     		 <option value="Admin">Admin</option>
		     		  <option value="Tailor">Tailor</option>
		      			
		      			
		      			
		       </select>
		    </div>
		  
  		</div>
  		
  		<div id="job_spez" class="mb-5 row">
  		<label for="job_id" class="col-sm-2 col-form-label">Tailor Specialization</label>
		    <div class="col-sm-5">
		    
		    <select name="job_spec" id="job_spec">
		     		 <option value="">--Please select Tailor Specialization--</option>
		     		 <% for (int a = 0; a < fashList.size(); a ++ )  { %>
		       					 <option value=<%=fashList.get(a).getFashion_id() %> > <%=fashList.get(a).getFashion_name() %> </option>
		       		    
		           		  <%} %>
		      			
		      			
		      			
		       </select>
		    
		    </div>
  		
  		
  		</div>
  		
  	
  	
  	
  	 <div class="col-12">
	 	<button class="btn btn-primary" id="subbutt" type="submit" value="submit">Save</button>
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