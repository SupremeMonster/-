package com.boot.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Plan;
import com.boot.service.PlanService;




@Api(value = "PlanController", description = "任务计划接口")
@RestController
@RequestMapping("/public")
public class PlanController {
	@Autowired
	  private PlanService planService;
	@ResponseBody
@ApiOperation(value = "查询任务计划", notes = "查询任务计划")
	@RequestMapping(value = "/plan/user/{plan}/{user}", method = RequestMethod.GET, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功"),
			@ApiResponse(code = 400, message = "{code:****,message:'失败'}") })
	public List<Plan> select (
			@ApiParam(name = "plan", value = "计划") @PathVariable(value = "plan") String plan,
			@ApiParam(name = "user", value = "参与者") @PathVariable(value = "user") String user
			){  
		   
        return planService.select(plan,user);
    }  
	
	
	@ApiOperation(value = "显示所有任务计划", notes = "显示所有任务计划")
	@RequestMapping(value = "/plan/user", method = RequestMethod.GET, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功"),
			@ApiResponse(code = 400, message = "{code:****,message:'失败'}") })
	public List<Plan> selectAll(){  
        return planService.selectAll();
    }  
	
	@ApiOperation(value = "添加任务", notes = "添加任务")
	@RequestMapping(value = "/plan/user", method = RequestMethod.POST, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功"),
			@ApiResponse(code = 400, message = "{code:****,message:'失败'}") })
	public void insert (@RequestBody Plan plan){  
		planService.save(plan);
    }  
	
	@ApiOperation(value = "修改任务", notes = "修改任务")
	@RequestMapping(value = "/plan/user", method = RequestMethod.PUT, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功"),
			@ApiResponse(code = 400, message = "{code:****,message:'失败'}") })
	public void update (@RequestBody Plan plan){  
		planService.update(plan);
    }  
	
	@ApiOperation(value = "删除任务", notes = "删除任务")
	@RequestMapping(value = "/plan/user/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功"),
			@ApiResponse(code = 400, message = "{code:****,message:'失败'}") })
	public void delete (@PathVariable("id")Integer id){  
		planService.delete(id);
    }  
	
	
	
	

}
