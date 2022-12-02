<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
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
			 <form action="AppointmentApproval" method="get">	     
              <tr>

                <td><%=ApptAll.get(a).getAppID() %></td>
                
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
               			 <td style="width:15%"><%=sList.get(0).getServiceName() %></td>
               		<%} %>
               		
               	<%DaoCar car = new DaoCar(); %>
                <%ArrayList<Car> CarList = car.getCarType(ApptAll.get(a).getCarID()); %>
	                <% for (int b = 0; b < CarList.size(); b ++ )  { %>	
                		<td style="width:25%"><%=CarList.get(b).getCarModel() %> / <%=CarList.get(b).getCarVariant() %> / <%=CarList.get(b).getCarTransmission() %> </td> <!-- //call car detail-->
                	<%} %>
                	
                <%if(ApptAll.get(a).getEmpID() == 0){ %>
                <td>
                	
                
	                <select name="technician"> <option disabled selected value> -- select to assign -- </option>
	                <%DaoUser UserTech = new DaoUser(); %>
	                <%ArrayList<User> userArr = UserTech.getUserSet(); %>
	                <%!String technician = null; %>
	                <%for (int e=0; e<userArr.size(); e++) { %>
	               
	                <option value="<%=userArr.get(e).getUserID() %>"><%=userArr.get(e).getUserID() %><%=userArr.get(e).getUserName() %> </option>
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
                	 		
                	 		<select name="technician"> <option disabled selected value> <%= technician %> </option>
			                <%DaoUser UserTech = new DaoUser(); %>
			                <%ArrayList<User> userArr = UserTech.getUserSet(); %>
			                
			                <%for (int e=0; e<userArr.size(); e++) { %>
			               
			                <option value="<%=userArr.get(e).getUserID() %>"><%=userArr.get(e).getUserID() %><%=userArr.get(e).getUserName() %> </option>
			                <%} %>
	                </select>
                	 
                	 </td>
                 <%} %>
                
                <td style="width:25%" align="center"><input type="radio" name="status" value="1">Accept <input type="radio" name="status" value="1">Reject</td>
                <td align="right"><a href="AppointmentApproval?AppID=<%=ApptAll.get(a).getAppID()%>&AssignTo?="><button id="apprv">Update</button></a> </td>
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

                <th>Appointment ID</th>                              
                <th>Appointment Date/Time</th>
                <th>Service Type</th>
                <th>Car Detail</th>
                <th>Assigned By</th>
                <th>Action</th>
              </tr>
            </thead>
                    
      		
            <tbody>
            <tr>
            
            
            </tr>
            </tbody>
            </table>
           <%} %>
        </div>
      </section>
    </section>
  </div>


<%} %>
 <script>
      $(document).ready(function() {
          $("#technician").change(function() {
              let selectedItem = $(this).children("option:selected").val();
              alert("You have selected the name - " + selectedItem);
            });
        });
    </script>

</body>
</html>
