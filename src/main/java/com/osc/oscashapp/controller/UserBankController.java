package com.osc.oscashapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.osc.oscashapp.entity.user.bank.TUserBank;
import com.osc.oscashapp.service.user.bank.UserBankService;

@RestController
public class UserBankController {
	
	@Autowired
	private UserBankService userBankService;
	
	@GetMapping("/bank")
    public String getUserBank(String bankId) {
		List<TUserBank> userBanks = userBankService.getAll();
		System.out.println(JSONObject.toJSON(userBanks).toString());
        return JSONObject.toJSON(userBanks).toString();
    }
}
