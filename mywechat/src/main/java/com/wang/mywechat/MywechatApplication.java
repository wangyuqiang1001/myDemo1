package com.wang.mywechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
//		exclude = {DataSourceAutoConfiguration.class}
		)
public class MywechatApplication {

	public static void main(String[] args) {
		SpringApplication.run(MywechatApplication.class, args);
	}

}

