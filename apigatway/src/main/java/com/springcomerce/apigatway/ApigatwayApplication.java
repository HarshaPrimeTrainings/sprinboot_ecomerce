package com.springcomerce.apigatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableDiscoveryClient
@SpringBootApplication
//@CrossOrigin(origins = "http://localhost:9097",allowedHeaders = {HttpHeaders.CONTENT_TYPE,HttpHeaders.AUTHORIZATION},methods = {RequestMethod.GET,RequestMethod.POST})
public class ApigatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatwayApplication.class, args);
	}

}
