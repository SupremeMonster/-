package com.boot.service;

import java.util.List;

import com.boot.entity.Plan;

public interface PlanService {
	  List<Plan> selectAll();
	   
	  void delete(Integer id);
	  
	  void update(Plan plan);
	  
	  void save(Plan plan);
	  
	  List<Plan> select(String plan,String user);

	void changeState(Integer id);
	
	 
}
