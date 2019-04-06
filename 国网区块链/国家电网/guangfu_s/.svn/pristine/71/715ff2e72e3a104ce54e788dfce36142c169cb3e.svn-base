package com.dh.guangfu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dh.guangfu.po.Area;
import com.dh.guangfu.service.AreaService;
import com.dh.system.base.BaseDaoImpl;
@Service
public class AreaServiceImpl extends BaseDaoImpl<Area> implements AreaService{

	@Override
	public List<Area> fingAllByCityId(Integer city_id){
		return this.findList("findAll", city_id, Area.class);
	}
	
	@Override
	public Area fingById(Long arrayid ) {
		return this.findOne("findById", arrayid, Area.class);
	}
	

}
