package com.boot.entity;

import java.util.Date;

public class Plan {
   private Integer id;
   private String plan;
   private String user;
   private Date start;
   private Date end;
   private String state;
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getPlan() {
	return plan;
}
public void setPlan(String plan) {
	this.plan = plan;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public Date getStart() {
	return start;
}
public void setStart(Date start) {
	this.start = start;
}
public Date getEnd() {
	return end;
}
public void setEnd(Date end) {
	this.end = end;
}

	
	  
}
