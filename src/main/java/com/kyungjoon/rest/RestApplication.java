package com.kyungjoon.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.kyungjoon.rest"})
@EnableScheduling
@SpringBootApplication
public class RestApplication extends SpringBootServletInitializer {



    /*임베디드 톰켓사용시*/
    /*    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }*/

    public RestApplication() {
        super();
        setRegisterErrorPageFilter(false); // <- this one
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RestApplication.class);
    }
}
