package com.example.cscfrgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication
public class CscFrGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CscFrGatewayApplication.class, args);
	}

}
