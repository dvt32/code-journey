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

public class SortData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SortData() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String sortType = request.getParameter("order");
		
		PrintWriter output = response.getWriter();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_task", "root", "");
            
            String selectSortedDataSQL = 
            	"SELECT * FROM Users " +
            	"ORDER BY " + sortType + " ASC";
            
            preparedStatement = connection.prepareStatement(selectSortedDataSQL);
            
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
            }
            
            resultTableHTML.append(
        		"</table>"
            );
            
            output.println(resultTableHTML + "<br />");
            
            output.println("<a href=\"./index.jsp\">Go back home...</a>");
            
            // Clean-up environment
            preparedStatement.close();
            connection.close();
		}
        catch (Exception e) { 
        	e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
