package net.dvt32.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {
	
	private static final String DB_JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String DB_USERNAME = "c##dvt32";
	private static final String DB_PASSWORD = "123";
	
	private static Connection connection = null;
	private static final JdbcTemplate instance = new JdbcTemplate();
	
	private JdbcTemplate() { }
	
	public static JdbcTemplate getInstance(){
		return instance;
	}
	
	public Connection getConnection() {
		try {
			if ( connection == null || connection.isClosed() || !connection.isValid(10) ) {
				System.out.println("[JdbcTemplate] Getting new connection to database...");
				DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
				connection = DriverManager.getConnection(DB_JDBC_URL, DB_USERNAME, DB_PASSWORD);
			}
		} 
		catch (SQLException e) {
			System.out.println( e.getMessage() );
		}
		
		return connection;
	}
	
	public ResultSet selectAllFromTable(String type) {
		ResultSet resultSet = null;
		
		try {
			PreparedStatement preparedStatement = null;
			
			if (type.equalsIgnoreCase("Agency")) {
				preparedStatement = getConnection().prepareStatement(
					"SELECT TREAT(VALUE(a) AS agency_t) FROM Agency a"
				);
			}
			else if (type.equalsIgnoreCase("Agent")) {
				preparedStatement = getConnection().prepareStatement(
					"SELECT TREAT(VALUE(a) AS agent_t) FROM Agent a"
				);
			}
			else if (type.equalsIgnoreCase("Buyer")) {
				preparedStatement = getConnection().prepareStatement(
					"SELECT TREAT(VALUE(b) AS buyer_t) FROM Buyer b"
				);
			}
			else if (type.equalsIgnoreCase("Listing")) {
				preparedStatement = getConnection().prepareStatement(
					"SELECT TREAT(VALUE(l) AS listing_t) FROM Listing l"
				);
			}
			else if (type.equalsIgnoreCase("Property/House")) {
				preparedStatement = getConnection().prepareStatement(
					"SELECT TREAT(VALUE(p) AS house_t) FROM Property p WHERE VALUE(p) IS OF TYPE (house_t)"
				);
			}
			else if (type.equalsIgnoreCase("Property/BusinessProperty")) {
				preparedStatement = getConnection().prepareStatement(
					"SELECT TREAT(VALUE(p) AS businessproperty_t) FROM Property p WHERE VALUE(p) IS OF TYPE (businessproperty_t)"
				);
			}
			else if (type.equalsIgnoreCase("Works_With")) {
				preparedStatement = getConnection().prepareStatement(
					"SELECT TREAT(VALUE(w) AS works_with_t) FROM Works_With w"
				);
			}

			resultSet = preparedStatement.executeQuery();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return resultSet;
	}

	public void deleteByIdFromTable(String type, Object... queryParams) {
		try {
			PreparedStatement preparedStatement = null;
			
			if (type.equalsIgnoreCase("Agency")) {
				preparedStatement = getConnection().prepareStatement(
					"DELETE FROM Agency a WHERE id = ? AND VALUE(a) IS OF TYPE (agency_t)"
				);
			}
			else if (type.equalsIgnoreCase("Agent")) {
				preparedStatement = getConnection().prepareStatement(
					"DELETE FROM Agent a WHERE agentId = ? AND VALUE(a) IS OF TYPE (agent_t)"
				);
			}
			else if (type.equalsIgnoreCase("Buyer")) {
				preparedStatement = getConnection().prepareStatement(
					"DELETE FROM Buyer b WHERE id = ? AND VALUE(b) IS OF TYPE (buyer_t)"
				);
			}
			else if (type.equalsIgnoreCase("Listing")) {
				preparedStatement = getConnection().prepareStatement(
					"DELETE FROM Listing l WHERE listingNumber = ? AND VALUE(l) IS OF TYPE (listing_t)"
				);
			}
			else if (type.equalsIgnoreCase("Property/House")) {
				preparedStatement = getConnection().prepareStatement(
					"DELETE FROM Property p WHERE address = ? AND VALUE(p) IS OF TYPE (house_t)"
				);
			}
			else if (type.equalsIgnoreCase("Property/BusinessProperty")) {
				preparedStatement = getConnection().prepareStatement(
					"DELETE FROM Property p WHERE address = ? AND VALUE(p) IS OF TYPE (businessproperty_t)"
				);
			}
			else if (type.equalsIgnoreCase("Works_With")) {
				Object buyer_id = queryParams[0];
				Object agent_agentId = queryParams[1];
				preparedStatement = getConnection().prepareStatement(
					"DELETE FROM Works_With w WHERE "
					+ "w.buyer.id " 
					+ (buyer_id == null ? "is null " : "= ? ")
					+ "AND w.agent.agentId " 
					+ (agent_agentId == null ? "is null " : "= ? ")
					+ "AND VALUE(w) IS OF TYPE (works_with_t) "
					+ "AND ROWNUM = 1"
				);
			}
		
			if (type.equalsIgnoreCase("Works_With")) {
				Object buyer_id = queryParams[0];
				Object agent_agentId = queryParams[1];
				if (buyer_id != null && agent_agentId != null) {
					preparedStatement.setObject(1, buyer_id);
					preparedStatement.setObject(2, agent_agentId);
				}
				else if (buyer_id != null) {
					preparedStatement.setObject(1, buyer_id);
				}
				else if (agent_agentId != null) {
					preparedStatement.setObject(1, agent_agentId);
				}
			}
			else {
				Object id = queryParams[0];
				preparedStatement.setObject(1, id);
			}
			
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateByIdInTable(String type, Object... queryParams) {
		try {
			PreparedStatement preparedStatement = null;
			
			if (type.equalsIgnoreCase("Agency")) {
				preparedStatement = getConnection().prepareStatement(
					"UPDATE Agency a SET VALUE(a) = agency_t(?, ?, ?) WHERE a.id = ?"
				);
				
				Object id = queryParams[0];
				Object name = queryParams[1];
				Object address = queryParams[2];
				
				preparedStatement.setObject(1, id);
				preparedStatement.setObject(2, name);
				preparedStatement.setObject(3, address);
				preparedStatement.setObject(4, id);
			}
			else if (type.equalsIgnoreCase("Agent")) {
				preparedStatement = getConnection().prepareStatement(
					"UPDATE Agent a SET VALUE(a) = agent_t(?, name_t(?, ?), ?, TO_DATE(?, 'YYYY-MM-DD'), (SELECT REF(ag) FROM Agency ag WHERE id=?)) WHERE a.agentId = ?"
				);
				
				Object agentId = queryParams[0];
				Object name_firstName = queryParams[1];
				Object name_lastName = queryParams[2];
				Object phone = queryParams[3];
				Object dateStarted = queryParams[4];
				Object agency_id = queryParams[5];
				
				preparedStatement.setObject(1, agentId);
				preparedStatement.setObject(2, name_firstName);
				preparedStatement.setObject(3, name_lastName);
				preparedStatement.setObject(4, phone);
				preparedStatement.setObject(5, dateStarted);
				preparedStatement.setObject(6, agency_id);
				preparedStatement.setObject(7, agentId);
			}
			else if (type.equalsIgnoreCase("Buyer")) {
				preparedStatement = getConnection().prepareStatement(
					"UPDATE Buyer b SET VALUE(b) = buyer_t(?, name_t(?, ?), ?, ?, ?, ?, ?, ?) WHERE b.id = ?"
				);
				
				Object id = queryParams[0];
				Object name_firstName = queryParams[1];
				Object name_lastName = queryParams[2];
				Object phone = queryParams[3];
				Object propertyType = queryParams[4];
				Object numberOfDesiredRooms = queryParams[5];
				Object businessPropertyType = queryParams[6];
				Object minimumDesiredPriceInLeva = queryParams[7];
				Object maximumDesiredPriceInLeva = queryParams[8];
				
				preparedStatement.setObject(1, id);
				preparedStatement.setObject(2, name_firstName);
				preparedStatement.setObject(3, name_lastName);
				preparedStatement.setObject(4, phone);
				preparedStatement.setObject(5, propertyType);
				preparedStatement.setObject(6, numberOfDesiredRooms);
				preparedStatement.setObject(7, businessPropertyType);
				preparedStatement.setObject(8, minimumDesiredPriceInLeva);
				preparedStatement.setObject(9, maximumDesiredPriceInLeva);
				preparedStatement.setObject(10, id);
			}
			else if (type.equalsIgnoreCase("Listing")) {
				preparedStatement = getConnection().prepareStatement(
					"UPDATE Listing l SET VALUE(l) = listing_t(?, TO_DATE(?, 'YYYY-MM-DD'), (SELECT REF(a) FROM Agent a WHERE agentId=?), (SELECT REF(p) FROM Property p WHERE address=?)) WHERE l.listingNumber = ?"
				);
				
				Object listingNumber = queryParams[0];
				Object dateListed = queryParams[1];
				Object agent_agentId = queryParams[2];
				Object property_address = queryParams[3];
				
				preparedStatement.setObject(1, listingNumber);
				preparedStatement.setObject(2, dateListed);
				preparedStatement.setObject(3, agent_agentId);
				preparedStatement.setObject(4, property_address);
				preparedStatement.setObject(5, listingNumber);
			}
			else if (type.equalsIgnoreCase("Property/House")) {
				preparedStatement = getConnection().prepareStatement(
					"UPDATE Property p SET VALUE(p) = house_t(?, name_t(?, ?), ?, ?, ?) WHERE p.address = ?"
				);
				
				Object address = queryParams[0];
				Object ownerName_firstName = queryParams[1];
				Object ownerName_lastName = queryParams[2];
				Object priceInLeva = queryParams[3];
				Object numberOfRooms = queryParams[4];
				Object sizeInSquareMeters = queryParams[5];
				
				preparedStatement.setObject(1, address);
				preparedStatement.setObject(2, ownerName_firstName);
				preparedStatement.setObject(3, ownerName_lastName);
				preparedStatement.setObject(4, priceInLeva);
				preparedStatement.setObject(5, numberOfRooms);
				preparedStatement.setObject(6, sizeInSquareMeters);
				preparedStatement.setObject(7, address);
			}
			else if (type.equalsIgnoreCase("Property/BusinessProperty")) {
				preparedStatement = getConnection().prepareStatement(
					"UPDATE Property p SET VALUE(p) = businessproperty_t(?, name_t(?, ?), ?, ?, ?) WHERE p.address = ?"
				);
				
				Object address = queryParams[0];
				Object ownerName_firstName = queryParams[1];
				Object ownerName_lastName = queryParams[2];
				Object priceInLeva = queryParams[3];
				Object businessPropertyType = queryParams[4];
				Object sizeInSquareMeters = queryParams[5];
				
				preparedStatement.setObject(1, address);
				preparedStatement.setObject(2, ownerName_firstName);
				preparedStatement.setObject(3, ownerName_lastName);
				preparedStatement.setObject(4, priceInLeva);
				preparedStatement.setObject(5, businessPropertyType);
				preparedStatement.setObject(6, sizeInSquareMeters);
				preparedStatement.setObject(7, address);
			}

			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertIntoTable(String type, Object... queryParams) {
		try {
			PreparedStatement preparedStatement = null;
			
			if (type.equalsIgnoreCase("Agency")) {
				preparedStatement = getConnection().prepareStatement(
					"INSERT INTO Agency VALUES (agency_t(?, '', ''))"
				);
			}
			else if (type.equalsIgnoreCase("Agent")) {
				preparedStatement = getConnection().prepareStatement(
					"INSERT INTO Agent VALUES (agent_t(?, name_t('', ''), '', ?, null))"
				);
			}
			else if (type.equalsIgnoreCase("Buyer")) {
				preparedStatement = getConnection().prepareStatement(
					"INSERT INTO Buyer VALUES (buyer_t(?, name_t('', ''), '', '', '', '', '', ''))"
				);
			}
			else if (type.equalsIgnoreCase("Listing")) {
				preparedStatement = getConnection().prepareStatement(
					"INSERT INTO Listing VALUES (listing_t(?, ?, null, null))"
				);
			}
			else if (type.equalsIgnoreCase("Property/House")) {
				preparedStatement = getConnection().prepareStatement(
					"INSERT INTO Property VALUES (house_t(?, name_t('', ''), '', '', ''))"
				);
			}
			else if (type.equalsIgnoreCase("Property/BusinessProperty")) {
				preparedStatement = getConnection().prepareStatement(
					"INSERT INTO Property VALUES (businessproperty_t(?, name_t('', ''), '', '', ''))"
				);
			}
			else if (type.equalsIgnoreCase("Works_With")) {
				preparedStatement = getConnection().prepareStatement(
					"INSERT INTO Works_With VALUES ((SELECT REF(b) FROM Buyer b WHERE id=?), (SELECT REF(a) FROM Agent a WHERE agentId=?))"
				);
			}
			
			if (type.equalsIgnoreCase("Works_With")) {
				Object buyer_id = queryParams[0];
				Object agent_agentId = queryParams[1];
				preparedStatement.setObject(1, buyer_id);
				preparedStatement.setObject(2, agent_agentId);
			}
			else {
				Object id = queryParams[0];
				preparedStatement.setObject(1, id);
			}
			
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ResultSet getMaxIdFromTable(String type) {
		ResultSet resultSet = null;
		
		try {
			PreparedStatement preparedStatement = null;
			
			if (type.equalsIgnoreCase("Agency")) {
				preparedStatement = getConnection().prepareStatement(
					"SELECT id FROM Agency a WHERE id = (SELECT MAX(id) FROM Agency)"
				);
			}
			else if (type.equalsIgnoreCase("Agent")) {
				preparedStatement = getConnection().prepareStatement(
					"SELECT agentId FROM Agent a WHERE agentId = (SELECT MAX(agentId) FROM Agent)"
				);
			}
			else if (type.equalsIgnoreCase("Buyer")) {
				preparedStatement = getConnection().prepareStatement(
					"SELECT id FROM Buyer b WHERE id = (SELECT MAX(id) FROM Buyer)"
				);
			}
			else if (type.equalsIgnoreCase("Listing")) {
				preparedStatement = getConnection().prepareStatement(
					"SELECT listingNumber FROM Listing l WHERE listingNumber = (SELECT MAX(listingNumber) FROM Listing)"
				);
			}
			
			resultSet = preparedStatement.executeQuery();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return resultSet;
	}
	
}