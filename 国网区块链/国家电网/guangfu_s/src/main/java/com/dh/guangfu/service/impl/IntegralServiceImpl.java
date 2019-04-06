package com.dh.guangfu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.guangfu.po.Integral;
import com.dh.guangfu.po.TrafficElectricity;
import com.dh.guangfu.service.IntegralService;
import com.dh.guangfu.vo.TrafficElectricityQuery;
import com.dh.system.base.BaseDaoImpl;
@Service
public class IntegralServiceImpl extends BaseDaoImpl<Integral> implements IntegralService{

	@Transactional
	public void delete( Long arrayid) {
		super.delete("deleteById", arrayid);
	}
	
	
	
	@Transactional
	@Override
	public void save(Integral Integral) {
		super.save("insert", Integral);
	}

	@Override
	public List<Integral> fingByIntegralServiceQuery(TrafficElectricityQuery trafficElectricityQuery) {
		return this.findList("fingByIntegralQuery", trafficElectricityQuery, Integral.class);
	}



	@Override
	public List<Integral> fingByUserReport(TrafficElectricityQuery trafficElectricityQuery) {
		return this.findList("fingByUserReport", trafficElectricityQuery, Integral.class);
	}

}
