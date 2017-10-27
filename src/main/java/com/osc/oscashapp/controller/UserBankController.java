package com.osc.oscashapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.osc.oscashapp.Application;
import com.osc.oscashapp.entity.user.bank.TUserBank;
import com.osc.oscashapp.service.user.bank.UserBankService;

@RestController
public class UserBankController {
	
	protected static Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private UserBankService userBankService;
	
	@GetMapping("/bank")
    public String getUserBank(String bankId) {
		List<TUserBank> userBanks = userBankService.getAll();
		System.out.println(JSONObject.toJSON(userBanks).toString());
		logger.trace("I am trace log.");  
        logger.debug("I am debug log.");  
        logger.warn("I am warn log.");  
        logger.error("I am error log.");
        return JSONObject.toJSON(userBanks).toString();
    }
}
