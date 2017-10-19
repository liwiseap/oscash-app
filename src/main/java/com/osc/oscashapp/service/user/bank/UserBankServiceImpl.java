package com.osc.oscashapp.service.user.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osc.oscashapp.entity.user.bank.TUserBank;
import com.osc.oscashapp.mapper.user.bank.TUserBankMapper;

@Service
public class UserBankServiceImpl implements UserBankService{
	
	@Autowired
	private TUserBankMapper userBankMapper;

	@Override
	public TUserBank getUserBank(String bankId) {
		return userBankMapper.selectByPrimaryKey(bankId);
	}
	
}
