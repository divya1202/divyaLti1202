package com.Lti.microservices_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;



@SpringBootApplication
@EnableConfigServer
public class MicroservicesConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesConfigApplication.class, args);
	}

}
