package com.osc.oscashapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.osc.oscashapp.mapper.user.bank.TUserBankMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	@Autowired
    private TUserBankMapper userBankMapper;

	@Test
	public void contextLoads() {
		userBankMapper.selectAll();
	}

}
