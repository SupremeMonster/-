package com.boot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Plan;
import com.boot.mapper.PlanMapper;
import com.boot.service.PlanService;
@Service
public class PlanServiceImpl implements PlanService{
@Autowired
  
	  private PlanMapper planMapper;
	
	@Override
	public List<Plan> selectAll() {
		
		return planMapper.selectAll();
	}

	@Override
	public void delete(Integer id) {
		planMapper.delete(id);
		
	}

	@Override
	public void update(Plan plan) {
		planMapper.update(plan);
		
		
	}

	@Override
	public void save(Plan plan) {
		planMapper.save(plan);
		
	}

	@Override
	public List<Plan> select(String plan,String user) {
		
		return planMapper.select(plan,user);
	}

}
