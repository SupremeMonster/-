package com.boot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Telephone;
import com.boot.mapper.TelephoneMapper;
import com.boot.service.TelephoneService;
@Service
public class TelephoneServiceImpl implements TelephoneService {

	@Autowired
	private  TelephoneMapper telephoneMapper;
	@Override
	public Telephone selectTel(String name) {
		
		return telephoneMapper.select(name);
	}
	@Override
	public void insert(Telephone telephone) {
		
		telephoneMapper.insert(telephone);
	}
	@Override
	public void update(Telephone telephone) {
		telephoneMapper.update(telephone);
		
	}
	@Override
	public void delete(Integer id) {
	    telephoneMapper.delete(id);	
	}
	@Override
	public List<Telephone> selectAll() {

		return telephoneMapper.selectAll();
	}
    
}
