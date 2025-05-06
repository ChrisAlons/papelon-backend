// src/main/java/com/chanock/papelon_backend/config/OpenApiConfig.java
package com.chanock.papelon_backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String SECURITY_SCHEME_NAME = "bearerAuth";

    @Bean
    public OpenAPI papelonOpenAPI() {
        return new OpenAPI()
                // Información de la API
                .info(new Info()
                        .title("API Papelería Papelon")
                        .description("Documentación de la API REST para la papelería Papelon en México")
                        .version("v1.0"))
                // Declara el esquema de seguridad JWT Bearer
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME_NAME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                )
                // Aplica ese esquema a todos los endpoints por defecto
                .addSecurityItem(new SecurityRequirement()
                        .addList(SECURITY_SCHEME_NAME));
    }
}
