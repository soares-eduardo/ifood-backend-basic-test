package com.ifood.demo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class IfoodBackendTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(IfoodBackendTestApplication.class, args);
	}

	@Bean
	public OpenAPI generateCustomOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("iFood 3 - Backend Basic Test")
				.version("1.0"));
	}
}
