<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.Date" %>
     <%@page import="java.util.ArrayList" %>
    <%@page import="materialServlet.*" %>
    <%@page import="colourServlet.*" %>
    <%@page import="fashionServlet.*" %>
    <%@page import="customerServlet.*" %>
    
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
   $(document).ready(function () {
	   $('#DateCollect').datepicker({
		    defaultDate: new Date(),
		    datepicker:true,
		    dateFormat: "yy-mm-dd"
      		//format:'YYYY-MM-DD hh:mm:ss.SSS'
		    //format:'HH:mm:ss' working
		    
		});
	   $( "#fashName" ).val();
	   $( "#price option:selected" ).text();
	   $( "price" ).on( "change", myFunction );
   })
   

function myFunction(selectObject) {
  //var x = selectObject.value;
  //console.log(x);
  var input=document.getElementById('price');
  fashName.onchange=function(){
    input.value=fashName.options[fashName.selectedIndex].text;
  }
  //document.getElementById("price").innerHTML = selectObject.options[selectObject.selectedIndex].text;
  //alert(selectObject.options[selectObject.selectedIndex].text); //working
  //return x;
  //document.getElementById("demo").innerHTML = "You selected: " + x;
}
   
   //function displayVals() {
	 //  var singleValues = $( "#price" ).val();//.val();
	   //var multipleValues = $( "#multiple" ).val() || [];
	   // When using jQuery 3:
	   // var multipleValues = $( "#multiple" ).val();
	 //  $( "price" ).innerHTML = singleValues ;
	 //}

   //$( "price" ).on( "change", displayVals );
   //displayVals();
</script>

<title>Add Order</title>
</head>
<body>
<div class="container">
<div class="card">
	<div class="card-header">Add New Order</div>
	<div class="card-body">
	 <form action="/MyBaju/AddOrdersController" method="POST">
	  <!-- <div class="mb-3 row">
		    <label for="customerId" class="col-sm-2 col-form-label">Customer ID</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" name="id1" value="<%=request.getParameter("id1")%>" disabled>
		      <input type="hidden" name="id1" value="<%=request.getParameter("id1")%>" >
		    </div>
  		</div> -->
  		 <input type="hidden" class="form-control" name="id1" value="<%=request.getParameter("id1")%>">
  		<%int cusID = Integer.parseInt(request.getParameter("id1"));%>
  		<%customerDao custDao = new customerDao(); %>
		<%ArrayList<Customer> CustList = custDao.getCustomer(cusID); %>
		 
  		<div class="mb-3 row">
		    <label for="material" class="col-sm-2 col-form-label">Customer Name</label>
		    <div class="col-sm-2">
		      <% for (int i = 0; i < CustList.size(); i ++ )  { %>
		   		 <p><%=CustList.get(i).getName()%> </p>
		       <%} %>
		       
		    <!--  <select name="custID" id="custID" >
		      <option value="">--Please choose a customer name--</option>
		       <% for (int i = 0; i < CustList.size(); i ++ )  { %>
		       		 <option value=<%=CustList.get(i).getCustomerId() %> ><%=CustList.get(i).getName() %></option>
		       		       
		       <%} %>
		       </select> --> 
		    </div>
  		</div>
	 
	 	<!-- <div class="mb-3 row">
		    <label for="DateCollect" class="col-sm-2 col-form-label">Collect Date</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" name="dateCollect" id="DateCollect" required>
		    </div>
  		</div> -->
  		
  		<div class="mb-3 row">
		    <label for="amount" class="col-sm-2 col-form-label">Amount (RM)</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" name="amount" id="price" oninput="myFunction();" disabled>
		    </div>
  		</div>
  		
  		<%MaterialDao matDao = new MaterialDao(); %>
		<%ArrayList<material> matList = matDao.getMaterialList(); %>
		 
  		<div class="mb-3 row">
		    <label for="material" class="col-sm-2 col-form-label">Material</label>
		    <div class="col-sm-2">
		      <select name="material" id="mateName" >
		      <option value="">--Please choose a material--</option>
		       <% for (int i = 0; i < matList.size(); i ++ )  { %>
		       		 <option value=<%=matList.get(i).getMaterial_id() %> ><%=matList.get(i).getMaterial_name() %></option>
		       		       
		       <%} %>
		       </select>
		    </div>
  		</div>
  		
  		<%fashionDao fashDao = new fashionDao(); %>
		<%ArrayList<fashion> fashList = fashDao.getFashionList(); %>
		
  		<div class="mb-3 row">
		    <label for="fashion" class="col-sm-2 col-form-label">Fashion</label>
		    <div class="col-sm-2">
		      <select name="fashion" id="fashName" onchange="myFunction(this)">
		      <option value="">--Please choose a fashion--</option>
		       <% for (int d = 0; d < fashList.size(); d ++ )  { %>
		       		 <option value=<%=fashList.get(d).getFashion_id() %> > <%=fashList.get(d).getFashion_name() %> / RM <%=fashList.get(d).getPrice() %> </option>
		       		    
		             <%} %>
		       </select>
		       
		       
		    </div>
  		</div>
  		
  	    <%colourDao colDao = new colourDao(); %>
		<%ArrayList<colour> colList = colDao.getColourList(); %>
  		<div class="mb-3 row">
		    <label for="colour" class="col-sm-2 col-form-label">Colour</label>
		    <div class="col-sm-2">
		      <select name="colour" id="colName" >
		      <option value="">--Please choose a colour --</option>
		       <% for (int i = 0; i < colList.size(); i ++ )  { %>
		       		 <option value=<%=colList.get(i).getColour_id() %> ><%=colList.get(i).getColour_name() %></option>
		       		       
		       <%} %>
		       </select>
		    </div>
  		</div>
  	
  	<label for="Measurement" class="col-sm-2 col-form-label">Measurement (CM)</label>
  	
  	 	<div class="mb-3 row">
		    <label for="sleeve" class="col-sm-2 col-form-label">Sleeve</label>
		    <div class="col-sm-2">
		      <input type="number" step=0.1 class="form-control" name="sleeve" required>
		    </div>
  		</div>
  	
  	 	<div class="mb-3 row">
		    <label for="shoulder" class="col-sm-2 col-form-label">Shoulder</label>
		    <div class="col-sm-2">
		      <input type="number" step=0.1 class="form-control" name="shoulder" required>
		    </div>
  		</div>
  		
  		<div class="mb-3 row">
		    <label for="chest" class="col-sm-2 col-form-label">Chest</label>
		    <div class="col-sm-2">
		      <input type="number" step=0.1 class="form-control" name="chest" required>
		    </div>
  		</div>
  		
  		<div class="mb-3 row">
		    <label for="toplength" class="col-sm-2 col-form-label">Top Length</label>
		    <div class="col-sm-2">
		      <input type="number" step=0.1 class="form-control" name="toplength" required>
		    </div>
  		</div>
  		
  		<div class="mb-3 row">
		    <label for="waist" class="col-sm-2 col-form-label">Waist</label>
		    <div class="col-sm-2">
		      <input type="number" step=0.1 class="form-control" name="waist" required>
		    </div>
  		</div>
  		
  		<div class="mb-3 row">
		    <label for="hip" class="col-sm-2 col-form-label">Hip</label>
		    <div class="col-sm-2">
		      <input type="number" step=0.1 class="form-control" name="hip" required>
		    </div>
  		</div>
  		
  		<div class="mb-3 row">
		    <label for="bottomlength" class="col-sm-2 col-form-label">Bottom Length</label>
		    <div class="col-sm-2">
		      <input type="number" step=0.1 class="form-control" name="bottomlength" required>
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