package net.dvt32.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import net.dvt32.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person> {
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			
			person.setId( rs.getInt("id") );
			person.setName( rs.getString("name") );
			person.setLocation( rs.getString("location") );
			person.setBirthDate( rs.getTimestamp("birth_date") );
			
			return person;
		}
	}
	
	// SELECT * FROM PERSON;
	public List<Person> findAll() {
		return jdbcTemplate.query( 
			"SELECT * FROM PERSON", 
			new PersonRowMapper()
		);
	}
	
	public Person findById(int id) {
		return (Person) jdbcTemplate.queryForObject( 
			"SELECT * FROM Person WHERE id = ?", 
			new Object[] { id },
			new BeanPropertyRowMapper(Person.class) 
		);
	} 
	
	public int deleteById(int id) {
		return jdbcTemplate.update( 
			"DELETE FROM Person WHERE id = ?", 
			new Object[] { id }
		);
	}
	
	public int insert(Person person) {
		return jdbcTemplate.update( 
			"INSERT INTO Person (id, name, location, birth_date) VALUES (?, ?, ?, ?)", 
			new Object[] { 
				person.getId(), 
				person.getName(), 
				person.getLocation(), 
				new Timestamp( person.getBirthDate().getTime() )
			}
		);
	}
	
	public int update(Person person) {
		return jdbcTemplate.update( 
			"UPDATE Person " + 
		    "SET name = ?, location = ?, birth_date = ? " +
			"WHERE Id = ?", 
			new Object[] {  
				person.getName(), 
				person.getLocation(), 
				new Timestamp( person.getBirthDate().getTime() ),
				person.getId()
			}
		);
	}
	
}
