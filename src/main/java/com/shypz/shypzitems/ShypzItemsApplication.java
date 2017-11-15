package com.shypz.shypzitems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan
@ComponentScan
@EnableDiscoveryClient
public class ShypzItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShypzItemsApplication.class, args);
	}
}
