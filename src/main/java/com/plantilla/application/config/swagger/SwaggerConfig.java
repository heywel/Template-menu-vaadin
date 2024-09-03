package com.plantilla.application.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "REST API Template Project",
                "This API provides the posibility to see all services of the Template Project.",
                "1.0.0",
                "Copyrigyt Corporacion Sistemas Integrados S.A.",
                new Contact("Información", "www.sisintegrados.com", "info@sisintegrados.com"),
                "License of API Corporacion Sistemas Integrados S.A.", "www.sisintegrados.com", Collections.emptyList());
    }
}
