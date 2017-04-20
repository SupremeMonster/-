package com.boot.service;

import java.util.List;

import com.boot.entity.Telephone;

public interface TelephoneService {
     
	public Telephone selectTel(String name);

	 void insert(Telephone telephone);

	public void update(Telephone telephone);

	public void delete(Integer id);

	public List<Telephone> selectAll();
}
