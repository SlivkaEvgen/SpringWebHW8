package com.homework.springwebhw8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringWebHw8Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebHw8Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringWebHw8Application.class);
    }

}
