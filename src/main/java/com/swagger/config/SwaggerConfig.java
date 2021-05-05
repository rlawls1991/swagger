package com.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration("SwaggerConfig")
@EnableSwagger2
public class SwaggerConfig {


    @Bean("swagger_api")
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swagger.controller"))
                .paths(PathSelectors.any()) // basePackage로부터 Mapping된 resource를 문서화 시킴
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Chatbot API Documentation")
                .description("This documents describes about Kakao Chatbot RestAPI ")
                .version("1.0.0")
                .build();
    }
}
