package com.boot.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.LoginInfo;
import com.boot.service.LoginInfoService;


@Api(value = "LoginInfoController", description = "登录验证接口")
@RestController
@RequestMapping("/public")
public class LoginInfoController {
	@Autowired
	  private LoginInfoService loginInfoService;
	@ResponseBody
@ApiOperation(value = "登录验证", notes = "登录验证")
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	/*@ApiResponses(value = { @ApiResponse(code = 200, message = "成功"),
			@ApiResponse(code = 400, message = "{code:****,message:'失败'}") })*/
	public String login(LoginInfo loginInfo){  
        return String.valueOf(loginInfoService.login(loginInfo));  
    }  
}
