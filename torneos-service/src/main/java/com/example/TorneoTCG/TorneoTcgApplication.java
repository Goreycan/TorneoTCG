package com.example.TorneoTCG;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class TorneoTcgApplication {

	public static void main(String[] args) {
		SpringApplication.run(TorneoTcgApplication.class, args);
	}

}
