package com.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.entity.Address;
import com.boot.entity.Person;
import com.boot.service.RedisDemoService;
@Controller
public class RedisDemoController {
	@Autowired 
	private RedisDemoService redisDemoService;
	
	@RequestMapping("/redistest")
	@ResponseBody
	
	public String putcache(){
		redisDemoService.findPerson(1l, "ding","yi");
		redisDemoService.findAddress(1l, "jiangsu", "nanjing");
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
		return "ok";
	}
	
	@RequestMapping("redistest2")
	@ResponseBody
	
	public String testcache(){
		Person person=redisDemoService.findPerson(1l,"ding", "yi");
		Address address=redisDemoService.findAddress(1l, "jiangsu","nanjing");
		System.out.println("查询");
		System.out.println("person"+"/"+person.getFirstName()+person.getLastName());
		System.out.println("address"+"/"+address.getProvince()+address.getCity());
		return "ok";
	}
	
	
}
