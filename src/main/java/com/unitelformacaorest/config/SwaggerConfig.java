package com.unitelformacaorest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalTime;
import java.util.Collections;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.unitelformacaorest.controlador"))
                .paths(PathSelectors.any())
                .build()
                .directModelSubstitute(LocalTime.class,String.class)
                .apiInfo(getInformation());
    }

    private ApiInfo getInformation(){
        return  new ApiInfo("REST Unitel formação","A API unitel formação foi criada com spring boot",
                "13.0","Terms de Serviço:blash\",contact,\"Apache License Version 2.0",
                new Contact("Unitel", "https://unitel.co.ao", "unitel@gmail.com"),
                "API License",
                "http://www.apache.org/licenses/LICENSE-2.0",
                Collections.emptyList()
        );
    }
}
