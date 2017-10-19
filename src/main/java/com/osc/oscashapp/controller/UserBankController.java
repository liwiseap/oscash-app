package com.osc.oscashapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osc.oscashapp.entity.user.bank.TUserBank;
import com.osc.oscashapp.service.user.bank.UserBankService;

@RestController
public class UserBankController {
	
	@Autowired
	private UserBankService userBankService;
	
	@RequestMapping("/bank")
    public String getUserBank(String bankId) {
		TUserBank userBank = userBankService.getUserBank(bankId);
		System.out.println(userBank.toString());
        return "getUserBank";
    }
}
