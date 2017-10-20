package com.osc.oscashapp;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = MybatisAutoConfiguration.class)
//@EnableAutoConfiguration
//@ServletComponentScan
@SpringBootApplication
@MapperScan("com.osc.oscashapp.mapper")
public class Application {
	
	private static Logger logger = Logger.getLogger(Application.class);
	
	public static void main(String[] args) {
		logger.info("【一秒现金APP启动】程序启动中，请稍后...");
		SpringApplication.run(Application.class, args);
	}
}
