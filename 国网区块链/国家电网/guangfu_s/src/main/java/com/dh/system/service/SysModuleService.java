package com.dh.system.service;

import java.util.List;
import java.util.Map;

import com.dh.system.base.BaseDao;
import com.dh.system.po.SysModule;
import com.dh.system.vo.SysModuleQuery;
import com.dh.utils.PageInfo;

public interface SysModuleService extends BaseDao{
	SysModuleQuery getSysModuleById(Long id);


	List<SysModule> fingAll(SysModule SysModule);

	void update(SysModule SysModule);

	void delete(Long[] arrayid);

	void save(SysModule SysModule);

	List<SysModule> getSysTopModule();

	List<SysModule> findModuleByUserId(long userId);
	PageInfo findPage(PageInfo pageInfo, SysModuleQuery sysModuleQuery);

	List<SysModule> getbyParendId(Long id);


	List<SysModule> findByRoleId(Long id);


	List<SysModule> getByRoleIds(Long id);


	List<SysModule> findModuleByUserIdModuleId(Map<String, Object> map2);
}
