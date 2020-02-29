package net.dvt32.security;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import net.dvt32.auth.ApplicationUserService;
import net.dvt32.jwt.JwtConfig;
import net.dvt32.jwt.JwtTokenVerifier;
import net.dvt32.jwt.JwtUsernameAndPasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PasswordEncoder passwordEncoder;
	private final ApplicationUserService applicationUserService;
	private final JwtConfig jwtConfig;
	private final SecretKey secretKey;
	
	@Autowired
	public ApplicationSecurityConfig(
		PasswordEncoder passwordEncoder, 
		ApplicationUserService applicationUserService,
		JwtConfig jwtConfig,
		SecretKey secretKey) 
	{
		this.passwordEncoder = passwordEncoder;
		this.applicationUserService = applicationUserService;
		this.jwtConfig = jwtConfig;
		this.secretKey = secretKey;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		
		http
			.csrf()
				.disable()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.addFilter( new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey) )
				.addFilterAfter( new JwtTokenVerifier(jwtConfig, secretKey), JwtUsernameAndPasswordAuthenticationFilter.class )
				.authorizeRequests()
					.antMatchers("/", "index", "/css/*", "/js/*")
						.permitAll()
					.antMatchers("/api/**")
						.hasRole( ApplicationUserRole.STUDENT.name() )
				.anyRequest()
					.authenticated();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(applicationUserService);
		return provider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
		throws Exception 
	{
		auth.authenticationProvider( daoAuthenticationProvider() );
	}
	
	/*
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails annaSmithUser = 
			User.builder()
				.username("annasmith")
				.password( passwordEncoder.encode("password") )
				//.roles( ApplicationUserRole.STUDENT.name() )
				.authorities( ApplicationUserRole.STUDENT.getGrantedAuthorities() )
				.build();
		
		UserDetails lindaUser = 
			User.builder()
				.username("linda")
				.password( passwordEncoder.encode("password123") )
				//.roles( ApplicationUserRole.ADMIN.name() )
				.authorities( ApplicationUserRole.ADMIN.getGrantedAuthorities() )
				.build();
		
		UserDetails tomUser = 
			User.builder()
				.username("tom")
				.password( passwordEncoder.encode("password123") )
				//.roles( ApplicationUserRole.ADMINTRAINEE.name() )
				.authorities( ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities() )
				.build();
		
		return new InMemoryUserDetailsManager(annaSmithUser, lindaUser, tomUser);
	}
	*/
	
	
	
}