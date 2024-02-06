package br.com.iteris.itc.minishop.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@OpenAPIDefinition
@Configuration
@Profile({ "local", "dev"})
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("iShop Delivery")
                        .description("Iteris Trainning Center - Spring Boot MiniShop with Clean Architecture and Payment Integration")
                        .version("1.0.0")
                        .termsOfService("Disponível para desafios")
                        .contact(new Contact()
                                .name("Gustavo Fontolan - GFO")
                                .email("gustavo.fontolan@iteris.com.br")
                                .url("equipe.itc@iteris.com.br")));

    }

}
