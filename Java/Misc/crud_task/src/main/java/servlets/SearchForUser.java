package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchForUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchForUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter output = response.getWriter();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_task", "root", "");
            
    		String firstName = request.getParameter("firstName");
    		String lastName = request.getParameter("lastName");
    		String dateOfBirth = request.getParameter("dateOfBirth");
    		String phoneNumber = request.getParameter("phoneNumber");
    		String emailAddress = request.getParameter("emailAddress");
            
            String searchForUserSQL = 
            	"SELECT * FROM Users " +
            	"WHERE "
            	+ "firstName = ? OR lastName = ? OR dateOfBirth = ? OR phoneNumber = ? OR emailAddress = ?";
            
            preparedStatement = connection.prepareStatement(searchForUserSQL);
            
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, dateOfBirth);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, emailAddress);
            
            ResultSet queryResult = preparedStatement.executeQuery();
            boolean resultListEmpty = true;
            
            StringBuilder resultTableHTML = new StringBuilder(
    			"<table border=\"1\">" +
    				"<tr>" +
    					"<th>ID</th>" +
    					"<th>First Name</th>" +
    					"<th>Last Name</th>" +
    					"<th>Date of Birth</th>" +
    					"<th>Phone Number</th>" +
    					"<th>E-mail Address</th>" +
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
       				"</tr>"
       			);
            	resultListEmpty = false;
            }
            
            resultTableHTML.append(
        		"</table>"
            );
            
            if (resultListEmpty) {
            	output.println("<p>No results found!</p>");
            }
            else {
            	output.println("<p>List of results</p>");
            	output.println(resultTableHTML);
            }
            
            // Clean-up environment
            preparedStatement.close();
            connection.close();
		}
        catch (Exception e) { 
        	e.printStackTrace();
        }

		output.println("<br /><a href=\"/crud_task/search.jsp\">Try searching again?</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
