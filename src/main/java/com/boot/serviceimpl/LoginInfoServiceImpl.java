package com.boot.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.LoginInfo;
import com.boot.mapper.LoginInfoMapper;
import com.boot.service.LoginInfoService;

@Service
public class LoginInfoServiceImpl implements LoginInfoService {
	@Autowired
	private LoginInfoMapper loginInfoMapper;

	@Override
	public boolean login(LoginInfo loginInfo) {
        return loginInfoMapper.selectUser(loginInfo)==null?false:true;  
	  }

}
