package com.boot.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Blog;
import com.boot.mapper.BlogMapper;
import com.boot.service.BlogService;
@Service
public class BlogServiceImpl  implements BlogService{

	@Autowired 
	 private BlogMapper blogMapper;
	@Override
	public Blog selectBlog(String title) {
		
		return blogMapper.select(title);
	}

}
