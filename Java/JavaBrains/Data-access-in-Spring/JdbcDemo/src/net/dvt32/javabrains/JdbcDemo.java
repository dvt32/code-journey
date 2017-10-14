package net.dvt32.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.dvt32.javabrains.dao.HibernateDaoImpl;
import net.dvt32.javabrains.dao.JdbcDaoImpl;
import net.dvt32.javabrains.dao.NamedJdbcDaoImpl;
import net.dvt32.javabrains.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		// JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		// NamedJdbcDaoImpl dao = context.getBean("namedJdbcDaoImpl", NamedJdbcDaoImpl.class);
		HibernateDaoImpl dao = context.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		
		//Circle circle = dao.getCircle(1);
		//System.out.println( circle.getName() );
		
		// System.out.println( dao.getCircleCount() );
		// System.out.println( dao.getCircleName(1) );
		// System.out.println( dao.getCircleForId(1).getName() );
		// dao.insertCircle(new Circle(2, "Second Circle"));
		// dao.insertCircle(new Circle(3, "Third Circle"));
		// dao.createTriangleTable();
		// dao.insertCircle(new Circle(4, "Fourth Circle"));
		// dao.insertCircle(new Circle(5, "Fifth Circle"));
		// System.out.println( dao.getAllCircles().size() );
		
		System.out.println( dao.getCircleCount() );
	}

}
