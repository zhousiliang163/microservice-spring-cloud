package com.cy.microservice.consumer.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientWithEurekaApp {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientWithEurekaApp.class, args);
	}
}
