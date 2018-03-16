package com.zane.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.zane.shop.dao")
@EnableAutoConfiguration
@EnableScheduling
@SpringBootApplication
public class ZaneShopapplication {

	public static void main(String[] args) {
		SpringApplication.run(ZaneShopapplication.class, args);
	}
}
