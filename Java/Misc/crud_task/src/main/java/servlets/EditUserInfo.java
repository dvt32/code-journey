package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditUserInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		int id = Integer.parseInt(request.getParameter("id"));
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
            	"UPDATE Users " +
            	"SET firstName = ?, lastName = ?, dateOfBirth = ?, phoneNumber = ?, emailAddress = ? " +
            	"WHERE id = ?";
            
            preparedStatement = connection.prepareStatement(insertValuesSQL);
            
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, dateOfBirth);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, emailAddress);
            preparedStatement.setInt(6, id);
            
            preparedStatement.executeUpdate();
            
            // Clean-up environment
            preparedStatement.close();
            connection.close();
		}
        catch (Exception e) { 
        	e.printStackTrace();
        }

		PrintWriter output = response.getWriter();
		
		output.println("User info updated successfully!");
		output.println("<a href=\"/crud_task/index.jsp\">Go back home...</a>");
	}

}
