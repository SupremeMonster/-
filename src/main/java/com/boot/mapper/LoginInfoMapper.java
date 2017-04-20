package com.boot.mapper;

import org.springframework.stereotype.Repository;

import com.boot.entity.LoginInfo;

@Repository
public interface LoginInfoMapper {

	public LoginInfo selectUser(LoginInfo loginInfo);
}
