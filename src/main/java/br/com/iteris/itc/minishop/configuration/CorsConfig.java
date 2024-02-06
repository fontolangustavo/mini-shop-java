package br.com.iteris.itc.minishop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@Profile({ "local", "dev"})
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer (){
        return new WebMvcConfigurer() {
            public void addCorsConfigurer (CorsRegistry registry){
                registry
                        .addMapping("/**")
                        .allowedOrigins("*")
                        .allowedHeaders("*")
                        .allowedMethods("*");
            }
        };
    }
}