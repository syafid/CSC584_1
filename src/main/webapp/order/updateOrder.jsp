<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="ordersServlet.*" %>
<%@page import="customerServlet.*" %>
<%@page import="tailorServlet.*" %>
<%@page import="colourServlet.*" %>
<%@page import="fashionServlet.*" %>
<%@page import="materialServlet.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.sql.Date" %>
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
	   $('#calendar').datepicker({
		    defaultDate: new Date(),
		   // datetimepicker:true,
      		//format:'YYYY-MM-DD hh:mm:ss.SSS'
		    //format:'HH:mm:ss' working
		    dateFormat: "yy-mm-dd"
		});
   })
    
</script>
<title>Update Customer Order</title>
</head>
<body>
<%String orderId = request.getParameter("orderId"); %>
<%int ordStatus; %>


<div class="container">
	<div class="card">
		<div class="card-header">Update Customer Order</div>
			<div class="card-body">
	 			<form action="/MyBaju/UpdateOrderController" method="POST">
				   
				  
			  		
			  		<%ordersDao orderDao = new ordersDao(); %>
					<%ArrayList<Orders> orderList = orderDao.getOrder(Integer.parseInt(orderId)); %>
	  					<% for (int i = 0; i < orderList.size(); i ++ )  { %>
	  				
	  					 <div class="mb-3 row">
				 			  <label for="name" class="col-sm-2 col-form-label">Customer ID</label>
					  			  <div class="col-sm-10">
									     <input type="text" class="form-control" value="<%=orderList.get(i).getCustomerId()%>" disabled>
										 <input type="hidden" name="orderID" value="<%=orderList.get(i).getOrderId()%>"> 
					   			 </div>
			  			 </div>
			  			 
			  			 <%customerDao custDao = new customerDao(); %>
			  			 <%ArrayList<Customer> clist = custDao.getCustomer(orderList.get(i).getCustomerId()); %>
			  				<% for (int x = 0; x < clist.size(); x ++ )  { %>
			  				  <div class="mb-3 row">
				 			  <label for="name" class="col-sm-2 col-form-label">Customer Name</label>
					  			  <div class="col-sm-10">
									     <input type="text" class="form-control" value="<%=clist.get(x).getName()%>" disabled>
										 <input type="hidden" name="cname" value="<%=clist.get(x).getName()%>">
					   			 </div>
			  				  </div>
			  				
			  				
			  				<%} %>
			  				
			  		    <div class="mb-3 row">
				 			  <label for="name" class="col-sm-2 col-form-label">Orders Date</label>
					  			  <div class="col-sm-10">
									      <input type="text" class="form-control" value="<%=orderList.get(i).getDateCreated()%>" disabled>
									
					   			 </div>
			  			 </div>
			  			 
			  			 <div class="mb-3 row">
				 			  <label for="name" class="col-sm-2 col-form-label">Orders ID</label>
					  			  <div class="col-sm-10">
									     
										 <input type="text" class="form-control" value="<%=orderList.get(i).getOrderId()%>" disabled>
					   			 </div>
			  			 </div>
					  	
					  	<%MaterialDao matDao = new MaterialDao();
				 		 ArrayList<material> matName = matDao.getMaterialName(orderList.get(i).getMaterial_id());
				 		 ArrayList<material> matList = matDao.getMaterialList();  %>
					  	<div class="mb-3 row">
				 			  <label for="name" class="col-sm-2 col-form-label">Material</label>
					  			  <div class="col-sm-10">
					  			   <% for (int c = 0; c < matName.size(); c ++ )  { %>
					  			   <select name="matID">
					  			   	<option value="<%=matName.get(c).getMaterial_id()%>" ><%=matName.get(c).getMaterial_name()%></option>
					  			   		<% for (int c1 = 0; c1 < matList.size(); c1 ++ )  { %>
											<option value="<%=matList.get(c1).getMaterial_id()%>" ><%=matList.get(c1).getMaterial_name()%></option>     
									    <%} %> 
								  </select>
									 <%} %>
					   			 </div>
			  			 </div>
					
					<%fashionDao fashDetail = new fashionDao();
				 	  ArrayList<fashion> fashName = fashDetail.getFashion(orderList.get(i).getDesign_id()); 
				 	  ArrayList<fashion> fashList = fashDetail.getFashionList();
				 	  %>				  
				 					  
					<div class="mb-3 row">
				 			  <label for="name" class="col-sm-2 col-form-label">Fashion</label>
					  			  <div class="col-sm-10">
								  <% for (int b = 0; b < fashName.size(); b ++ )  { %>
								  <select name="designID">
								  		<option value="<%=fashName.get(b).getFashion_id()%>"><%=fashName.get(b).getFashion_name()%></option>
								  			<% for (int b1 = 0; b1 < fashList.size(); b1 ++ )  { %>
								  			   	<option value="<%=fashList.get(b1).getFashion_id()%>"><%=fashList.get(b1).getFashion_name()%></option>
					     			   		<%} %>
								  </select>
								  <%} %>	
					   			 </div>
			  			 </div>
					
					
					<%colourDao colDao = new colourDao(); %>
					<%ArrayList<colour> colName = colDao.getColourName(orderList.get(i).getColour_id()); 
					ArrayList<colour> colList = colDao.getColourList();
					%>
			  		<div class="mb-3 row">
					    <label for="colour" class="col-sm-2 col-form-label">Colour</label>
					    <div class="col-sm-2">
					    
					      <% if(colName.isEmpty() ) { %>
					      			<select name="coloID">
					      				<option value="0">n/a</option>
					      			<% for (int a = 0; a < colList.size(); a ++ )  { %>
						      			
						      			<option value="<%=colList.get(a).getColour_id()%>"><%=colList.get(a).getColour_name() %></option>
						      			
						      		<%} %>
						      		
					      			</select>
					          
					      <%} else { %>
					       <% for (int a1 = 0; a1 < colName.size(); a1 ++ )  {  %>
								  <select name="coloID">
								  		<option value="<%=colName.get(a1).getColour_id() %>"><%=colName.get(a1).getColour_name()%></option>
								  			<% for (int a2 = 0; a2 < colList.size(); a2 ++ )  { %>
								  			   	<option value="<%=colList.get(a2).getColour_id()%>"><%=colList.get(a2).getColour_name()%></option>
								  			   	
					     			   		<%} %>
					     			   		
								  </select>
								  <%} %>	
					      
					      <%} %>
					   
					      
					    </div>
			  		</div>

						<div class="mb-3 row">
						   <label for="amount" class="col-sm-2 col-form-label">Sleeve</label>
							    <div class="col-sm-10">
						     <input type="number" class="form-control" step=0.1 name="sleeve1" value="<%=orderList.get(i).getSleeve() %>" disabled>
							   <input type="hidden" name="sleeve1" value="<%=orderList.get(i).getSleeve()%>"> 
							    </div>
					  	</div>			 
					  	
					  	<div class="mb-3 row">
						   <label for="amount" class="col-sm-2 col-form-label">Shoulder</label>
							    <div class="col-sm-10">
						     <input type="number" class="form-control" step=0.1 name="shoulder1" value="<%=orderList.get(i).getShoulder() %>" disabled>
							  <!-- <input type="hidden" name="shoulder1" value="<%=orderList.get(i).getShoulder()%>"> -->
							    </div>
					  	</div>		
					  	
					  	<div class="mb-3 row">
						   <label for="amount" class="col-sm-2 col-form-label">Chest</label>
							    <div class="col-sm-10">
						     <input type="number" class="form-control" step=0.1 name="chest1" value="<%=orderList.get(i).getChest() %>" disabled>
							  <!-- <input type="hidden" name="chest1" value="<%=orderList.get(i).getChest()%>"> -->
							    </div>
					  	</div>		  
					  	
					  	<div class="mb-3 row">
						   <label for="amount" class="col-sm-2 col-form-label">Top Length</label>
							    <div class="col-sm-10">
						     <input type="number" class="form-control" step=0.1 name="toplength1" value="<%=orderList.get(i).getTopLength() %>" disabled>
							 <!--  <input type="hidden" name="toplength1" value="<%=orderList.get(i).getTopLength()%>"> -->
							    </div>
					  	</div>	
					  	
					  	<div class="mb-3 row">
						   <label for="amount" class="col-sm-2 col-form-label">Waist</label>
							    <div class="col-sm-10">
						     <input type="number" class="form-control" step=0.1 name="waist1" value="<%=orderList.get(i).getWaist() %>" disabled>
							 <!--  <input type="hidden" name="waist1" value="<%=orderList.get(i).getWaist()%>"> -->
							    </div>
					  	</div>	
					  	
					  	<div class="mb-3 row">
						   <label for="amount" class="col-sm-2 col-form-label">Hip</label>
							    <div class="col-sm-10">
						     <input type="number" class="form-control" step=0.1 name="hip1" value="<%=orderList.get(i).getHip() %>" disabled>
							 <!--  <input type="hidden" name="hip1" value="<%=orderList.get(i).getHip()%>"> -->
							    </div>
					  	</div>	
					  	
					  	<div class="mb-3 row">
						   <label for="amount" class="col-sm-2 col-form-label">Bottom Length</label>
							    <div class="col-sm-10">
						     <input type="number" class="form-control" step=0.1 name="bottomlength1" value="<%=orderList.get(i).getBottomLength() %>" disabled>
							  <!-- <input type="hidden" name="bottomlength1" value="<%=orderList.get(i).getBottomLength()%>"> -->
							    </div>
					  	</div>	
					  	
					<!--  	<%tailorDao tailDao = new tailorDao(); %>
						<%ArrayList<tailor> tailList = tailDao.getTailorList(); %>
						<%String value1; %>
						<%ArrayList<tailor> tailSingle = tailDao.getTailorByDesign((orderList.get(i).getDesign_id())); %>
						<%if((orderList.get(i).getTailor_id()) != 0) {%>				
		 
				  		<div class="mb-3 row">
						    <label for="tailName" class="col-sm-2 col-form-label">Sewn By</label>
						    <div class="col-sm-2">
						     
						     
						     <% for (int k = 0; k < tailSingle.size(); k ++ )  { %>
						         <input type="text" name="updateTailor" class="form-control" value="<%=tailSingle.get(k).getTailor_name()%>" disabled>
						         <input type="hidden" name="updateTailor" value="<%=tailSingle.get(k).getTailor_id() %>">
						         <input type="hidden" name="ordersStatus" value="2">
						     <%} %>  
						    </div>
				  		</div>	 	
				  		
				  		<%}else{ %>  
				  		<div class="mb-3 row">
						    <label for="tailName" class="col-sm-2 col-form-label">Sewn By</label>
						    <div class="col-sm-2">
						     
						     <select name="updateTailor">
						      <option value="">--Select Tailor Name--</option>
						     <% for (int k = 0; k < tailSingle.size(); k ++ )  { %>
						         <option value="<%=tailSingle.get(k).getTailor_id() %>" required><%=tailSingle.get(k).getTailor_name() %> 
						     <%} %>  
						     </select>
						    </div>
				  		</div>	 	
				  		<input type="hidden" name="ordersStatus" value="1">
				  		
				  		<%} %>		 --> 	  			  		
			  		
			  		<% if(orderList.get(i).getOrders_status() == 0) { %>
			  		<div class="mb-3 row">
						    <label for="orderStatus" class="col-sm-2 col-form-label">Orders Status</label>
						    <div class="col-sm-2">
						      <select name="ordersStatus" id="ordersStatus">
						      <option value="0">New Order</option>
						       
						       		 <option value="0">New Order</option>
						       		 <option value="1">Order In Process</option>
						       		       
						       
						       </select>
						    </div>
				  		</div>	 	  		
			  		
			  		
			  		
			  		
			  		
			  		<%}else if(orderList.get(i).getOrders_status() == 1){ %>
			  		<div class="mb-3 row">
						    <label for="orderStatus" class="col-sm-2 col-form-label">Orders Status</label>
						    <div class="col-sm-2">
						    <%
					
						    %>
						      <select name="ordersStatus" id="ordersStatus">
						      <option value="">Order In Process</option>
						       <option value="2">Order Complete</option>
						       	
						       		       
						       
						       </select>
						    </div>
				  		</div>	 	  		
			  		
			  		
			  		
			  		
			  		<%}else if(orderList.get(i).getOrders_status() == 2) { %>
			  			<div class="mb-3 row">
						    <label for="orderStatus" class="col-sm-2 col-form-label">Orders Status</label>
						    <div class="col-sm-2">
						    <%
					
						    %>
						      <select name="ordersStatus" id="ordersStatus" disabled>
						      <option value="">Order Complete</option>
						       
						       	
						       		       
						       
						       </select>
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