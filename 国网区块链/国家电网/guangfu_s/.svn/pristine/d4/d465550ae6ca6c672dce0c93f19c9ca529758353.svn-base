package com.dh.taiyi.output;

//import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class SendData extends CfosOutput<SendData> {
	
	@JSONField(name = "txid")
	private String txid;
	
	@JSONField(name = "cashchangeaddress")
	private String cashChangeAddress;
	
	@JSONField(name = "assetchangeaddress")
	private String assetChangeAddress;

	public void setTxid(String txid) {
		this.txid = txid;
	}
	
	public String getTxid() {
		return result.txid;
	}

	public String getCashChangeAddress() {
//		if (null != result && result.size() > 0) {
//			for (int i = 0; i < result.size(); ++i) {
//				if (!StringUtils.isEmpty(result.get(i).cashChangeAddress)) {
//					return result.get(i).cashChangeAddress;
//				}
//			}
//		}
//		return null;
		return result.cashChangeAddress;
	}

	public void setCashChangeAddress(String cashChangeAddress) {
		this.cashChangeAddress = cashChangeAddress;
	}

	public String getAssetChangeAddress() {
//		if (null != result && result.size() > 0) {
//			for (int i = 0; i < result.size(); ++i) {
//				if (!StringUtils.isEmpty(result.get(i).assetChangeAddress)) {
//					return result.get(i).assetChangeAddress;
//				}
//			}
//		}
//		return null;
		return result.assetChangeAddress;
	}

	public void setAssetChangeAddress(String assetChangeAddress) {
		this.assetChangeAddress = assetChangeAddress;
	}
	
	public String getAssetTxid() {
//		if (null != result && result.size() > 0) {
//			for (int i = 0; i < result.size(); ++i) {
//				if (!StringUtils.isEmpty(result.get(i).assetChangeAddress)) {
//					return result.get(i).txid;
//				}
//			}
//		}
//		return null;
		return result.txid;
	}
	
	public String getCashTxid() {
//		if (null != result && result.size() > 0) {
//			for (int i = 0; i < result.size(); ++i) {
//				if (!StringUtils.isEmpty(result.get(i).cashChangeAddress)) {
//					return result.get(i).txid;
//				}
//			}
//		}
//		return null;
		return result.txid;
	}
}
