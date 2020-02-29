package net.dvt32.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;

import net.dvt32.security.ApplicationUserRole;

@Repository("fake")
public class FakeApplicationUserDaoService 
	implements ApplicationUserDao 
{

	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
		return 
			getApplicationUsers().stream()
				.filter( applicationUser -> username.equals(applicationUser.getUsername()) )
				.findFirst();
	}
	
	private List<ApplicationUser> getApplicationUsers() {
		List<ApplicationUser> applicationUsers = Lists.newArrayList(
			new ApplicationUser(
				"annasmith", 
				passwordEncoder.encode("password"), 
				ApplicationUserRole.STUDENT.getGrantedAuthorities(),
				true, true, true, true
			),
			new ApplicationUser(
				"linda", 
				passwordEncoder.encode("password"), 
				ApplicationUserRole.ADMIN.getGrantedAuthorities(),
				true, true, true, true
			),
			new ApplicationUser(
				"tom", 
				passwordEncoder.encode("password"), 
				ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities(),
				true, true, true, true
			)
		);
		
		return applicationUsers;
	}

}