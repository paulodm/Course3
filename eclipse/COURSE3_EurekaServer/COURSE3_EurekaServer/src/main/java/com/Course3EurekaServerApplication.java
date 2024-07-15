package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Course3EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Course3EurekaServerApplication.class, args);
		System.out.println("Eureka Server is up for phase 3");
	}

}
