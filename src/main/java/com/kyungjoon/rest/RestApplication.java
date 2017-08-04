package com.kyungjoon.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;



@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.kyungjoon.rest"})
@EnableScheduling
@SpringBootApplication
public class RestApplication {


	/*asdflkasdlfkasldkflskadflkasdlfk
	asdlkfalsdkflsadflkasdlfkl*/


	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
}
