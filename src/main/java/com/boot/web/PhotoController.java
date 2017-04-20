package com.boot.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.boot.service.PhotoService;


@Api(value = "PhotoController", description = "文件及图片管理接口")
@RestController

public class PhotoController {

	@Autowired
	private PhotoService photoService;

	// 用户上传图片
	@ApiOperation(value = "用户上传图片", notes = "用户上传图片")
	@ApiResponses({ @ApiResponse(code = 200, message = "上传成功"),
			@ApiResponse(code = 400, message = "{code=****, message='上传失败！'}") })
	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public void insert(
			@ApiParam(name = "file", value = "图片文件") @RequestPart MultipartFile file,
			HttpServletResponse response) throws IOException {

		photoService.save(file.getBytes());
		
	}
	
	
	

	// 用户删除图片
	@ApiOperation(value = "用户删除图片", notes = "用户删除图片")
	@ApiResponses({ @ApiResponse(code = 200, message = "删除成功"),
			@ApiResponse(code = 400, message = "{code=****, message='删除失败！'}") })
	@RequestMapping(value = "/file/{id}", method = RequestMethod.DELETE)
	public void delete(
			@ApiParam(name = "id", value = "id") @PathVariable("id")Integer id,
			HttpServletResponse response) throws IOException {

		photoService.delete(id);
		
	}
	
	
	//
	@ApiOperation(value = "用户获取所有图片", notes = "获取图片接口")
	@ApiResponses({
		@ApiResponse(code = 200, message = "获取图片成功"),
		@ApiResponse(code = 400, message = "{code=****, message='获取图片失败！'}") })
@RequestMapping(value = "/file", method = RequestMethod.GET)
public void getPicture(
		HttpServletResponse response) throws Exception {
	response.setDateHeader("Expires", 0);
	// Set standard HTTP/1.1 no-cache headers.
	response.setHeader("Cache-Control",
			"no-store, no-cache, must-revalidate");
	// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
	response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	// Set standard HTTP/1.0 no-cache header.
	response.setHeader("Pragma", "no-cache");
	// return a jpeg
	response.setContentType("image/jpeg");
	// create the image with the text
	List<BufferedImage> bis = photoService.selectAll();
	ServletOutputStream out = response.getOutputStream();
	if (bis != null) {
		for(BufferedImage bi:bis){
		ImageIO.write(bi, "jpg", out);
		}
	}
	try {
		out.flush();
	} finally {
		out.close();
	}
}

	@ApiOperation(value = "用户获取图片", notes = "获取图片接口")
	@ApiResponses({
			@ApiResponse(code = 200, message = "获取图片成功"),
			@ApiResponse(code = 400, message = "{code=****, message='获取图片失败！'}") })
	@RequestMapping(value = "/file/{id}", method = RequestMethod.GET)
	public void getPicture(@PathVariable("id") Integer id,
			HttpServletResponse response) throws Exception {
		response.setDateHeader("Expires", 0);
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		// return a jpeg
		response.setContentType("image/jpeg");
		// create the image with the text
		BufferedImage bi = photoService.select(id);
		ServletOutputStream out = response.getOutputStream();
		if (bi != null) {
			ImageIO.write(bi, "jpg", out);
		}
		try {
			out.flush();
		} finally {
			out.close();
		}
	}
}