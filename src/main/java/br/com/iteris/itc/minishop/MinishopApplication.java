package br.com.iteris.itc.minishop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class MinishopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinishopApplication.class, args);
	}

}
