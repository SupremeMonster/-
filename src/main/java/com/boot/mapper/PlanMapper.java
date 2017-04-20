package com.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.boot.entity.Plan;

@Repository		
public interface PlanMapper {

	  public List<Plan> selectAll();
	   
	  void delete(Integer id);
	  
	  void update(Plan plan);
	  
	  void save(Plan plan);
	  


	public List<Plan> select(@Param("plan")String plan,@Param("user") String user);
	  
}
