package com.osc.oscashapp;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = MybatisAutoConfiguration.class)
@EnableAutoConfiguration
@ServletComponentScan
@MapperScan("com.osc.oscashapp.mapper")
public class OscashAppApplication {
	
	private static Logger logger = Logger.getLogger(OscashAppApplication.class);
	
	public static void main(String[] args) {
		logger.info("【一秒现金APP启动】程序启动中，请稍后...");
		SpringApplication.run(OscashAppApplication.class, args);
	}
}
