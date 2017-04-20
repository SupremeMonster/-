package com.boot.serviceimpl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import org.springframework.web.multipart.MultipartFile;

import com.boot.entity.Photo;
import com.boot.mapper.PhotoMapper;
import com.boot.service.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService{

	
	@Autowired
	private PhotoMapper photoMapper;
	
	@Override
	public void save(byte[] file) {
		Photo ph=new Photo();
		ph.setPhoto(file);
		photoMapper.insert(ph);
		
	}
	@Override
	public void delete(Integer id) {
		photoMapper.delete(id);
		
	}
	
	
	
	@Override
	public BufferedImage select(Integer id) throws Exception {
		Photo photo = photoMapper.select(id);
		if(photo==null){
			throw new Exception("没有这个文件");
		}
		byte[] sign = photo.getPhoto();
		if(sign==null){
			sign=new byte[0];
		}
		ByteArrayInputStream in = new ByteArrayInputStream(sign);
		BufferedImage image = ImageIO.read(in);     //将in作为输入流，读取图片存入image中，而这里in可以为ByteArrayInputStream();
		return image;
	}
	@Override
	public List<BufferedImage> selectAll() {
		return null;
		
	}

}
