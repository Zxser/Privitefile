package com.dh.guangfu.controller;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.dh.backview.po.SysUser;
import com.dh.backview.service.SysUserService;
import com.dh.config.ConfigProperties;
import com.dh.guangfu.po.NodeAddress;
import com.dh.guangfu.service.NodeAddressService;
import com.dh.guangfu.service.TaiyiService;
import com.dh.system.base.BaseController;
import com.dh.taiyi.CoinInterface;
import com.dh.utils.MD5Util;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 列表
 * @author Administrator
 *
 */
@RestController
@RequestMapping()
@Api(value = "区块链接口",description="区块链接口", tags = "区块链接口")
public class TestController extends BaseController{
	@Autowired
	ConfigProperties configProperties;
	@Autowired
	TaiyiService taiyiService;
	@Autowired
	NodeAddressService nodeAddressService;
	
	@Autowired
	private SysUserService userService;
	
	
	@ApiOperation(value="生成超导网络地址", notes="生成超导网络地址")
	@GetMapping(value="/getNewaddr")
	public R getList() {
		CoinInterface shanghai = taiyiService.getCoinInterface();
		return R.ok().put("超导地址", shanghai.sc_newaddr());
	}
	
	@ApiOperation(value="获取所有已连接的超导信息", notes="获取所有已连接的超导信息")
	@GetMapping(value="/sc_getpeers")
	public R sc_getpeers() {
		CoinInterface shanghai = taiyiService.getCoinInterface();
		return R.ok().put("获取所有已连接的超导信息", shanghai.sc_getpeers());
	}
	
	@ApiOperation(value="获取已同步的区块信息", notes="获取已同步的区块信息")
	@GetMapping(value="/sc_getinfo")
	public R sc_getinfo() {
		CoinInterface shanghai = taiyiService.getCoinInterface();
		return R.ok().put("获取所有已连接的超导信息", shanghai.sc_getinfo());
	}
	
	@ApiOperation(value="证书上链", notes="获取已同步的区块信息")
	@GetMapping(value="/go_lian")
	public R go_lian() {
		CoinInterface shanghai = taiyiService.getCoinInterface();
		SysUser user = userService.getById(getLoginUser().getId());
		String text=MD5Util.sha256("xxxxxxxxxxxxxx");
		shanghai.RegisterAssetByUnit(configProperties.getGfbTotalAddr(), user.getCoin_address(), 1, text, configProperties.getCosefee());
		return R.ok().put("获取所有已连接的超导信息", shanghai.sc_getinfo());
	}
	
	@ApiOperation(value="往超导代理节点打币", notes="往区的地址打币")
	@GetMapping(value="/goAddressMoney")
	public R sendAssettoAddress(String sc_addr,double money) {
		//统计这个区的所有用户的前天的总积分
		CoinInterface shanghai = taiyiService.getCoinInterface();
		NodeAddress nodeAddress = nodeAddressService.findByAredId(310106);
	    String txId = shanghai.SendAssettoAddressTool(configProperties.getGfbTotalAddr(), sc_addr, money, configProperties.getCosefee());
	    JSONObject jSONObject= getJSONObject(txId);
	    if(null!=jSONObject){
	    	nodeAddress.setTxid(jSONObject.getJSONObject("result").getString("txid"));
	    	nodeAddressService.update(nodeAddress);
	    }
	    return R.ok().put("交易ID", txId);
	}
	//**  代理节点可以一直往用户节点大币，需要用到这个超导id   到12点开始结算
	@ApiOperation(value="建立超导链接,并且清算用户币", notes="需要打币的交易Id")
	@GetMapping(value="/createCaoDaoLink")
	public R createCaoDaoLink() {
		 CoinInterface coinInterface = taiyiService.getCoinInterface();
		 String superjsS = coinInterface.sc_getinfo();
		 NodeAddress nodeAddress = nodeAddressService.findByAredId(130182);
		 //建立超导链接端口
		 String superNodeId = coinInterface.sc_connect("192.168.1.184",43445,nodeAddress.getTransaction_url(), nodeAddress.getSuper_port(),configProperties.getUsername(),configProperties.getPassword(), nodeAddress.getTxid());
		 JSONObject superjsStr =getJSONObject(superNodeId);
 //		 String superNodeId_address = jsStr.getString("id");
		 String superNodeId_address="032c867992f517bb3e9f83e7fceb128ac43849729464db0ce5d6cbd37d05cd0cd4";
		 //获取区域的节点
		 CoinInterface userNodeArea= taiyiService.getNodeArea(310106);
		 	 		//用户昨天一天的累计积分的值	//用户区块链的地址
//		 生成账单  sc_invoice
		String zhangdan = userNodeArea.sc_invoice(10,DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss")+"");
		 System.out.println(zhangdan);
		 String rhash=getJSONObject(zhangdan).getJSONObject("result").getString("rhash");
//		 获取上海支付路径
		String payPath = coinInterface.sc_getroute(superNodeId_address, 10, 1);
		System.out.println(payPath);
		 JSONObject route= getJSONObject(payPath);
		 if(null!=route){
			 route= route.getJSONObject("result").getJSONArray("route").getJSONObject(0);
			String nodeB_id= route.getString("id");
			int satoshi= Integer.parseInt(route.getString("satoshi"));
			int delay =  Integer.parseInt(route.getString("delay"));
			String  sendResult = coinInterface.sc_sendpay(nodeB_id, satoshi, delay, rhash, "shanghai pay to sgeren: "+satoshi);
			JSONObject jsStr = JSONObject.parseObject(sendResult);
			 String preimage = jsStr.getJSONObject("result").getString("preimage");
			 System.out.println(preimage);
//			 String restu = coinInterface.sc_close(nodeB_id);
			 //返回的地址 打给区域的地址
//			 System.out.println(restu);
		 }
		 return R.ok();
	}
}
