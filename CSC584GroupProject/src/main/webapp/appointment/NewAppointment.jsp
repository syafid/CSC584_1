<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Date" %>
<%@page import="appointment.*" %>
<%@page import="customer.*" %>
<%@page import="car.*" %>
<%@page import="service.*" %>



<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->
<!-- <meta charset="ISO-8859-1"> -->

  <!-- Font Awesome Cdn Link -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
  <link rel="stylesheet" href="style2.css" />
<!--   <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css"> -->
 
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!--   <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script> -->
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.4/css/bootstrap-datetimepicker.min.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.4/js/bootstrap-datetimepicker.min.js"></script>

   <script>
   $(document).ready(function () {
	   $('#timePicker').datetimepicker({
		    //defaultDate: new Date(),
		    datepicker:false,
      		format:'HH:mm:ss'
		    //format:'HH:mm:ss' working
		    
		});
   })
  </script>

<%DaoCustomerLogin loginDetail = new DaoCustomerLogin(); %>
<%String logins = (String)request.getParameter("cusID"); %>
<%int loginID = Integer.parseInt(logins); %>
<%ArrayList<Customer> datalogin = loginDetail.getSessionSet(logins); %> 
<% for (int recordCount1 = 0; recordCount1 < datalogin.size(); recordCount1 ++ )  { %>
<% Customer customer = (Customer)datalogin.get(recordCount1); %>

<title>New Appointment Registration</title>
</head>
<body>


<%-- <%DaoCustomerLogin loginDetail2 = new DaoCustomerLogin(); %> --%>
<%-- <%String logins2 = (String) request.getParameter("cusID"); %> --%>
<%-- <%ArrayList<Customer> datalogin2 = loginDetail2.getResultSet(logins2); %> --%>
<div class="container">

 <nav>
      <ul>
        <li><a href="#" class="logo">
          <img src="./image/logoProton.jfif">
          <span class="nav-item"><br></span>
          <span class="nav-item"></span>
        </a></li>
        
         <li><a href="CustomerLoginServlet?email=<%=datalogin.get(recordCount1).getCusEmail() %>">
          <i class="fas fa-home"></i>
          <span class="nav-item">Dashboard</span>
        </a></li>
        
        <li><a href="AppointmentAdd?cusID=<%=datalogin.get(recordCount1).getCusID() %>">
          <i class="fas fa-calendar-plus"></i>
          <span class="nav-item">New Appointment</span>
        </a></li>
       
        <li><a href="#">
          <i class="fas fa-comment"></i>
          <span class="nav-item">Message</span>
        </a></li>
        <li><a href="#">
          <i class="fas fa-database"></i>
          <span class="nav-item">Report</span>
        </a></li>
        <li><a href="#">
          <i class="fas fa-chart-bar"></i>
          <span class="nav-item">Attendance</span>
        </a></li>
        <li><a href="#">
          <i class="fas fa-cog"></i>
          <span class="nav-item">Setting</span>
        </a></li>

        <li><a href="LogoutServlet">
          <i class="fas fa-sign-out-alt"></i>
          <span class="nav-item">Log out</span>
        </a></li>
        
<!--         <li> -->
<!--         <form action="LogoutServlet"> -->
<!-- 					<input type="submit" class="fas fa-sign-out-alt"> -->
<!-- 				</form> -->
<!--         </li> -->
      </ul>
    </nav>
    
     <section class="main">
     <h1>New Appointment Registration</h1>
        <div class="main-top">
			
			
			 <table class="table">
 			<tbody>
			    <form action="AppointmentAdd" method="post">
			 
  				<%--      				<%ArrayList detail = (ArrayList) request.getAttribute("customer_detail");%> --%>
     				  
			        
			         <input type="hidden" name="cusID" value="<%= datalogin.get(recordCount1).getCusID() %>">
 			         <input type="hidden" name="cusEmail" value="<%=datalogin.get(recordCount1).getCusEmail()%>">
			        
					 <tr>
					 <td>
					 <label for="service" class="col-sm-2 col-form-label">Pick Service Type</label>
 					 </td>
 					 <td>
					 <select name="service" id="service">

					<%DaoService sList = new DaoService(); %>
					<%ArrayList<Service> listing = sList.list(); %> 
					<% for (int i = 0; i < listing.size(); i ++ )  { %>
				    <% Service service = (Service)listing.get(i); %>
					   
					 
					 <option value="<%= service.getServiceID() %>"><%=service.getServiceName()%></option>
					<%} %>
					    </select>
   					</td>
   					</tr>

 					
 					<tr>
 					<td>
 						<label for="date" class="col-sm-2 col-form-label">Appointment Date</label>
					</td>
					<td>

					    <input type="date" name="date" required>
						
					</td>
					</tr>
					
					<tr>
 					<td>
 						<label for="time" class="col-sm-2 col-form-label">Appointment Time</label>
					</td>
					<td>

					    <input type="text" name="time" id="timePicker" required>
						
					</td>
					</tr>
					
     				<tr>
     				<td>
     					<label for="carType" class="col-sm-2 col-form-label">Car Type</label>     				
     				</td>
     				<%int carType = datalogin.get(recordCount1).getCusCarType();%>
					<%DaoCar car = new DaoCar(); %>
     				<%ArrayList<Car> carlist = car.getCarType(carType); %> 
					<% for (int i = 0; i < carlist.size(); i ++ )  { %>
				    <% Car service = (Car)carlist.get(i); %> 
     				  			
     				<td>
							<input type="text" class="form-control" name="carType" id="carType" value="<%= service.getCarModel() %>" disabled>
     				</td>
     				</tr>
     				
     				<tr>
     				<td>
							<input type="hidden" name="carID"  value="<%=carType%>">
     				</td>
     				</tr>
     				
     				<tr>
     				<td>
     					<label for="carVariant" class="col-sm-2 col-form-label">Car Variant</label>     				
     				</td>
     				
     				<td>
     					<input type="text" class="form-control" name="carVariant" value="<%= service.getCarVariant() %>"  disabled>
     				</td>
     				</tr>
     				
     				<td>
     					<label for="carTrans" class="col-sm-2 col-form-label">Car Transmission</label>     				
     				</td>
     				
     				<td>
     					<input type="text" class="form-control" name="carTrans" value="<%= service.getCarTransmission() %>"  disabled>
     				</td>
     				</tr>
     				<%} %>
     				<tr>
     				<td>
     					<label for="carPlate" class="col-sm-2 col-form-label">Car Plate No</label>     				
     				</td>
     				
     				<td>
     					<input type="text" class="form-control" name="carPlate" value="<%=datalogin.get(recordCount1).getCusCarPlate()%>"  disabled>
     				</td>
     				</tr>
     				
     				<tr>
     				<td>
     					<label for="carMileage" class="col-sm-2 col-form-label">Car Mileage</label>     				
     				</td>
     				
     				<td>
     					<input type="text" class="form-control" name="carMileage" value="<%=datalogin.get(recordCount1).getCusCurrMileage()%> KM" disabled>
     				</td>
         				<%} %> 
     				</tr>
     				
     				<tr>
     				<td colspan="2">
 						<button type="submit" class="btn btn-primary">Save</button> <button type="cancel" class="btn btn-alert">Cancel</button> 
 					</td>
 					</tr>   
 				</form> 
				</tbody>	
			</table>
	</div>
	</section>
</div>

</body>
</html>