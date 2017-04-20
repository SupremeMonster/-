package com.boot.web;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.LoginInfo;
import com.boot.entity.Telephone;
import com.boot.service.LoginInfoService;
import com.boot.service.TelephoneService;




@Api(value = "TelphoneController", description = "通讯录接口")
@RestController
@RequestMapping("/public")
public class TelephoneController {
	@Autowired
	  private TelephoneService telephoneService;;
	@ResponseBody
@ApiOperation(value = "通讯录搜索", notes = "通讯录搜索")
	@RequestMapping(value = "/telephone/{name}", method = RequestMethod.GET, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功"),
			@ApiResponse(code = 400, message = "{code:****,message:'失败'}") })
	public Telephone selectTel (@PathVariable("name")String  name){  
        return telephoneService.selectTel(name);
    }  
	
	
	@ApiOperation(value = "显示所有通讯录", notes = "显示所有通讯录")
	@RequestMapping(value = "/telephone/user", method = RequestMethod.GET, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功"),
			@ApiResponse(code = 400, message = "{code:****,message:'失败'}") })
	public List<Telephone> selectAll(){  
        return telephoneService.selectAll();
    }  
	
	@ApiOperation(value = "添加联系人", notes = "添加联系人")
	@RequestMapping(value = "/telephone/user", method = RequestMethod.POST, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功"),
			@ApiResponse(code = 400, message = "{code:****,message:'失败'}") })
	public void insert (@RequestBody Telephone telephone){  
                telephoneService.insert(telephone);
    }  
	
	@ApiOperation(value = "修改联系人", notes = "修改联系人")
	@RequestMapping(value = "/telephone/user", method = RequestMethod.PUT, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功"),
			@ApiResponse(code = 400, message = "{code:****,message:'失败'}") })
	public void update (@RequestBody Telephone telephone){  
                telephoneService.update(telephone);
    }  
	
	@ApiOperation(value = "删除联系人", notes = "删除联系人")
	@RequestMapping(value = "/telephone/user/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功"),
			@ApiResponse(code = 400, message = "{code:****,message:'失败'}") })
	public void delete (@PathVariable("id")Integer id){  
                telephoneService.delete(id);
    }  
	
	

}
