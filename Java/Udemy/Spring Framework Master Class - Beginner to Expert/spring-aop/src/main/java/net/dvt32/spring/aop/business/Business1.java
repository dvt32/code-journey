package net.dvt32.spring.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dvt32.spring.aop.aspect.TrackTime;
import net.dvt32.spring.aop.data.Dao1;

@Service
public class Business1 {

	@Autowired
	private Dao1 dao1;
	
	@TrackTime
	public String calculateSomething() {
		return dao1.retrieveSomething();
	}
}
