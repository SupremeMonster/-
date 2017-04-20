package com.boot.mapper;

import org.springframework.stereotype.Repository;

import com.boot.entity.Blog;



@Repository
public interface BlogMapper {

 public Blog select(String title);
	
}
