package com.dh.guangfu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.guangfu.po.TrafficElectricity;
import com.dh.guangfu.service.TrafficElectricityService;
import com.dh.guangfu.vo.TrafficElectricityQuery;
import com.dh.system.base.BaseDaoImpl;
@Service
public class TrafficElectricityServiceImpl extends BaseDaoImpl<TrafficElectricity> implements TrafficElectricityService{

	@Transactional
	public void delete( Long arrayid) {
		super.delete("deleteById", arrayid);
	}
	
	@Override
	public List<TrafficElectricity> fingByUserReport(TrafficElectricityQuery trafficElectricityQuery){
		return this.findList("fingByUserReport", trafficElectricityQuery, TrafficElectricity.class);
	}	
	
	@Transactional
	@Override
	public void save(TrafficElectricity TrafficElectricity) {
		super.save("insert", TrafficElectricity);
	}

	@Override
	public List<TrafficElectricity> fingByTrafficElectricityQuery(TrafficElectricityQuery trafficElectricityQuery) {
		return this.findList("fingByTrafficElectricityQuery", trafficElectricityQuery, TrafficElectricity.class);
	}

}
