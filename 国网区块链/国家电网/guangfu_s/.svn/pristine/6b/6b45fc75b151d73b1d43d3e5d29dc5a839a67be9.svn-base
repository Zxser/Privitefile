package com.dh.guangfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.dh.guangfu.po.NodeAddress;
import com.dh.guangfu.service.NodeAddressService;
import com.dh.guangfu.service.TaiyiService;
import com.dh.guangfu.vo.NodeAddressQuery;
import com.dh.system.base.BaseController;
import com.dh.taiyi.CoinInterface;
import com.dh.utils.PageInfo;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 国网节点配置
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/nodeAddress")
@Api(value = "后台国网节点管理",description="后台国网节点管理", tags = "后台国网节点管理")
public class NodeAddressController extends BaseController{
	@Autowired
	private NodeAddressService NodeAddressService;
	@Autowired
	private TaiyiService taiyiService;
	
	
	@ApiOperation(value="获取列表", notes="获取列表")
	@PostMapping(value="/getList")
	public R getList(@RequestBody NodeAddressQuery NodeAddress) {
		PageInfo  pageInfo=new PageInfo(NodeAddress.getPageNum(),NodeAddress.getPageSize());
		NodeAddressService.findPage(pageInfo,NodeAddress);
		return R.ok().put("page", pageInfo);
	}
	
	@ApiOperation(value="根据id获取", notes="根据id获取")
	@GetMapping(value="/getListById/{id}")
	public R getListById(@PathVariable(name="id") Long id) {
		NodeAddress NodeAddress=NodeAddressService.fingById(id);
		return R.ok().put("NodeAddress", NodeAddress);
	}
	
	
	@ApiOperation(value="保存或者更新", notes="")
	@PostMapping(value="/save")
	public R save(@RequestBody NodeAddress nodeAddress) {
		try {
			if(null!=nodeAddress.getId()&&0!=nodeAddress.getId()){
					NodeAddressService.update(nodeAddress);
			}else{
				CoinInterface shanghai = taiyiService.getCoinInterface();
				JSONObject jsStr =getJSONObject(shanghai.sc_newaddr());
				if(null!=jsStr){
					String sc_addr = jsStr.getString("result");
					nodeAddress.setSuper_address(sc_addr);
				}
				
				String getNewAddress = taiyiService.GetNewAddress("");
				jsStr =getJSONObject(getNewAddress);
				if(null!=jsStr){
					String sc_addr = jsStr.getString("result");
					nodeAddress.setArea_address(sc_addr);
				}
				NodeAddressService.save(nodeAddress);
			}
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		} 
	}
	
	@ApiOperation(value="删除id", notes="根据id删除")
	@DeleteMapping("/delete/{arrayid}")
	public R delete(@PathVariable(name="arrayid") Long arrayid) {
		try {
			NodeAddressService.delete(arrayid);
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
}
