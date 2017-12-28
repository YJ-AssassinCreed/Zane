package com.zane.xunwu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zane.xunwu.dao")
@EnableAutoConfiguration
@SpringBootApplication
public class XunwuApplication {

	public static void main(String[] args) {
		SpringApplication.run(XunwuApplication.class, args);
	}
}
