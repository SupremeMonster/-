package com.boot.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boot.entity.Telephone;

@Repository
public interface TelephoneMapper {

	 public Telephone select(String name);

	public void insert(Telephone telephone);

	public void update(Telephone telephone);

	public void delete(Integer id);

	public List<Telephone> selectAll();
}
