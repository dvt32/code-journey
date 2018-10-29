package net.dvt32.spring.aop.data;

import org.springframework.stereotype.Repository;

import net.dvt32.spring.aop.aspect.TrackTime;

@Repository
public class Dao1 {

	@TrackTime
	public String retrieveSomething() {
		return "Dao1";
	}
	
}
