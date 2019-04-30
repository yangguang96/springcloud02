package com.example;

import com.example.myrule.RandomRule_ZY;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="MICROSERVICECLOUDABA-DEPT",configuration=RandomRule_ZY.class)
public class MicroservicecloudConsumerDept80Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicecloudConsumerDept80Application.class, args);
	}

}
