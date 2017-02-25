package com.boot.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.boot.entity.Address;
import com.boot.entity.Person;

@Service
public class RedisDemoService {
  @Cacheable(value="personcache",keyGenerator="wiselyKeyGenerator")
  public Person findPerson(Long id,String firstName,String lastName){
	 System.out.println("无缓存的时候调用这里");
	 return new Person(id,firstName,lastName);			
  }	
  @Cacheable(value="addresscache",keyGenerator="wiselyKeyGenerator")
  public Address findAddress(Long id,String province,String city){
	  System.out.println("无缓存的时候调用这里");
	  return new Address(id,province,city);
	 
  }
}
