package net.dvt32.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
	/*
    inMemoryUserList.add(new JwtUserDetails(1L, "dvt32",
        "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
    */
    
	inMemoryUserList.add(new JwtUserDetails(1L, "dvt32",
		"$2a$10$lLZFLX3tOdhcLPzHk.QgPu7l7hgqU/TxRlppuixtltU9yYAJ1VyJC", "ROLE_USER_2"));
    
    
    inMemoryUserList.add(new JwtUserDetails(2L, "dmnFTW",
        "$2a$10$QkryeT75SxzYggNCE8m8netVneQ5X9B.wuZNFjeWnwR7pyT4P1yiG", "ROLE_USER_2"));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


