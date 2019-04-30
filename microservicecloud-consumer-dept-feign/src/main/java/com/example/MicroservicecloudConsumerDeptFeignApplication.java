package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.example"})
@ComponentScan("com.example")
public class MicroservicecloudConsumerDeptFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicecloudConsumerDeptFeignApplication.class, args);
	}

}
