package com.wang.enrekaclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker    //表明异常断路开启4
//@EnableHystrix
//@EnableDiscoveryClient
//可以理解成和enableEurekaclient一样，表明标记为服务的注册和发现

public class Enrekaclient2Application {

	public static void main(String[] args) {
		SpringApplication.run(Enrekaclient2Application.class, args);
	}
}
