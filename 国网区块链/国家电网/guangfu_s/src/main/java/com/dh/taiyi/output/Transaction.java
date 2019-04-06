package com.dh.taiyi.output;

import java.math.BigDecimal;
import java.util.List;

public class Transaction extends CfosOutput<Transaction> {
	
	private BigDecimal amount;
	
	private BigDecimal fee;
	
	private Long confirmations;
	
	private String blockhash;
	
	private Long blockindex;
	
	private Long blocktime;
	
	private String txid;
	
	private Long time;
	
	private Long timereceived;
	
	private List<TransactionDetail> details;

	public BigDecimal getAmount() {
		return result.amount;
	}

	public BigDecimal getFee() {
		return result.fee;
	}

	public Long getConfirmations() {
		return result.confirmations;
	}

	public String getBlockhash() {
		return result.blockhash;
	}

	public Long getBlockindex() {
		return result.blockindex;
	}

	public Long getBlocktime() {
		return result.blocktime;
	}

	public String getTxid() {
		return result.txid;
	}

	public Long getTime() {
		return result.time;
	}

	public Long getTimereceived() {
		return result.timereceived;
	}

	public List<TransactionDetail> getDetails() {
		return result.details;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public void setConfirmations(Long confirmations) {
		this.confirmations = confirmations;
	}

	public void setBlockhash(String blockhash) {
		this.blockhash = blockhash;
	}

	public void setBlockindex(Long blockindex) {
		this.blockindex = blockindex;
	}

	public void setBlocktime(Long blocktime) {
		this.blocktime = blocktime;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public void setTimereceived(Long timereceived) {
		this.timereceived = timereceived;
	}

	public void setDetails(List<TransactionDetail> details) {
		this.details = details;
	}
	
}
