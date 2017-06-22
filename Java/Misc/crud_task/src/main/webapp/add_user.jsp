<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
	
	<style type="text/css">
	    .container {
	        width: 500px;
	        clear: both;
	    }
	    .container input {
	        width: 100%;
	        clear: both;
	    }
    </style>
</head>
<body>
	<!-- MAIN MENU -->
	<p>[
		<a href="index.jsp">Home</a> |
		<a href="add_user.jsp">Add User</a> |
		<a href="search.jsp">Search</a>
	]</p>
	
	<p>Add user to database</p>
	<p>---</p>
	
	<div class="container">
		<form action="AddUserToDatabase" method="post">
	       <label>First Name</label> 
	       <input type="text" name="firstName" required> <br />
	       <label>Last Name</label>  
	       <input type="text" name="lastName" required> <br />
	       <label>Date of Birth</label>
	       <input type="text" name="dateOfBirth" required> <br />
	       <label>Phone Number</label>
	       <input type="text" name="phoneNumber" required> <br />
	       <label>E-mail Address</label>
	       <input type="text" name="emailAddress" required> <br /> <br />
	       
	   	   <input type="submit" value="Submit">
	   </form>
    </div>
</body>
</html>
