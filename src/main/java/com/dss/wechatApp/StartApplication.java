package com.dss.wechatApp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mybatis mapper 的包路径（这个一定要配置，这样才能让spring容器扫描mapper接口）
@MapperScan(basePackages = "com.dss.wechatApp.mapper")
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}
}
