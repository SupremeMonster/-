package com.boot.web;




import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.User;
import com.boot.service.UserService;

@Api(value = "UserManagerController", description = "人员管理接口")
@RestController
@RequestMapping("/springboot/usermanage")
public class TestController {
	
	@Autowired 
	private UserService userService;
	@ResponseBody
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	@ApiOperation(value="根据id查询用户信息",notes="根据id查询用户信息")
    public User getUser (
    		@ApiParam(required=true,name="id",value="用户id")
    		@PathVariable("id")Integer id) throws Exception{
	// System.out.println(userService.getUserById(id));
		Assert.notNull(id);
		if(userService.getUserById(id).equals(null)){
			throw new Exception();
		}
		
	    return userService.getUserById(id); 
     }
	
	@RequestMapping(value="/user", method=RequestMethod.PUT)
	@ApiOperation(value="添加用户",notes="添加用户")
    public void insertUser (
    		@ApiParam(name="user",value="用户实体")
    		@RequestBody User user){
	// System.out.println(userService.getUserById(id));
		Assert.notNull(user);
		userService.insertUser(user);
     }
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	@ApiOperation(value="删除用户",notes="删除用户")
	public void deleteUser(@ApiParam(name="id",value="用户id") @PathVariable("id")Integer id) throws Exception{
		Assert.notNull(id);
		if(userService.getUserById(id).equals(null)){
			throw  new Exception();
		}
		userService.delete(id);
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	@ApiOperation(value="修改用户",notes="修改用户")
	public void updateUser(@ApiParam(name="user",value="用户实体")@RequestBody User user){
		Assert.notNull(user);
		userService.update(user);
	}	
	
}
