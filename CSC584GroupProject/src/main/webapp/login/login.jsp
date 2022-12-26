<%@page import="customer.Customer" %>
<%@page import="login.Login" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%if (request.getAttribute("message") == "alert-danger") { %>
<div class="alert alert-danger" role="alert">
  Incorrect Password or User Doesn't Exists. Please use a valid email and password to login in. Thank You
</div>
<%}%>
<div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h3>STAFF LOGIN</h3>
            <p>Please enter your credentials to login.</p>
          </div>
        </div>
        <form class="login-form" action="LoginServlet" method="post">
<!--          <div class="form-group row" style="align-center">  -->
<!--          <label for="radio" class="col-sm-2 col-form-label">Staff<input type="radio" name="login" value="1"></label> -->
          
<!--          <label for="radio" class="col-sm-2 col-form-label">Customer <input type="radio" name="login" value="2"></label> -->
         
<!--          </div> -->
          <input type="text" name="email" placeholder="email"/>
          <input type="password" name="password" placeholder="password"/>
          <button type="submit" class="btn btn-primary">Log Me In</button>    
          <p class="message">New staff? <a href="UserServlet">Create an account</a></p>
        </form>
      </div>
    </div>
</body>
</html>