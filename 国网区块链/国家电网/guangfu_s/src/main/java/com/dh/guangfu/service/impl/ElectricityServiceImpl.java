package com.dh.guangfu.service.impl;

import org.springframework.stereotype.Service;

import com.dh.guangfu.po.Electricity;
import com.dh.guangfu.service.ElectricityService;
import com.dh.system.base.BaseDaoImpl;
@Service
public class ElectricityServiceImpl extends BaseDaoImpl<Electricity> implements ElectricityService{

	@Override
	public Electricity findById(Long id) {
		Electricity Electricity = this.findOne("findById", id, Electricity.class);
		return Electricity;
	}

	@Override
	public void update(Electricity Electricity) {
		this.update("update", Electricity);
	}

	@Override
	public void insert(Electricity Electricity) {
		this.update("insert", Electricity);		
	}

	@Override
	public Electricity findByUserId(Integer userId) {
		Electricity Electricity = this.findOne("findByUserId", userId, Electricity.class);
		return Electricity;
	}
	

	}
