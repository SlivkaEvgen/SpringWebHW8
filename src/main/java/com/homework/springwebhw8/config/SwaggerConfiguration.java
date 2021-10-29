package com.homework.springwebhw8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//  /swagger-ui/index.jsp
//  /v2/api-docs
//   //    public final static String AUTHORIZATION_HEADER = "Authorization";
////    public final static String DEFAULT_INCLUDE_PATTERN = "/.*";
//@EnableSwagger2
@Configuration
@EnableOpenApi
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.homework.springwebhw8.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Web Application")
                .description("Custom description")
                .version("1.0.0")
                .license("Apache 2.0")
                .license("https://www.apache.org/licences/LICENSE-2.0")
                .build();
    }
}
