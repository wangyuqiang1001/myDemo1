package com.wang.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供者，，需要向注册中心注册该服务
 */
@EnableEurekaClient
@SpringBootApplication
public class EurekaclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaclientApplication.class, args);
	}
}
