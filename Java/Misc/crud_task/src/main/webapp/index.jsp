<%@ page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
</head>
<body>
	<!-- MAIN MENU -->
	<p>[
		<a href="index.jsp">Home</a> |
		<a href="add_user.jsp">Add User</a> |
		<a href="search.jsp">Search</a>
	]</p>
	
	<p>List of all users in database "crud_task"</p>
	<p>---</p>
	
	<%  
        Connection connection = null;
		PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_task", "root", "");

            DatabaseMetaData dbm = connection.getMetaData();
         	ResultSet tables = dbm.getTables("crud_task", null, "users", null);
         	 
	        if (tables.next()) {
	        	// Table 'users' exists, select all info from it and print it
	        	String querySQL = "SELECT * FROM Users;";
	        	
	        	preparedStatement = connection.prepareStatement(querySQL);
	        	
	        	ResultSet queryResult = preparedStatement.executeQuery();
	        	
	        	StringBuilder resultTableHTML = new StringBuilder(
        			"<table border=\"1\">" +
        				"<tr>" +
        					"<th>ID</th>" +
        					"<th>First Name</th>" +
        					"<th>Last Name</th>" +
        					"<th>Date of Birth</th>" +
        					"<th>Phone Number</th>" +
        					"<th>E-mail Address</th>" +
        					"<td>Actions</td>" +
        				"</tr>"
        		);
	        	
	        	while (queryResult.next()) {
	        		resultTableHTML.append(
        				"<tr>" +
        					"<td>" + queryResult.getString("id") + "</td>" +
           					"<td>" + queryResult.getString("firstName") + "</td>" +
           					"<td>" + queryResult.getString("lastName") + "</td>" +
           					"<td>" + queryResult.getString("dateOfBirth") + "</td>" +
           					"<td>" + queryResult.getString("phoneNumber") + "</td>" +
           					"<td>" + queryResult.getString("emailAddress") + "</td>" +
           					"<td>" +
           						"<a href=\"./edit_user.jsp?id=" + queryResult.getString("id") + "\">Edit</a> / " +
           						"<a href=\"./DeleteUserFromDatabase?id=" + queryResult.getString("id") + "\">Delete</a>" +
           					"</td>" +
           				"</tr>"
	        		);
	        	}
	        	resultTableHTML.append(
	        		"</table>");
	        	
	        	out.println( resultTableHTML + "<br />" );
	        	
	        	out.println(
	        		"<a href=\"./SortData?order=lastName\">Order by Last Name</a> / " +
       				"<a href=\"./SortData?order=dateOfBirth\">Order by Date of Birth</a>"
	        	);
	        	
	        	queryResult.close();
	        }
	        else {
	        	// Table 'users' does not exist, create it
	        	String createTableSQL = 
	             	"CREATE TABLE Users (" +
	            		"id INT NOT NULL AUTO_INCREMENT, " +
	 	            	"firstName VARCHAR(100) NOT NULL, " +
	 	            	"lastName VARCHAR(100) NOT NULL, " +
	 	            	"dateOfBirth VARCHAR(50) NOT NULL, " +
	 	            	"phoneNumber VARCHAR(15) NOT NULL, " +
	 	            	"emailAddress VARCHAR(50) NOT NULL, " +
	 	            	"PRIMARY KEY (id)" +
	             	");";
	             	
	         	preparedStatement = connection.prepareStatement(createTableSQL);
	         	
	         	preparedStatement.execute();
	         	
	         	out.println("Table was just created! Refresh page to see changes.");
	        }
	        
	        // Clean up environment
	        tables.close();
	        preparedStatement.close();
	        connection.close(); 
        } 
        catch (SQLException se) { // Handle JDBC exceptions
            se.printStackTrace();
         }
        catch (Exception e) { // Handle Class.forName exceptions
            e.printStackTrace();
        }
        finally { // Close resources
            if (preparedStatement != null) { preparedStatement.close(); }
        	if (connection != null) { connection.close(); }
        }
    %>
</body>
</html>
