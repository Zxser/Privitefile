package com.dh.guangfu.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.dh.config.ConfigProperties;
import com.dh.guangfu.po.NodeAddress;
import com.dh.guangfu.service.NodeAddressService;
import com.dh.guangfu.service.TaiyiService;
import com.dh.taiyi.CoinInterface;
@Service
public class TaiyiServiceImpl  implements TaiyiService{
	@Autowired
	private ConfigProperties configProperties;
	@Autowired
	NodeAddressService nodeAddressService;
	
	public static  CoinInterface shanghai;// new CoinInterface("http://192.168.1.185:55556", "scnode1", "123456");
	
	static Map<Integer,CoinInterface> map=new HashMap<Integer, CoinInterface>();
	@PostConstruct
	private void init(){
		if(null==shanghai){
			shanghai=new CoinInterface(configProperties.getServiceUrl(), configProperties.getUsername(), configProperties.getPassword());
		}
	}
	
	@Override
	public CoinInterface getNodeArea(Integer i) {
		CoinInterface nodeInter = map.get(i);
		if(null!=nodeInter){
			return nodeInter;
		}else{
			NodeAddress nodeAddress = nodeAddressService.findByAredId(i);
			if(null!=nodeAddress){
				CoinInterface songjiangArea = new CoinInterface("http://"+nodeAddress.getTransaction_url()+":"+nodeAddress.getNote_port(), nodeAddress.getRpc_name(), nodeAddress.getRpc_password());
				map.put(i, songjiangArea);
				return songjiangArea;
			}
		}
		return null;
	}

	@Override
	public String GetNewAddress(String string) {
		this.init();
		return shanghai.GetNewAddress(configProperties.getSymbol(), string);
	}

	@Override
	public CoinInterface getCoinInterface() {
		this.init();
		return shanghai;
	}

	@Override
	public String sendAssettoAddressTool(String gfbTotalAddr, String sc_addr, double money, String string) {
		this.init();
		return shanghai.SendAssettoAddressTool(configProperties.getGfbTotalAddr(), sc_addr, money, string);
	}
	
}
