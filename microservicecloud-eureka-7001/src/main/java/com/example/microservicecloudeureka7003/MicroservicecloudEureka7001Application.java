package com.example.microservicecloudeureka7003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //EurekaServer服务器端启

public class MicroservicecloudEureka7001Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicecloudEureka7001Application.class, args);
	}

}
