package com.osc.oscashapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.osc.oscashapp.mapper.user.bank.TUserBankMapper;
import com.osc.oscashapp.properties.memcached.MemcachedProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	protected static Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Autowired
    private TUserBankMapper userBankMapper;

	@Test
	public void contextLoads() {
		
		MemcachedProperties memcached = new MemcachedProperties();
		System.out.println("memcached keyprefix="+memcached.getKeyprefix());
		System.out.println("memcached servers="+memcached.getServers());
		
		//userBankMapper.selectAll();
		logger.trace("I am trace log.");  
        logger.debug("I am debug log.");  
        logger.warn("I am warn log.");  
        logger.error("I am error log.");
	}

}
