package com.boot.web;



import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.boot.Application;
import com.boot.entity.User;
import com.boot.mapper.UserMapper;

@SpringApplicationConfiguration(classes = Application.class)
public class TestSpringBoot {

	@Autowired
	private UserMapper userMapper;
	 
	/*@Test
	public void insert(User user) throws Exception{
		user.setName("liumou");
		user.setAge(24);
		userMapper.insert(user);
	}*/
	
	/*@Test
	public User select(Integer id) throws Exception{
		return userMapper.select(id);
	}*/
	
/*	@Test
	public void delete(Integer id)throws Exception{
		userMapper.delete(id);
	}*/
	
	@Test
	public void find() throws Exception{
		User user= new User();
		user.setAge(20);
		user.setName("liumou");
		userMapper.insert(user);
	    System.out.println(user.getAge());
	}
	
	
}
