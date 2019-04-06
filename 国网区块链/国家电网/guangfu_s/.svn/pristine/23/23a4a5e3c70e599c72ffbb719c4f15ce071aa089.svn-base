package com.dh.guangfu.service;

import com.dh.taiyi.CoinInterface;
/**
 * 太一云服务
 * @author tianjiao
 *
 */
public interface TaiyiService {
	/**
	 * 创建用户地址
	 * @param string
	 * @return
	 */
	String GetNewAddress(String string);
	/**
	 * 获取总结点
	 * @return
	 */
	CoinInterface getCoinInterface();
	/**
	 * 
	  * @param fromAddress 付款地址 GFB地址
	 * @param toAddress   收款地址 GFB地址
	 * @param amount      金额，单位是比特币 BTC
	 * @param feeaddress  手续费找零的地址 ABC地址
	 */
	String sendAssettoAddressTool(String gfbTotalAddr, String sc_addr, double money, String string);
	/**
	 * 获取区域总结点
	 * @param i
	 * @return
	 */
	CoinInterface getNodeArea(Integer i);
}
