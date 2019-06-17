package com.mse.forum.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class AuthorizationServerConfiguration 
	extends AuthorizationServerConfigurerAdapter 
{
	private final static String[] GRANT_TYPES = { "password", "get_token", "refresh_token" };

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
			.inMemory()
			.withClient("admin")
			.secret(encoder().encode("admin"))
			.autoApprove(true)
			.scopes("read", "write")
			.authorizedGrantTypes(GRANT_TYPES);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) 
		throws Exception 
	{
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore);
	}

	private PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

}