package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan(value = "com.example.dao")
public class MicroservicecloudProviderDept8003Application {

	public static void main(String[] args) {

		SpringApplication.run(MicroservicecloudProviderDept8003Application.class, args);
	}

}

