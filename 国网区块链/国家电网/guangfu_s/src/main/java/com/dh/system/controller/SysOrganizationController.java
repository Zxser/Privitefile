package com.dh.system.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dh.system.base.BaseController;
import com.dh.system.po.SysOrganization;
import com.dh.system.service.SysOrganizationService;
import com.dh.system.vo.SysOrganizationQuery;
import com.dh.utils.PageInfo;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping
@Api(value = "组织管理",description="组织管理接口 api", tags = "组织管理接口")
public class SysOrganizationController extends BaseController{
	@Autowired
	private SysOrganizationService OrganizationService;
	
	
	@ApiOperation(value="获取组织", notes="全部组织")
	@PostMapping("/sysOrganization/list")
	public R list(@RequestBody SysOrganizationQuery sysOrganization){
		PageInfo pageInfo = new PageInfo(sysOrganization.getPageNum(), sysOrganization.getPageSize());
		OrganizationService.fingAll(pageInfo, sysOrganization);
		return R.ok().put("page", pageInfo);
	}
	
	@ApiOperation(value="查询全部组织信息", notes="")
	@GetMapping("/sysOrganization/fingAllByTree")
	public R fingAllByTree() {
		List<SysOrganization> fingAll = OrganizationService.fingAllByTree();
		return R.ok().put("list", fingAll);
	}
	
	@ApiOperation(value="保存或者修改组织", notes="")
	@RequestMapping(value="/sysOrganization/save", method = RequestMethod.POST)
	public Map<String, Object> save(@RequestBody SysOrganization sysOrganization) {
		try {
			if(null!=sysOrganization.getId()&&0!=sysOrganization.getId()){
				OrganizationService.update(sysOrganization);
			}else{
				OrganizationService.save(sysOrganization);
			}
			return R.ok();
		} catch (Exception e) { 
			e.printStackTrace();
			return R.error();
		}
	}
	
	@ApiOperation(value="编辑组织", notes="")
	@GetMapping("/sysOrganization/getById/{id}")
	public Map<String,Object> edit(@PathVariable(name="id") Long id) {
		SysOrganization sysOrganization = OrganizationService.getSysOrganizationById(id);
		return R.ok().put("sysOrganization", sysOrganization);
	}
	
	@ApiOperation(value="删除组织", notes="")
	@DeleteMapping("/sysOrganization/delete/{arrayid}")
	public Map<String, Object> delete(@PathVariable(name="arrayid") Long arrayid) {
		try {
			List<SysOrganization> sysOrganization = OrganizationService.fingAllchildren(arrayid);
			if(null!=sysOrganization&&sysOrganization.size()>0){
				return R.error("有关联数据，不能删除");
			}
			OrganizationService.delete(arrayid);
			return R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
	}
	
	
	
}
