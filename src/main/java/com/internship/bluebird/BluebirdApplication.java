package com.internship.bluebird;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BluebirdApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluebirdApplication.class, args);
	}
}
