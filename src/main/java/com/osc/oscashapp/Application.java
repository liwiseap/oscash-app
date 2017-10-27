package com.osc.oscashapp;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.osc.oscashapp.properties.memcached.MemcachedProperties;

//@SpringBootApplication(exclude = MybatisAutoConfiguration.class)
//@EnableAutoConfiguration
//@ServletComponentScan
@EnableConfigurationProperties({MemcachedProperties.class})
@SpringBootApplication
@MapperScan("com.osc.oscashapp.mapper")
public class Application {
	
	protected static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		//logger.info("【一秒现金APP启动】程序启动中，请稍后...");
		SpringApplication.run(Application.class, args);
	}
}
