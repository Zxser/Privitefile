package com.dh.taiyi.output;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;

public class RawTransactionOut {

	@JSONField(name = "value")
	private BigDecimal value;

	@JSONField(name = "n")
	private Long n;

	@JSONField(name = "scriptPubKey")
	private OutScriptPubKey scriptPubKey;

	@JSONField(name = "data")
	private OutData data;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Long getN() {
		return n;
	}

	public void setN(Long n) {
		this.n = n;
	}

	public OutData getData() {
		return data;
	}

	public void setData(OutData data) {
		this.data = data;
	}

	public OutScriptPubKey getScriptPubKey() {
		return scriptPubKey;
	}

	public void setScriptPubKey(OutScriptPubKey scriptPubKey) {
		this.scriptPubKey = scriptPubKey;
	}

}
