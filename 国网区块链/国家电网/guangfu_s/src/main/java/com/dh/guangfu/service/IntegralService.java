package com.dh.guangfu.service;

import java.util.List;

import com.dh.guangfu.po.Integral;
import com.dh.guangfu.po.TrafficElectricity;
import com.dh.guangfu.vo.TrafficElectricityQuery;
import com.dh.system.base.BaseDao;

public interface IntegralService extends BaseDao{

	void delete(Long arrayid);

	void save(Integral Integral);

	List<Integral> fingByIntegralServiceQuery(
			TrafficElectricityQuery trafficElectricityQuery);

	List<Integral> fingByUserReport(TrafficElectricityQuery trafficElectricityQuery);
}
