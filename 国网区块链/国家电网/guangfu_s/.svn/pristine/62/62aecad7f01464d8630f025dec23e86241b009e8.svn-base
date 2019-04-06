package com.dh.guangfu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.guangfu.po.ProductionElectricity;
import com.dh.guangfu.po.TrafficElectricity;
import com.dh.guangfu.service.ProductionElectricityService;
import com.dh.guangfu.vo.TrafficElectricityQuery;
import com.dh.system.base.BaseDaoImpl;
@Service
public class ProductionElectricityServiceImpl extends BaseDaoImpl<ProductionElectricity> implements ProductionElectricityService{

	@Transactional
	public void delete( Long arrayid) {
		super.delete("deleteById", arrayid);
	}
	
	@Transactional
	@Override
	public void save(ProductionElectricity ProductionElectricity) {
		super.save("insert", ProductionElectricity);
	}

	@Override
	public List<ProductionElectricity> fingByProductionElectricityQuery(TrafficElectricityQuery trafficElectricityQuery) {
		return this.findList("fingByTrafficElectricityQuery", trafficElectricityQuery, ProductionElectricity.class);
	}

	@Override
	public List<ProductionElectricity> fingByUserReport(TrafficElectricityQuery trafficElectricityQuery) {
		return this.findList("fingByUserReport", trafficElectricityQuery, ProductionElectricity.class);
	}

}
