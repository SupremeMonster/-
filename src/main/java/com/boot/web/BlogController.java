package com.boot.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Blog;

import com.boot.service.BlogService;


@Api(value = "BlogController", description = "日志接口")
@RestController
@RequestMapping("/public")
public class BlogController {
@Autowired
private BlogService  blogService;;
@ResponseBody
@ApiOperation(value = "日志搜索", notes = "日志搜索")
@RequestMapping(value = "/blog/{title}", method = RequestMethod.GET, produces = "application/json")
@ApiResponses(value = { @ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 400, message = "{code:****,message:'失败'}") })
public Blog selectTel (@PathVariable("title")String  title){  
       return blogService.selectBlog(title);
   }  
}
