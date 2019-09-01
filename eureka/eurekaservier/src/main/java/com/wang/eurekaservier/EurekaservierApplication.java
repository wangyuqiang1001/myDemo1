package com.wang.eurekaservier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *服务注册中心 eureka server
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaservierApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaservierApplication.class, args);
	}
}
