package com.dh.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.system.base.BaseController;
import com.dh.system.po.SysModule;
import com.dh.system.service.SysModuleService;
import com.dh.system.vo.SysModuleQuery;
import com.dh.utils.PageInfo;
import com.dh.utils.R;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping
public class SysModuleController extends BaseController{
	@Autowired
	private SysModuleService ModuleService;
	
	@ApiOperation(value="查询资源", notes="查询所有资源")
	@PostMapping(value="/sysModule/list")
	public R getList(@RequestBody  SysModuleQuery SysModuleQuery) {
		pageInfo=new PageInfo(SysModuleQuery.getPageNum(), SysModuleQuery.getPageSize());
		 ModuleService.findPage(pageInfo,SysModuleQuery);
		return R.ok().put("pageInfo", pageInfo);
	}
	@ApiOperation(value="查询所有资源", notes="查询所有资源")
	@GetMapping(value="/sysModule/getAll")
	public R listall(){
		List<SysModule> fingAll = ModuleService.fingAll(new SysModule());
		return R.ok().put("list", fingAll);
	}
	@ApiOperation(value="查询顶级资源", notes="查询所有资源")
	@GetMapping(value="/sysModule/findTopAndChildren")
	public R findTopAndChildren(){
		List<SysModule> fingAll = ModuleService.getSysTopModule();
		 getModuleList(fingAll);
		return R.ok().put("list",fingAll);
	}
	
	@ApiOperation(value="查询顶级资源", notes="查询所有资源")
	@GetMapping(value="/sysModule/findTop")
	public R findTop(){
		List<SysModule> fingAll = ModuleService.getSysTopModule();
		getModuleList(fingAll);
		return R.ok().put("list",fingAll);
	}
	
	public void getModuleList(List<SysModule> list){
		for (SysModule sysModule : list) {
			List<SysModule> sysModuleList=ModuleService.getbyParendId(sysModule.getId());
			if(sysModuleList!=null&&sysModuleList.size()>0){
				sysModule.setChildren(sysModuleList);
				getModuleList(sysModuleList);
			}
		}
	}
 	
	@ApiOperation(value="保存或者修改资源", notes="")
	@PostMapping(value="/sysModule/save")
	public R save(@RequestBody SysModule sysModule) {
		if(null!=sysModule.getId() && 0!=sysModule.getId()){
			
			ModuleService.update(sysModule);
		}else{
			ModuleService.save(sysModule);
		}
		R.ok();
		return R.ok();
	}
	
	@ApiOperation(value="编辑资源", notes="")
	@GetMapping("/sysModule/getById/{id}")
	public R getById(@PathVariable(name="id") Long id) {
		SysModuleQuery sysModule = ModuleService.getSysModuleById(id);
		return R.ok().put("sysModule",sysModule);
	}
	
	@ApiOperation(value="删除资源", notes="")
	@PostMapping("/sysModule/delete")
	public R delete(@RequestBody  SysModuleQuery SysModuleQuery) {
		try {
			ModuleService.delete(SysModuleQuery.getArrayId());
			return R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
		
	}
}
