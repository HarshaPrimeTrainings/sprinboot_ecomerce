package com.springcomerce.orderservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilteConfig {

	@Autowired
	JwtConvertor jwtConvertor;
	
	@Bean
	SecurityFilterChain initSecurityFilter(HttpSecurity http) {
		
		http.authorizeHttpRequests(auth->auth
				.anyRequest().authenticated())
		.oauth2ResourceServer(oauth->oauth.jwt(jwt->jwt.jwtAuthenticationConverter(jwtConvertor)))
		.logout(logout->logout.permitAll())
		.csrf(csrf->csrf.disable());
		
		return http.build();
		
		
	}
	
	
}
