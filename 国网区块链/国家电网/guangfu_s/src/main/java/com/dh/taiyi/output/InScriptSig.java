package com.dh.taiyi.output;

import com.alibaba.fastjson.annotation.JSONField;

public class InScriptSig {

	@JSONField(name = "asm")
	private String asm;

	@JSONField(name = "hex")
	private String hex;

	public String getAsm() {
		return asm;
	}

	public void setAsm(String asm) {
		this.asm = asm;
	}

	public String getHex() {
		return hex;
	}

	public void setHex(String hex) {
		this.hex = hex;
	}

}
