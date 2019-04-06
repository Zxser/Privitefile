package com.dh.guangfu.service.impl;

import org.springframework.stereotype.Service;

import com.dh.guangfu.po.ServerData;
import com.dh.guangfu.service.ServerDataService;
import com.dh.system.base.BaseDaoImpl;
@Service
public class ServerDataServiceImpl extends BaseDaoImpl<ServerData> implements ServerDataService{

	@Override
	public void save(ServerData serverData) {
		super.save("insert", serverData);
		
	}
}
