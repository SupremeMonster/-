package com.boot.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.User;
import com.boot.mapper.UserMapper;
import com.boot.service.UserService;
@Service
public class UserServiceImpl implements UserService{
   
@Autowired
	private  UserMapper userMapper; 
	
	@Override
	public User getUserById(Integer id) {
		return userMapper.select(id);
	}

	@Override
	public void insertUser(User user) {
		userMapper.insert(user);
	}

	@Override
	public void delete(Integer id) {
	   userMapper.delete(id);	
	}

	@Override
	public void update(User user) {
       userMapper.update(user);		
	}

}
