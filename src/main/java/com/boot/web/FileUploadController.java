package com.boot.web;

import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileOutputStream;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {
@RequestMapping("/file")
public String file(){
	return "/file";
    }


//单文件上传
/*@RequestMapping(value="/upload", method= RequestMethod.POST)
@ResponseBody

public String handleFileUpload(@RequestParam("file")MultipartFile file){
	if(!file.isEmpty()){
		try{
			BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(file.getOriginalFilename()));
			out.write(file.getBytes());
			out.flush();
			out.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
			return "上传失败,"+e.getMessage();
		}catch(IOException e){
			e.printStackTrace();
			return "上传失败,"+e.getMessage();
		}
		return "上传成功";
	}else{
		return "上传失败，文件为空";
	}
 }*/

//多文件上传  主要使用MultipartHttpRequest和MultipartFile

@RequestMapping(value="/batch/upload",method=RequestMethod.POST)
public @ResponseBody  String handleFileUpload(HttpServletRequest request){
	List<MultipartFile>files=((MultipartHttpServletRequest) request).getFiles("file");
	MultipartFile file=null;
	BufferedOutputStream stream=null;
	for(int i=0;i<files.size();++i){
		file=files.get(i);
		if(!file.isEmpty()){
			try{
				byte[]bytes=file.getBytes();
				stream=new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
				stream.write(bytes);
				stream.close();
			}catch(Exception e){
				stream=null;
				return "failed to upload "+i+"=>"+e.getMessage();
			}
		}else{
			return "failed to upload "+(i+1)+"=>"+"because the file is empty!";
		}
	}
	return "upload success!";
}



}