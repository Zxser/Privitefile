package com.dh.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.system.base.BaseDaoImpl;
import com.dh.system.po.SysModule;
import com.dh.system.service.SysModuleService;
import com.dh.system.vo.SysModuleQuery;
import com.dh.utils.PageInfo;
import com.github.pagehelper.PageHelper;
@Service
@Transactional
public class SysModuleServiceImpl extends BaseDaoImpl<SysModule> implements SysModuleService{

	@Override
	public List<SysModule> fingAll(SysModule sysModule) {
		List<SysModule> list=this.findList("findAll", sysModule, SysModule.class);
		return list;
	}

	@Override
	public SysModuleQuery getSysModuleById(Long id) {
		return this.findOne("findById", id, SysModuleQuery.class);
	}
	@Transactional
	public void update(SysModule SysModule) {
		this.update("update", SysModule);
	}
	@Transactional
	public void delete(Long[] arrayid) {
		this.delete("delete", arrayid);
	}
	@Transactional
	public void save(SysModule SysModule) {
		this.save("insert", SysModule);
	}

	
	public List<SysModule> getSysTopModule() {
		return this.findList("top", null, SysModule.class);
	}

	
	public List<SysModule> findModuleByUserId(long userId) {
		return this.findList("findModuleByUserId", userId, SysModule.class);
	}

	@Override
	public List<SysModule> getbyParendId(Long parendId) {
		return this.findList("findModuleByParendId", parendId, SysModule.class);
	}
		@Override
	public PageInfo findPage(PageInfo pageInfo, SysModuleQuery sysModuleQuery) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize()).setOrderBy("id desc");
		List<SysModuleQuery> 	findList = this.findList("findAll", sysModuleQuery,SysModuleQuery.class);		
		pageInfo.setList(findList);
		Integer count = this.findOne("count", sysModuleQuery,Integer.class);
		pageInfo.setRecordCount(count);
		return pageInfo;
	}

	@Override
	public List<SysModule> findByRoleId(Long id) {
		return this.findList("findByRoleId", id, SysModule.class);
	}

	@Override
	public List<SysModule> getByRoleIds(Long id) {
		return this.findList("getByRoleIds", id, SysModule.class);
	}

	@Override
	public List<SysModule> findModuleByUserIdModuleId(Map<String, Object> map2) {
		return this.findList("findModuleByUserIdModuleId", map2, SysModule.class);
	}
	
}
