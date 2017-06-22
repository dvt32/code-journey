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
	
	<p>Search for user in database</p>
	<p>---</p>
	
	<div class="container">
		<form action="SearchForUser" method="get">
	       <label>First Name</label> 
	       <input type="text" name="firstName"> <br />
	       <label>Last Name</label>  
	       <input type="text" name="lastName"> <br />
	       <label>Date of Birth</label>
	       <input type="text" name="dateOfBirth"> <br />
	       <label>Phone Number</label>
	       <input type="text" name="phoneNumber"> <br />
	       <label>E-mail Address</label>
	       <input type="text" name="emailAddress"> <br /> <br />
	       
	   	   <input type="submit" value="Search">
	   </form>
    </div>
</body>
</html>
