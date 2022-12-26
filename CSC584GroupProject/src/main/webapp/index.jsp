<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width,initial-scale=1" />

	<!-- Bootstrap CSS -->
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous"/>
	<link rel="stylesheet"
		href="style3.css" />
	<link rel="preconnect" href="https://fonts.gstatic.com" />
	<link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet" />
	<title>CSC584 PROJECT PROPOSAL</title>
</head>
<body>
	<section id="navbar">
	<nav class="navbar navbar-expand-lg navbar-light">
		<div class="container-fluid">
		<a class="navbar-brand" href="#">
		 <img src="./image/logoProton.jfif">
			PROTON 3S SERVICE CENTER SERVICE APPOINTMENT MANAGEMENT SYSTEM
			</a>
		<button
			class="navbar-toggler"
			type="button"
			data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent"
			aria-expanded="false"
			aria-label="Toggle navigation"
		>
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse"
			id="navbarSupportedContent">
			<ul class="navbar-nav m-auto">
			<li class="nav-item">
				<a class="nav-link active"
				aria-current="page"
				href="#">Home</a>
			</li>
			<li class="nav-item">
				<a class="nav-link"
				href="CustomerLoginServlet">Log In</a>
			</li>
			<li class="nav-item">
				<a class="nav-link"
				href="#about">About Us</a>
			</li>
			<li class="nav-item">
				<a class="nav-link"
				href="#product">Products</a>
			</li>
			<li class="nav-item">
				<a class="nav-link"
				href="#newappoint">New Appointment</a>
			</li>
			<li class="nav-item">
				<a class="nav-link"
				href="#social">Contact Us</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link"
				href="LoginServlet">Staff Log In</a>
			</li>
			</ul>
		</div>
		</div>
	</nav>
	</section>

	<!-- banner -->
	<section id="banner">
	<div class="container-fluid" id="banner-container">
		<div class="row" id="banner-row">
		<div class="col-md-6" id="banner-col">
			<h3>
			BOOK YOUR SERVICE APPOINTMENT ONLINE
			RELAX AND LET US DO IT FOR YOU
			</h3>
			
<p>
			THE EASIER WAY TO BOOK YOUR SERVICE APPOINTMENT ONLINE
			</p>

			<div class="d-grid gap-2 d-md-flex justify-content-center">
			<a class="btn btn-primary"
				href="#"
				role="button">Contact Us</a>
			</div>
		</div>
		<div class="col-md-6" id="banner-col2">
			<img
			class="img-responsive rounded mx-auto d-block"
			src="images/gfg.png"
			alt=""
			/>
		</div>
		</div>
	</div>
	</section>

	<!-- log in  -->
	<section id="login">
	<div class="container mt-5">
	<div class="row">
    <div class="col-sm-4">
	
    <div class="col-sm-4">
      <h3>Log In</h3>
      <table class="table1">
	  <tr><td>Username</td><td><input type="text"></input></td></tr>
	  <tr><td>Password</td><td><input type="password"></input></td></tr>
	  <tr><td><button>Submit</button></td></tr>
	  <tr><td colspan="3">After submit, User will redirect to User Dashboard OR Customer will redirect to Customer Dashboard</td></tr>
	  </table>
    </div>
    
	
	</div>
	</div>
	</div>
	</section>
	<hr />

	<!-- about Us -->
	<section id="newappoint">
	<h1 class="text-center">New Appointment</h1>
	<div>
	<div class="container">

 <nav>
     
    </nav>
    
     <section class="main">
     <h1>New Appointment Registration</h1>
        <div class="main-top">
			
			
			 <table class="table">
 			<tbody>
			   
			 
					 <tr>
					 <td>
					 <label for="service" class="col-sm-3 col-form-label">Pick Service Type</label>
 					 </td>
 					 <td>
					 <select name="service" id="service">
						 
						 <option value="1">1,000KM/1 MONTH</option>
						 <option value="2">5,000KM/1 MONTH</option>
						 <option value="3">10,000KM/1 MONTH</option>
						 <option value="4">15,000KM/1 MONTH</option>
						 <option value="5">20,000KM/1 MONTH</option>
					    </select>
   					</td>
   					</tr>

 					
 					<tr>
 					<td>
 						<label for="date" class="col-sm-3 col-form-label">Appointment Date</label>
					</td>
					<td>

					    <input type="date" name="date" >
						
					</td>
					</tr>
					
     				<tr>
     				<td>
     					<label for="carModel" class="col-sm-3 col-form-label">Car Model</label>     				
     				</td>
     				
     				<td>
							<select name="carModel">
								<option value="1">IRIZ</option>
								<option value="2">PERSONA</option>
								<option value="3">SAGA</option>
								<option value="4">X50</option>
								<option value="5">X70</option>
							</select>
     				</td>
     				</tr> 
     				<tr>
     				<td>
     					<label for="carVariant" class="col-sm-3 col-form-label">Car Variant</label>     				
     				</td>
     				
     				<td>
     					<select name="carVariant" >
     						 <option value="1">1.3L Standard CVT</option>
     						 <option value="2">1.6L Executive CVT</option>
     						 <option value="3">1.3L Premium CVT</option>
     						 <option value="4">1.5L Executive CVT</option>
     						 <option value="5">1.5TGDI Standard 2WD</option>
     					</select>
     				</td>
     				</tr>
     				
     				<td>
     					<label for="carTrans" class="col-sm-3 col-form-label">Car Transmission</label>     				
     				</td>
     				
     				<td>
     					<select name="carTrans">
     						<option value="1">Automatic CVT</option>
     						<option value="2">6 speed Manual</option>
     					</select>
     				</td>
     				</tr>
     				
     				<tr>
     				<td>
     					<label for="carPlate" class="col-sm-3 col-form-label">Car Plate No</label>     				
     				</td>
     				
     				<td>
     					<input type="text" class="form-control" name="carPlate" value="">
     				</td>
     				</tr>
     				
     				<tr>
     				<td>
     					<label for="carMileage" class="col-sm-3 col-form-label">Car Mileage</label>     				
     				</td>
     				
     				<td>
     					<input type="text" class="form-control" name="carMileage" value="">KM
     				</td>
         				
     				</tr>
     				
     				<tr>
     				<td colspan="2">
 						<a class="btn btn-primary"	href="#customer" role="button">Submit</a>After customer submit the appointment registration, the system will redirect to customer dashboard and will display the appointment status
 					</td>
 					</tr>   
 				 
				</tbody>	
			</table>
	</div>
	</section>
</div>
	
	
	
	
	</div>
	</section>
	<section id="about">
	<h1 class="text-center">About Us</h1>
	<div class="container-fluid" id="about-container">
		<div class="row" id="banner-row">
		<div class="col-md-6" id="about-col">
			<h3>Why Us</h3>
			<ul>
			<li>
				Probuz is all about Delivering High
				Quality web design and development
				services, Cost effective and
				reliable solutions.
			</li>
			<li>SCHOOL/COLLEGE MANAGEMENT SOFTWARE
				(CAMPUS PRO)</li>
			<li>
				Let us take care of your Business needs.
				Customer Productivity is our Priority.
			</li>
			<li>Our expertise in Business includes</li>
			</ul>
		</div>
		<div class="col-md-6" id="banner-col2">
			<img
			class="img-responsive rounded mx-auto d-block"
			src="images/gfg.png"
			alt=""
			/>
		</div>
		</div>
	</div>
	</section>
	<hr />
	<!-- product -->

	<section id="product">
	<h1 class="text-center">Our Products</h1>
	<div class="container-fluid" id="product-container">
		<div class="row" id="banner-row">
		<div class="col-md-6" id="about-col">
			<img
			class="img-responsive rounded mx-auto d-block"
			src="images/gfg.png"
			alt=""
			/>
		</div>
		<div class="col-md-6" id="product-col2">
			<h3>Product List</h3>

			<ul>
			<li>CLINIC MANAGMENT SYSTEM</li>
			<li>SCHOOL/COLLEGE MANAGEMENT
				SOFTWARE (CAMPUS PRO)</li>
			<li>SERVICE MANAGEMENT SOFTWARE</li>
			<li>E-COMMERCE WEBSITE</li>
			</ul>
		</div>
		</div>
	</div>
	</section>
	<hr />
	<!-- social -->
	<section id="social">
	<h1 class="text-center">Get In Touch</h1>
	<div class="d-grid gap-2 d-md-flex justify-content-center">
		<div class="row align-items-center" id="social-row">
		<div class="col-md-4 social-col">
			<a href=""
			><img
				class="img-responsive rounded mx-auto d-block"
				src="images/gfg.png"
				alt=""
			/></a>
		</div>
		<div class="col-md-4 social-col">
			<a href=""
			><img
				class="img-responsive rounded mx-auto d-block"
				src="images/icons8-instagram-64.png"
				alt=""
			/></a>
		</div>
		<div class="col-md-4 social-col">
			<a href=""
			><img
				class="img-responsive rounded mx-auto d-block"
				src="images/icons8-twitter-64.png"
				alt=""
			/></a>
		</div>
		</div>
	</div>
	</section>
<!--  staff dashboard -->
	<section id="staff">

		<h1 class="text-center">Staff Dashboard</h1>
		<div class="container-fluid" id="product-container">
		
		<div class="attendance-list">
          <h1>Service List</h1>
          <table class="table">
            <thead>
              <tr>
                <th>Appointment ID</th>
                <th>Customer Name</th>
                <th>Appointment Status</th>
                <th>Appointment Date/Time</th>
                <th>Service Type</th>
                <th>Car Detail</th>
                <th>Notes</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>01</td>
                <td>Sam David</td>
                <td>New</td>
                <td>03-24-22 8:00AM</td>
                <td>15,000 KM</td>
                <td>X50/1.5 TGDI STANDARD 2WD/AUTO</td>
                <td>Current mileage 15,000 KM</td>
                <td><button>Accept</button><button>Reject</button></td>
              </tr>
              <tr>
                <td>05</td>
                <td>Micheal Kent</td>
                <td>Approved</td>
                <td>11-30-22 11:00AM</td>
                <td>55,000 KM</td>
                <td>Persona/1.6L PREMIUM CVT/AUTO</td>
                <td>Current mileage 53,000 KM</td>
                <td><button disabled>Accept</button><button>Reject</button></td>
              </tr>
              <tr>
                 <td>07</td>
                <td>Siti Aminah Junid</td>
                <td>Approved</td>
                <td>11-28-22 3:00PM</td>
                <td>30,000 KM</td>
                <td>Iriz/1.6L EXECUTIVE CVT/AUTO</td>
                <td>Current mileage 33,000 KM</td>
                <td><button disabled>Accept</button><button>Reject</button></td>
              </tr>
              <tr>
                 <td>10</td>
                <td>Selvaraj A/L Karrupiah</td>
                <td>New</td>
                <td>12-30-22 1:00PM</td>
                <td>10,000 KM</td>
                <td>Sage/1.3L PREMIUM S/AUTO</td>
                <td>Current mileage 5,000 KM</td>
                <td><button>Accept</button><button>Reject</button></td>
              </tr>
             
            </tbody>
          </table>
        </div>
		</div>
		
	</section>	
	
<section id="customer">

	<h1 class="text-center">Customer Dashboard</h1>
	<div class="container-fluid" id="product-container">
	 <h1>Customer Appointment List</h1>
          <table class="table">
            <thead>
            
              <tr>
                <th>No</th>
                <th>Date/Time</th>
                <th>Status</th>
                <th>Car Model</th>
                <th>Approved By</th>
                <th>Service Type</th>
                <th>Action</th>
              </tr>
            </thead>
           
            <tbody>
              <tr>
                <td>1</td>
                <td>15/12/2022 10:00 AM</td>
                <td>NEW</td>
                <td>Proton X70 / 1.8 TGDI Executive 2WD</td>
                <td>None</td>
                <td>20,000 KM</td>
                <td><button>View</button></td>
              </tr>
            
            
            </tbody>
            
          </table>	
		
	</div>
</section>
	<!-- footer -->
	<section id="footer">
	<section id="banner">
		<div class="container-fluid" id="banner-container">
		<div class="row" id="banner-row">
			<div class="col-md-4" id="footer-col1">
			<h3>My Website</h3>
				
<p>
				At XYZ we believe that customers should
				always get easy-to-use, best in the kind
				and fast services.xyz has achieved
				standards which helps customer to
				achieve satisfaction and realize
				value for their hard earned money.
			</p>

			</div>
			<div class="col-md-4" id="footer-col2">
			<h3>Contact Us</h3>
				
<p>Call Us- 1800-121-6532</p>

				
<p>Email Us- support@xyz.com</p>

			</div>

			<div class="col-md-4" id="footer-col2">
			<h3>Subscribe To Newsletter</h3>
			<form>
				<div class="mb-3">
				<input
					type="email"
					placeholder="Enter Your Email"
					class="form-control"
					id="exampleInputEmail1"
					aria-describedby="emailHelp"
				/>
				<div id="emailHelp"
					class="form-text">
					We'll never share your email with anyone else.
				</div>
				</div>
				<button type="submit"
						class="btn btn-primary">
						Submit
				</button>
			</form>
			</div>
			
	
		</div>
		</div>
	</section>
	</section>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>
