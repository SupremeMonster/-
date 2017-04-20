package com.boot.service;

import java.awt.image.BufferedImage;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.boot.entity.Photo;

public interface PhotoService {

	BufferedImage select(Integer id) throws Exception;

	void save(byte[] file);

	void delete(Integer id);

	List<BufferedImage> selectAll();

}
