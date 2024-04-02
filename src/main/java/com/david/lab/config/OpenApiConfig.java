package com.david.lab.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenApiConfig() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Lab 2 - RestFUL Web Services")
                        .description("Lab 2 implemented with Spring Boot and Java 21."));
    }
}
