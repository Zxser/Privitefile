package com.dh.taiyi.output;

import com.alibaba.fastjson.annotation.JSONField;

public class SendDataItem {

	@JSONField(name = "txid")
	private String txid;

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

}
