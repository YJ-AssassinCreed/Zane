package com.zane;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zane.dao")
@EnableAutoConfiguration
@SpringBootApplication
public class ZaneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZaneApplication.class, args);
	}
}
