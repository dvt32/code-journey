package net.dvt32.javabrains.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class NamedJdbcDaoImpl extends JdbcDaoSupport {

	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}
	
}
