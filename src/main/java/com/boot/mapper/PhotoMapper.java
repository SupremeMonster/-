package com.boot.mapper;

import java.awt.image.BufferedImage;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.boot.entity.Photo;
@Repository
public interface PhotoMapper {

	Photo select(Integer id);

	void insert(Photo photo);

	void delete(Integer id);

	List<Photo> selectAll();
	
	

}
