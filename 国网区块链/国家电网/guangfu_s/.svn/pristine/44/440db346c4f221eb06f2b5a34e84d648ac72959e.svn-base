package com.dh.guangfu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.guangfu.po.NodeAddress;
import com.dh.guangfu.service.NodeAddressService;
import com.dh.guangfu.vo.NodeAddressQuery;
import com.dh.system.base.BaseDaoImpl;
import com.dh.utils.PageInfo;
import com.github.pagehelper.PageHelper;
@Service
public class NodeAddressServiceImpl extends BaseDaoImpl<NodeAddress> implements NodeAddressService{

	@Transactional
	public void delete( Long arrayid) {
		super.delete("deleteById", arrayid);
	}
	@Override
	public List<NodeAddress> fingAll() {
		return this.findList("findAll", null, NodeAddress.class);
	}
	
	@Override
	public NodeAddress fingById(Long arrayid ) {
		return this.findOne("findById", arrayid, NodeAddress.class);
	}
	
	@Transactional
	@Override
	public void update(NodeAddress NodeAddress) {
		super.update("update", NodeAddress);
	}
	@Transactional
	@Override
	public void save(NodeAddress NodeAddress) {
		super.update("insert", NodeAddress);
	}
	@Override
	public PageInfo findPage(PageInfo pageInfo, NodeAddressQuery NodeAddressQuery) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize()).setOrderBy("id desc");
		List<NodeAddress> list=super.findList("findAll", NodeAddressQuery, NodeAddress.class);
		pageInfo.setList(list);
		Integer count=this.findOne("count", NodeAddressQuery,  Integer.class);
		pageInfo.setRecordCount(count);
		return pageInfo;
	}
	@Override
	public NodeAddress findByAredId(int i) {
		return this.findOne("findByAreaId", i, NodeAddress.class);
	}

}
