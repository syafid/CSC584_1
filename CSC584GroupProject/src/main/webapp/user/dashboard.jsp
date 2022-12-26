<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.time.LocalDate"%>
<%@page import="login.DaoLogin" %>
<%@page import="login.Login" %>
<%@page import="customer.*" %>
<%@page import="appointment.*" %>
<%@page import="car.*" %>
<%@page import="user.*" %>
<%@page import="service.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Proton 3s Service Center| By Group 5</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
  <link rel="stylesheet" href="style2.css" />
  <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
  <script type="text/javascript">
  function functionToExecute(){
	  var test = document.getElementById("assign2").value;
	  console.log(test);
	  //alert("Appointment ID " +t.value+ " been deleted from the record.");
  }
    </script>
</head>
<body>

<%DaoLogin loginDetail = new DaoLogin(); %>
<%String logins = (String) request.getAttribute("email"); %>
<%ArrayList<Login> datalogin = loginDetail.getResultSet(logins); %>
  <% for (int z = 0; z < datalogin.size(); z ++ )  { %>
  <div class="container">
    <nav>
      <ul>
        <li><a href="#" class="logo">
          <img src="./image/logoProton.jfif">
          <span class="nav-item"><%=datalogin.get(0).getUserName() %><br></span>
          <span class="nav-item"></span>
        </a></li>
        <li><a href="#">
          <i class="fas fa-menorah"></i>
          <span class="nav-item">Dashboard</span>
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

        <li><a href="LogoutServlet" >
          <i class="fas fa-sign-out-alt"></i>
          <span class="nav-item">Log out</span>
        </a></li>
        
        
      </ul>
    </nav>


    <section class="main">
 <div class="main-top">
<h1><%=datalogin.get(0).getUserAccessLevel()%> Dashboard</h1>

</div>

      <section class="attendance">
        <div class="attendance-list">
<%if (request.getAttribute("message") == "success") { %>
<div class="alert alert-success" role="alert"><h3>
 Appointment updated. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "error") { %>
<div class="alert alert-danger" role="alert">
 Error When Updated the Appointment. Please Try Again Later
</div><br>
<%}%>

        <%if(datalogin.get(0).getUserAccessLevel().equals("supervisor") ) { %>    
          <h1>Appointment List</h1>
          
          <table class="table">
            <thead>
              <tr>

                <th align="center">ID</th>
                <th align="center">Customer Name</th>
               
                <th align="center">Status</th>
                <th align="center">Date/Time</th>
                <th align="center">Service Type</th>
                <th align="center">Car Detail</th>
                
                <th align="center">Assign To</th>
                <th align="center">Action</th>
                <th align="center"></th>
                
              </tr>
            </thead>
                    
      		
            <tbody>
                <%DaoAppointment appointment = new DaoAppointment(); %>
	           
				<%ArrayList<Appointment> ApptAll = appointment.getAppointment(); %>
				<% for (int a = 0; a < ApptAll.size(); a ++ )  { %>
			 <form action="AppointmentApproval" method="post">	     
              <tr>
				<%int appid = ApptAll.get(a).getAppID(); %>
                <td><%=ApptAll.get(a).getAppID() %></td>
                <input type="hidden" name="AppID" value="<%=ApptAll.get(a).getAppID() %>">
               <!--  <input type="hidden" name="email" value="<%=logins %>">  -->
                
                <%DaoCust customer = new DaoCust(); %>
                <%ArrayList<Customer> CustomerList = customer.getCustomer(ApptAll.get(a).getCusID()); %>
	                 <% for (int c = 0; c < CustomerList.size(); c ++ )  { %>
               			 <td style="width:15%"><%=CustomerList.get(c).getCusName() %></td> 
               		
               		<%} %>
               		
               			<td style="width:5%"><%=ApptAll.get(a).getAppStatus() %></td>
               	
                
                <td style="width:15%"><%=ApptAll.get(a).getAppDate() %></td>
                
                <%DaoService serviceList = new DaoService(); %>
                <%int serve = ApptAll.get(a).getServiceID(); %>
                <%ArrayList<Service> sList = serviceList.ServiceDetail(ApptAll.get(a).getServiceID()); %>
                	<% for (int d = 0; d < sList.size(); d ++ )  { %>
               			 <td style="width:15%"><%=sList.get(d).getServiceName() %></td>
               		<%} %>
               		
               	<%DaoCar car = new DaoCar(); %>
                <%ArrayList<Car> CarList = car.getCarType(ApptAll.get(a).getCarID()); %>
	                <% for (int b = 0; b < CarList.size(); b ++ )  { %>	
                		<td style="width:25%"><%=CarList.get(b).getCarModel() %> / <%=CarList.get(b).getCarVariant() %> / <%=CarList.get(b).getCarTransmission() %> </td> <!-- //call car detail-->
                	<%} %>
                	
                <%DaoCust customer2 = new DaoCust(); %>
                <%ArrayList<Customer> CustomerList2 = customer2.getCustomer(ApptAll.get(a).getCusID()); %>
	                 <% for (int w = 0; w < CustomerList2.size(); w ++ )  { %>
               			
               		<%} %>
                	
                <%if(ApptAll.get(a).getEmpID() == 0){ %>
                <td>
                	
                
	                <select name="AssignTo" required> <option disabled selected value> -- select to assign -- </option>
	                <%DaoUser UserTech = new DaoUser(); %>
	                <%ArrayList<User> userArr = UserTech.getUserSet(); %>
	                <%!String technician = null; %>
	                <%for (int e=0; e < userArr.size(); e++) { %>
	               
	                <option  value="<%=userArr.get(e).getUserID() %>"  required><%=userArr.get(e).getUserName() %> </option>
	                
	                <%} %>
	                </select>
	            
                </td>
                 <%} else { %>   
                	 <td>	<%DaoUser UserTech1 = new DaoUser(); %>
                	 		<%ArrayList<User> userArr1 = UserTech1.getUser(ApptAll.get(a).getEmpID()); %>
                	 		<%for (int e=0; e<userArr1.size(); e++) { 
                	 			 technician = userArr1.get(e).getUserName();
                	 			
                	 		}
                	 		%>
                	 		
                	 		<select name="AssignTo"> <option disabled selected value> <%= technician %> </option>
			                <%DaoUser UserTech = new DaoUser(); %>
			                <%ArrayList<User> userArr = UserTech.getUserSet(); %>
			                
			                <%for (int e=0; e<userArr.size(); e++) { %>
			               
			                <option value="<%=userArr.get(e).getUserID() %>"><%=userArr.get(e).getUserName() %> </option>
			                <%} %>
	                </select>
                	 
                	 </td>
                 <%} %>
                
                <td style="width:25%" align="center"><input type="radio" name="status" value="1" required>Accept <input type="radio" name="status" value="9" required>Reject</td>
                <td align="center"><button type="submit">Update</button></td>
                
              </tr>
              </form>
             <%} %>
        
            </tbody>
              
          </table>
           <%} else if( datalogin.get(0).getUserAccessLevel().equals("technician") )  { %>
           
           <h1>Service List</h1>
          	<table class="table">
            <thead>
              <tr>

                <th>ID</th>                              
                <th>Date/Time</th>
                <th>Service Type</th>
                <th>Car Detail</th>
                <th>Customer Name</th>
                <th>Car Plate No</th>
                <th>Car Mileage</th>
                <th>Action</th>
              </tr>
            </thead>
                    
      		
            <tbody>
             <%DaoAppointment appointment = new DaoAppointment(); %>
	           
				<%ArrayList<Appointment> ApptAll = appointment.AppointListByTech(datalogin.get(0).getUserID()); %>
				<% for (int a = 0; a < ApptAll.size(); a ++ )  { %>
            <tr>
            <td><%=ApptAll.get(a).getAppID() %></td>
            <td style="width:20%"><%=ApptAll.get(a).getAppDate() %></td>
            
             	<%DaoService serviceList = new DaoService(); %>
                <%int serve = ApptAll.get(a).getServiceID(); %>
                <%ArrayList<Service> sList = serviceList.ServiceDetail(ApptAll.get(a).getServiceID()); %>
                	<% for (int d = 0; d < sList.size(); d ++ )  { %>
               			 <td style="width:15%"><%=sList.get(d).getServiceName() %></td>
               		<%} %>
            
            	<%DaoCar car = new DaoCar(); %>
                <%ArrayList<Car> CarList = car.getCarType(ApptAll.get(a).getCarID()); %>
	            <% for (int b = 0; b < CarList.size(); b ++ )  { %>	
                		<td style="width:25%"><%=CarList.get(b).getCarModel() %> / <%=CarList.get(b).getCarVariant() %> / <%=CarList.get(b).getCarTransmission() %> </td> <!-- //call car detail-->
                	<%} %>
                	
                 <%DaoCust customer = new DaoCust(); %>
                 <%ArrayList<Customer> CustomerList = customer.getCustomer(ApptAll.get(a).getCusID()); %>
	                 <% for (int c = 0; c < CustomerList.size(); c ++ )  { %>
               			 <td style="width:25%"><%=CustomerList.get(c).getCusName() %></td> 
               			<td style="width:15%"><%=CustomerList.get(c).getCusCarPlate() %></td>
               			<td style="width:25%"><%=CustomerList.get(c).getCusCurrMileage() %> KM</td>
               		<%} %>
               <td style="width:20%"><a href=""><button type="submit">Attend</button></a> </td>
            </tr>
            <%} %>
            </tbody>
            </table>
           <%} %>
        </div>
      </section>
    </section>
  </div>


<%} %>


</body>
</html>
