package com.dh.system.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dh.system.base.BaseController;
import com.dh.system.po.SysModule;
import com.dh.system.po.SysRole;
import com.dh.system.po.SysRoleModule;
import com.dh.system.service.SysModuleService;
import com.dh.system.service.SysRoleModuleService;
import com.dh.system.service.SysRoleService;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping
@Api(value = "角色管理",description="角色管理接口 api", tags = "角色管理接口")
public class SysRoleController extends BaseController{
	@Autowired
	private SysRoleService roleService;
	@Autowired
	private SysRoleModuleService sysRoleModuleService;
	@Autowired
	private SysModuleService sysModuleService;
	@ApiOperation(value="获取所有角色", notes="")
	@GetMapping("/sysRole/getAllRole")
	public R getAllRole() {
		List<SysRole> roleList=roleService.fingAll();
		return R.ok().put("list", roleList);
	}
	
	@ApiOperation(value="根据id获取", notes="根据id获取")
	@GetMapping("/sysRole/getById/{id}")
	public R getById(@PathVariable(name="id") Long id) {
		try {
			SysRole role=roleService.getSysRoleById(id);
			List<SysRoleModule> roleModule = sysRoleModuleService.getbyRoleId(id);
			Long[]  moduleIds=new Long[roleModule.size()];
			int i=0;
			for (SysRoleModule sysUserRole2 : roleModule) {
				moduleIds[i++]=sysUserRole2.getModuleId();
			}
			role.setModuleId(moduleIds);
			return	R.ok().put("role", role);
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
	@ApiOperation(value="获取角色已过滤过的资源列表", notes="获取角色已过滤过的资源列表")
	@GetMapping("/sysRole/getByRoleIds/{id}")
	public R getByRoleId(@PathVariable(name="id") Long id) {
		try {
			List<SysModule> roleModule = sysModuleService.getByRoleIds(id);
			return	R.ok().put("role", roleModule);
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
	
	
	@ApiOperation(value="保存或者修改", notes="")
	@RequestMapping(value="/sysRole/save", method = RequestMethod.POST)
	public R save(@RequestBody SysRole sysRole) {
		try {
			if (null != sysRole.getId()&&0!=sysRole.getId()) {
				if(StringUtils.isEmpty(sysRole.getName())){
					SysRole sysRoleById = roleService.getSysRoleById(sysRole.getId());
					sysRole.setName(sysRoleById.getName());
				}
				roleService.updateRole(sysRole);
			} else {
				roleService.save("insert", sysRole);
			} 
			List<SysModule> moduleList=sysModuleService.findByRoleId(sysRole.getId());
			return R.ok().put("role", moduleList).put("roleId", sysRole.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
	}
	@ApiOperation(value="保存授权权限", notes="自选菜单授权功能")
	@RequestMapping(value="/sysRoleModules/save", method = RequestMethod.POST)
	public R sysRoleModules(@RequestBody SysRoleModule sysRoleModule) {
		sysRoleModuleService.save(sysRoleModule);
			
		List<SysModule> module=sysRoleModuleService.getbyPId(sysRoleModule);
		return R.ok().put("list", module);
	}
	
	@ApiOperation(value="保存权限最终判断", notes="保存权限最终判断")
	@RequestMapping(value="/sysRole/saveModules", method = RequestMethod.POST)
	public R saveModules(@RequestBody SysRoleModule sysRoleModule) {
		sysRoleModuleService.saveModules(sysRoleModule);
//		List<SysModule> module=sysRoleModuleService.getbyPId(sysRoleModule.getModuleId());
		return R.ok().put("list", "");
	}
	
	@ApiOperation(value="删除角色", notes="根据id删除角色信息")
	 @ApiImplicitParam(name = "arrayid", value = "角色arrayid", required = true, dataType = "int")
	@DeleteMapping("/sysRole/delete/{arrayid}")
	public Map<String, Object> delete(@PathVariable(name="arrayid") Long[] arrayid) {
		try {
			roleService.delete(arrayid);
			return R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
	}
}
