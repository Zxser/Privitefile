package com.dh.guangfu.service;

import java.util.List;

import com.dh.guangfu.po.Price;
import com.dh.guangfu.vo.PriceQuery;
import com.dh.system.base.BaseDao;
import com.dh.utils.PageInfo;
/***
 * 价格管理
 * @author liliangliang
 *
 */
public interface PriceService extends BaseDao{
	List<Price> fingAll();
	
	Price fingById(Long arrayid);
	
	void update(Price Price);

	void delete(Long arrayid);

	void save(Price Price);
	
	PageInfo findPage(PageInfo pageInfo, PriceQuery PriceQuery);
	
}
