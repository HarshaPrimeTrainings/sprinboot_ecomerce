package com.springcomerce.productservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

	@Bean
	OpenAPI configDoc() {
		OpenAPI openApi = new OpenAPI();
		Info info = new Info();
		info.setTitle("ProdcutService");
		info.version("v1");
		openApi.info(info);
		return openApi;
	}
	
	
}
