package com.boot.mapper;

import org.springframework.stereotype.Repository;

import com.boot.entity.User;

@Repository
public interface UserMapper {
	
  public User select(Integer id); 
  
  public void insert(User user);
  
  public void delete(Integer id);

  public void update(User user);
}
