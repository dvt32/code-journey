package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class AddUserToDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddUserToDatabase() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String phoneNumber = request.getParameter("phoneNumber");
		String emailAddress = request.getParameter("emailAddress");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_task", "root", "");
            
            String insertValuesSQL = 
            	"INSERT INTO Users (firstName, lastName, dateOfBirth, phoneNumber, emailAddress) " +
            	"VALUES (?, ?, ?, ?, ?)";
            
            preparedStatement = connection.prepareStatement(insertValuesSQL);
            
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, dateOfBirth);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, emailAddress);
           
            preparedStatement.executeUpdate();
            
            // Clean-up environment
            preparedStatement.close();
            connection.close();
		}
        catch (Exception e) { 
        	e.printStackTrace();
        }

		PrintWriter output = response.getWriter();
		
		output.println("User added successfully!");
		output.println("<a href=\"/crud_task/index.jsp\">Go back home...</a>");
	}

}
