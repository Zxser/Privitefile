package com.dh.guangfu.service;

import java.util.List;

import com.dh.guangfu.po.NodeAddress;
import com.dh.guangfu.vo.NodeAddressQuery;
import com.dh.system.base.BaseDao;
import com.dh.utils.PageInfo;
/***
 *taiyi配置管理
 * @author liliangliang
 *
 */
public interface NodeAddressService extends BaseDao{
	List<NodeAddress> fingAll();
	
	NodeAddress fingById(Long arrayid);
	
	void update(NodeAddress NodeAddress);

	void delete(Long arrayid);

	void save(NodeAddress NodeAddress);
	
	PageInfo findPage(PageInfo pageInfo, NodeAddressQuery NodeAddressQuery);

	NodeAddress findByAredId(int i);
	
}
