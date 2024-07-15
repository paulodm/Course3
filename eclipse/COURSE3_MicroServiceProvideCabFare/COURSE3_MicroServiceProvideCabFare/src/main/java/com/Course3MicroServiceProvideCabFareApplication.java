package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.entity")
@EnableJpaRepositories(basePackages = "com.repository")
@EnableDiscoveryClient
public class Course3MicroServiceProvideCabFareApplication {

	public static void main(String[] args) {
		SpringApplication.run(Course3MicroServiceProvideCabFareApplication.class, args);
		System.out.println("Course3 MicroService Provide CabFare Application is UP");
	}

}
