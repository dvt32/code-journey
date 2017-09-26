import java.sql.*;

/* 

This program illustrates:
- different connection methods
- how a PreparedStatement works
- how to update table data from a ResultSet

*/

public class Exercise2_ConnectionMethods_PreparedStatements {
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://srv.iits.uni-ruse.bg/db53";
	
	   //  Database credentials
	   static final String USER = "inf53";
	   static final String PASS = "inf53pass";
	   
	   public static void main(String[] args) {
		   try {
			   Driver driver = new com.mysql.jdbc.Driver();
			   DriverManager.registerDriver(driver);
			   
			   // Connection method #1 - URL, USER, PASS
			   Connection dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
			   
			   // Connection method #2 - URL only
			   /*
			   String URL = DB_URL + "?user=" + USER + "&password=" + PASS;
			   Connection dbConnection = DriverManager.getConnection(URL);
			   */
			   
			   // Connection method #3 - URL & Properties
			   /*
			   Properties properties = new Properties();
			   properties.put("user", USER);
			   properties.put("password", PASS);
			   Connection dbConnection = DriverManager.getConnection(DB_URL, properties);
			   */
			   
			   String selectQuerySQL = "SELECT ID FROM Test WHERE id = ?";
			   
			   PreparedStatement preparedStatement = dbConnection.prepareStatement(
					selectQuerySQL, 
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE
				);
			   preparedStatement.setInt(1, 1);

			   ResultSet queryResult = preparedStatement.executeQuery();
			   while( queryResult.next() ){
		         int id  = queryResult.getInt("ID");
		         System.out.println("ID: " + id);
		         
		         // queryResult.updateInt(1, 1337);
		         // queryResult.updateRow();
			   }
			   
			   queryResult.close();
			   preparedStatement.close();
			   dbConnection.close();
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }	   
	   }
}
