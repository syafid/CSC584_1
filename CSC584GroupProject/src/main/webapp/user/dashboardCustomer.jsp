<%@page import="java.util.ArrayList" %>
<%@page import="customer.*" %>
<%@page import="appointment.*" %>
<%@page import="car.*" %>
<%@page import="user.*" %>
<%@page import="service.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Customer Dashboard | By Code Info</title>
  <link rel="stylesheet" href="style2.css" />
  <!-- Font Awesome Cdn Link -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
 <link rel="stylesheet" href="style2.css" />

</head>
<body>
<%DaoCustomerLogin loginDetail = new DaoCustomerLogin(); %>


<%String logins = (String)session.getAttribute("email");  %> 

<%ArrayList<Customer> datalogin = loginDetail.getResultSet(logins); %>
<% for (int recordCount = 0; recordCount < datalogin.size(); recordCount ++ )  { %>

  <div class="container">
    <nav>
      <ul>
        <li><a href="#" class="logo">
          <img src="./image/logoProton.jfif">
          <span class="nav-item"><br></span>
          <span class="nav-item"></span>
        </a></li>
        <li><a href="AppointmentAdd?cusID=<%=datalogin.get(recordCount).getCusID()%>"> 
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
   
      <div class="main-top"> 
      

         <h1>Hi, Welcome <%=datalogin.get(recordCount).getCusName()%></h1>
        <i class="fas fa-user-cog"></i>
      </div>
<section class="attendance">
        <div class="attendance-list">
        <%if (request.getAttribute("message") == "success") { %>
<div class="alert alert-success" role="alert"><h3>
 New Appointment Added. Thank You.
</h3></div>
<%}%>

<%if (request.getAttribute("message") == "error") { %>
<div class="alert alert-danger" role="alert">
 Error When Add New Appointment. Please Try Again Later
</div><br>
<%}%>
          <h1>Appointment List</h1>
          <table class="table">
            <thead>
            
              <tr>
                <th>No</th>
                <th>Date/Time</th>
                <th>Status</th>
                <th>Car Type</th>
                <th>Approved By</th>
                <th>Service Type</th>
                <th>Action</th>
              </tr>
            </thead>
            <%DaoAppointment appointment = new DaoAppointment(); %>
            <%int cusID = datalogin.get(recordCount).getCusID(); %>
			<%ArrayList<Appointment> ListApp = appointment.AppointList(cusID); %>
			<% for (int a = 0; a < ListApp.size(); a ++ )  { %>
            <tbody>
              <tr>
                <td><%=a+1 %></td>
				<td><%=ListApp.get(a).getAppDate() %></td>
                <td><%=ListApp.get(a).getAppStatus() %></td>
                <%DaoCar car = new DaoCar(); %>
                <%ArrayList<Car> CarList = car.getCarType(ListApp.get(a).getCarID()); %>
	                <% for (int b = 0; b < CarList.size(); b ++ )  { %>
	                	<td><%=CarList.get(b).getCarModel() %></td>
	                <%} %>
	            <%int userid = ListApp.get(a).getEmpID(); %>
                <%DaoUser user = new DaoUser(); %>
                <%ArrayList<User> UserList = user.getUser(userid); %>
	                 <% for (int c = 0; c < UserList.size(); c ++ )  { %>
		                	<td><%=UserList.get(c).getUserName()%></td>
		                <%} %>
                <%DaoService serviceList = new DaoService(); %>
                <%int serve = ListApp.get(a).getServiceID(); %>
                <%ArrayList<Service> sList = serviceList.ServiceDetail(serve); %>
                	<% for (int d = 0; d < sList.size(); d ++ )  { %>
	                	<td><%=sList.get(d).getServiceName()%></td>
	                <%} %>
               
                	
                <td><button>View</button></td>
              </tr>
            
            
            </tbody>
            <%} %>
          </table>
        </div>
      </section>
    </section>
  </div>
<% } %>
</body>
</html>
