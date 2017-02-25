package com.boot.service;

import com.boot.entity.User;

public interface UserService {

	public User getUserById(Integer id);
	
	public void insertUser(User user);

	public void delete(Integer id);

	public void update(User user);

}
