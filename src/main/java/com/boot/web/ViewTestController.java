package com.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ViewTestController {
	@RequestMapping(value="/hellohtml")
	public String helloHtml(Model model){
		model.addAttribute("name","dear");
		 return "/hellohtml";
	}
	
}
