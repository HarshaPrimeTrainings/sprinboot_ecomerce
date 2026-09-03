package com.springcomerce.productservice.config;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
@Configuration
public class JwtConvertor implements Converter<Jwt, AbstractAuthenticationToken>{

	@Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
	String clientId;
	

	@Override
	public AbstractAuthenticationToken convert(Jwt jwt) {
		Collection<GrantedAuthority> roles = extractRoles(jwt);
		return new JwtAuthenticationToken(jwt,roles);
	}
	
	private Collection<GrantedAuthority> extractRoles(Jwt jwt){
		
		Map<String, Object> resourceAccessMap = jwt.getClaim("resource_access");
		
		if(resourceAccessMap==null) {
			return Collections.emptySet();
		}
		
		Map<String, List<String>>  rolesMap = (Map<String, List<String>>) resourceAccessMap.get(clientId);
		
		List<String> roles = rolesMap.get("roles");
		
		return roles.stream().map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toSet());
		
		
	}
	
	
	
}
