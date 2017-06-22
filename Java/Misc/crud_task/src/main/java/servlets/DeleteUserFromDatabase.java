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

public class DeleteUserFromDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteUserFromDatabase() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_task", "root", "");
            
            int deleteId = Integer.parseInt( request.getParameter("id") );
            
            String deleteUserSQL = 
            	"DELETE FROM Users " +
            	"WHERE id = ?";
            
            preparedStatement = connection.prepareStatement(deleteUserSQL);
            
            preparedStatement.setInt(1, deleteId);
           
            preparedStatement.executeUpdate();
            
            // Clean-up environment
            preparedStatement.close();
            connection.close();
		}
        catch (Exception e) { 
        	e.printStackTrace();
        }

		PrintWriter output = response.getWriter();
		
		output.println("User deleted successfully!");
		output.println("<a href=\"/crud_task/index.jsp\">Go back home...</a>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
