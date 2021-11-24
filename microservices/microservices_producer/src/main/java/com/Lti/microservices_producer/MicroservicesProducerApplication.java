package com.Lti.microservices_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicesProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesProducerApplication.class, args);
	}

}
