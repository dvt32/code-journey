<%@ page import = "java.sql.*" %>

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
	
	<p>Edit user info</p>
	<p>---</p>
	
	<p style="font-weight: bold;">ID = <%= request.getParameter("id") %></p>
	
	<!-- Extract user's info -->
	<%  
		String firstName = null;
		String lastName = null;
		String dateOfBirth = null;
		String phoneNumber = null;
		String emailAddress = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_task", "root", "");
	        
	        String selectUserInfoSQL = 
	        	"SELECT * FROM Users " +
	        	"WHERE id = ?";
	        
	        preparedStatement = connection.prepareStatement(selectUserInfoSQL);
	        preparedStatement.setInt( 1, Integer.parseInt(request.getParameter("id")) );
	        
	        ResultSet queryResult = preparedStatement.executeQuery();
	        queryResult.next(); // move cursor to first and only result row
	        
	        firstName = queryResult.getString("firstName");
	        lastName = queryResult.getString("lastName");
	        dateOfBirth = queryResult.getString("dateOfBirth");
	        phoneNumber = queryResult.getString("phoneNumber");
	        emailAddress = queryResult.getString("emailAddress");
	        
	        // Clean up environment
	        queryResult.close();
	        preparedStatement.close();
	        connection.close();
		}
	    catch (Exception e) { 
	    	e.printStackTrace();
	    }
    %>

	<div class="container">
		<form action="EditUserInfo" method="post">
		   <input type="hidden" name="id" value='<%= request.getParameter("id") %>'>
	       <label>First Name</label> 
	       <input type="text" name="firstName" value='<%= firstName %>' required> <br />
	       <label>Last Name</label>  
	       <input type="text" name="lastName" value='<%= lastName %>' required> <br />
	       <label>Date of Birth</label>
	       <input type="text" name="dateOfBirth" value='<%= dateOfBirth %>' required> <br />
	       <label>Phone Number</label>
	       <input type="text" name="phoneNumber" value='<%= phoneNumber %>' required> <br />
	       <label>E-mail Address</label>
	       <input type="text" name="emailAddress" value='<%= emailAddress %>' required> <br /> <br />
	       
	   	   <input type="submit" value="Save">
	   </form>
    </div>

</body>
</html>
