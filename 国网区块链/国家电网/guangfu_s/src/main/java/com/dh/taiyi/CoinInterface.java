package com.dh.taiyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

//import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dh.taiyi.common.Base64;
import com.dh.taiyi.common.NodeAction;

public class CoinInterface {
	private String charset = "utf-8";
	private Integer connectTimeout = null;
	private Integer socketTimeout = null;
	private String proxyHost = null;
	private Integer proxyPort = null;
	private String rpcuser = null;
	private String rpcpassword = null;
	private String url = null;
	private String requestMethod = "POST";

	JSONObject postRpc = new JSONObject();

	public CoinInterface(String serverIP, String rpcUser, String rpcPassword) {
		this.url = serverIP;
		this.rpcuser = rpcUser;
		this.rpcpassword = rpcPassword;
		postRpc.put("jsonrpc", "1.0");
		postRpc.put("id", "1");
	}

	// sc_close "peerid"
	public String sc_close(String peerid) {
		postRpc.put("method", "sc_close");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(peerid);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_connect "host" port "tx"
	/**
	 * 超导连接
	 * @param host IP地址
	 * @param port 端口 默认 9913
	 * @param tx   冻结资金交易记录ID SendAssettoAddress 产生的ID
	 * @return
	 */
	public String sc_connect(String ip,int ipport,String host, int port, String tx,String user,String pwd) {
		postRpc.put("method", "sc_connect");
		JSONObject jo = new JSONObject();
		jo.put("ip", ip);
		jo.put("port", ipport);
		jo.put("contectip", host);
		jo.put("contectport", port);
		jo.put("txid", tx);
		jo.put("user", user);
		jo.put("pwd", pwd);
//		JSONArray arrayNode = new JSONArray();
//		arrayNode.add(host);
//		arrayNode.add(port);
//		arrayNode.add(user);
//		arrayNode.add(pwd);
//		arrayNode.add(tx);
		postRpc.put("params", jo);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_dbg_payback "tx"
	public String sc_Dbg_payback(String tx) {
		postRpc.put("method", "sc_dbg_payback");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(tx);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_delinvoice "label"
	public String sc_delinvoice(String label) {
		postRpc.put("method", "sc_delinvoice");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(label);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 传入公钥，获取私钥
	 * @param dumpprivkey   公钥
	 * @return
	 */
	public String getPrivatekey(String dumpprivkey) {
		postRpc.put("method", "dumpprivkey");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(dumpprivkey);
		postRpc.put("params", arrayNode);
		
		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_dev_add_route "src" "dst" basefee var delay minblocks
	public String sc_dev_add_route(String src, String dst, int basefee, int var, int delay, int minblocks) {
		postRpc.put("method", "sc_dev_add_route");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(src);
		arrayNode.add(dst);
		arrayNode.add(basefee);
		arrayNode.add(var);
		arrayNode.add(delay);
		arrayNode.add(minblocks);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_dev_broadcast enable
	public String sc_dev_broadcast(boolean enable) {
		postRpc.put("method", "sc_dev_broadcast");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(enable);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_dev_commit "peerid"
	public String sc_dev_commit(String peerid) {
		postRpc.put("method", "sc_dev_commit");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(peerid);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_dev_disconnect "peerid"
	public String sc_dev_disconnect(String peerid) {
		postRpc.put("method", "sc_dev_disconnect");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(peerid);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_dev_failhtlc "peerid" id "reason"
	public String sc_dev_failhtlc(String peerid, int id, String reason) {
		postRpc.put("method", "sc_dev_failhtlc");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(peerid);
		arrayNode.add(id);
		arrayNode.add(reason);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_dev_feerate feerate
	public String sc_dev_feerate(int feerate) {
		postRpc.put("method", "sc_dev_feerate");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(feerate);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_dev_fulfillhtlc "peerid" id "rhash"
	public String sc_dev_fulfillhtlc(String peerid, int id, String rhash) {
		postRpc.put("method", "sc_dev_fulfillhtlc");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(peerid);
		arrayNode.add(id);
		arrayNode.add(rhash);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_dev_newhtlc "peerid" satoshi expiry "rhash"
	public String sc_dev_newhtlc(String peerid, int satoshi, int expiry, String rhash) {
		postRpc.put("method", "sc_dev_newhtlc");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(peerid);
		arrayNode.add(satoshi);
		arrayNode.add(expiry);
		arrayNode.add(rhash);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_dev_output "peerid" enable
	public String sc_dev_newhtlc(String peerid, boolean enable) {
		postRpc.put("method", "sc_dev_newhtlc");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(peerid);
		arrayNode.add(enable);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_dev_reconnect "peerid"
	public String sc_dev_newhtlc(String peerid) {
		postRpc.put("method", "sc_dev_newhtlc");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(peerid);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_dev_rhash "secret"
	public String sc_dev_rhash(String secret) {
		postRpc.put("method", "sc_dev_rhash");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(secret);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_dev_routefail enable
	public String sc_dev_rhash(boolean enable) {
		postRpc.put("method", "sc_dev_rhash");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(enable);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_dev_signcommit "peerid"
	public String sc_dev_signcommit(String peerid) {
		postRpc.put("method", "sc_dev_signcommit");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(peerid);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_getchannels
	public String sc_getchannels() {
		postRpc.put("method", "sc_getchannels");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_gethtlcs "peer" resolved
	public String sc_gethtlcs(String peer, boolean resolved) {
		postRpc.put("method", "sc_gethtlcs");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(peer);
		arrayNode.add(resolved);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_getinfo
	public String sc_getinfo() {
		postRpc.put("method", "sc_getinfo");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_getlog "level"
	public String sc_getlog(String level) {
		postRpc.put("method", "sc_getlog");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(level);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_getnodes
	public String sc_getnodes() {
		postRpc.put("method", "sc_getnodes");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_getpeers
	/**
	 * 超导通道中转账总额
	 * @return
	 */
	public String sc_getpeers() {
		postRpc.put("method", "sc_getpeers");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 超导网
	 * 付款方，获取支付路径
	 * @param id 节点ID， 
	 * @param satoshi 付款金额跟  sc_invoice一致
	 * @param riskfactor  风险因子默认为1即可
	 * @return
	 */
	public String sc_getroute(String id, int satoshi, double riskfactor) {
		postRpc.put("method", "sc_getroute");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(id);
		arrayNode.add(satoshi);
		arrayNode.add(riskfactor);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 超导网
	 * 收款方，生成账单
	 * @param satoshi 金额单位是 satoshi   1比特币＝1亿 satoshi
	 * @param label 账单别名,建议使用个人的公钥地址
	 * @param message 可null  描述账单信息
	 * @return
	 */
	public String sc_invoice(long satoshi, String label) {
		postRpc.put("method", "sc_invoice");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(satoshi);
		arrayNode.add(label);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查看个人账单
	 * @param label 同sc_invoice的 lable
	 * @return
	 */
	public String sc_listinvoice(String label) {
		postRpc.put("method", "sc_listinvoice");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(label);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_listinvoice
	public String sc_listinvoice() {
		postRpc.put("method", "sc_listinvoice");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成超导网络地址
	 * @return
	 */
	public String sc_newaddr() {
		postRpc.put("method", "sc_newaddr");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 超导网
	 * 支付
	 * @param route_id 路径ID sc_getroute产生的ID
	 * @param satoshi 金额  sc_getroute产生的satoshi
	 * @param delay 延时  sc_getroute产生的delay
	 * @param rhash 生成账单 sc_invoice 产生的rhash
	 * @param message 备注
	 * @return
	 */
	public String sc_sendpay(String route_id, int satoshi, int delay, String rhash, String message) {
		postRpc.put("method", "sc_sendpay");
		JSONArray arrayNode = new JSONArray();
		JSONArray arraypara1 = new JSONArray();
		JSONObject json_of_para1 = new JSONObject();
		json_of_para1.put("id", route_id);
		json_of_para1.put("satoshi", satoshi);
		json_of_para1.put("delay", delay);
		arraypara1.add(json_of_para1);

		arrayNode.add(arraypara1);
		arrayNode.add(rhash);
		arrayNode.add(message);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_sendpay "route_id" "satoshi" "delay" "rhash"
	public String sc_sendpay(String route_id, int satoshi, int delay, String rhash) {
		return sc_sendpay(route_id, satoshi, delay, rhash, "");
	}

	// sc_waitanyinvoice "lastlabel"
	public String sc_waitanyinvoice(String lastlabel) {
		postRpc.put("method", "sc_waitanyinvoice");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(lastlabel);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// sc_waitinvoice "label"
	public String sc_waitinvoice(String label) {
		postRpc.put("method", "sc_waitinvoice");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(label);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
   
	public String RegisterAssetByUnit(String fromAddress, String toAddress, int amount, String docHash,
			String feeAddress, double price, String type, String status) {
		postRpc.put("method", "registerassetbyunit");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(fromAddress);
		arrayNode.add(toAddress);
		arrayNode.add(amount);
		arrayNode.add(docHash);
		arrayNode.add(feeAddress);
		arrayNode.add(feeAddress);
		arrayNode.add(fromAddress);
		arrayNode.add(price);
		arrayNode.add(type);
		arrayNode.add(status);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	 /**
     * 合同hash值上链
     * 合同数据生成的hash值，通过一笔交易上链
     * @param fromAddress 
     * @param toAddress
     * @param amount
     * @param docHash 合同数据生成的hash值
     * @param feeAddress 手续费地址，即ABC地址
     * @return
     */
	public String RegisterAssetByUnit(String fromAddress, String toAddress, int amount, String docHash,
			String feeAddress) {
		postRpc.put("method", "registerassetbyunit");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(fromAddress);
		arrayNode.add(toAddress);
		arrayNode.add(amount);
		arrayNode.add(docHash);
		arrayNode.add(feeAddress);
		arrayNode.add(feeAddress);
		arrayNode.add(fromAddress);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String SendAssetToAddressByUnit(String fromAddress, String toAddress, int amount, String feeAddress) {
		postRpc.put("method", "sendassettoaddressbyunit");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(fromAddress);
		arrayNode.add(toAddress);
		arrayNode.add(amount);
		arrayNode.add(feeAddress);
		arrayNode.add(feeAddress);
		arrayNode.add(fromAddress);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String SendData(String fromAddress, String toAddress, int amount, String data, String feeAddress,
			String cashFeeAddress, String cashAssetAddress) {
		postRpc.put("method", "senddata");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(fromAddress);
		arrayNode.add(toAddress);
		arrayNode.add(amount);
		arrayNode.add(data);
		arrayNode.add(feeAddress);
		arrayNode.add(cashFeeAddress);
		arrayNode.add(cashAssetAddress);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String ListAssets() {
		JSONObject postRpc = new JSONObject();
		JSONArray arrayNode = new JSONArray();
		postRpc.put("method", "listassets");
		postRpc.put("params", arrayNode);
		String strParams;
		try {

			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetBalance() {
		postRpc.put("method", "getbalance");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetBalance(String account) {
		postRpc.put("method", "getbalance");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(account);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetAssetBalance(String symbol, String account) {
		postRpc.put("method", "getassetbalance");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(symbol);
		arrayNode.add(account);
		postRpc.put("params", arrayNode);
		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetAddressesByAccount(String account, boolean withPrivkey) {
		postRpc.put("method", "getaddressesbyaccount");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(account);
		arrayNode.add(withPrivkey);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetAddressesByAccount(String account) {
		postRpc.put("method", "getaddressesbyaccount");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(account);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 新建用户地址
	 * 
	 * @param symbol
	 *            币名称
	 * @param account
	 *            地址别名
	 * @return
	 */
	public String GetNewAddress(String symbol, String account) {
		postRpc.put("method", "getnewaddress");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(symbol);
		arrayNode.add(account);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetBlockCount() {
		postRpc.put("method", "getblockcount");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetBlock(String hash) {
		postRpc.put("method", "getblock");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(hash);
		postRpc.put("params", arrayNode);
		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetRawTransaction(String txid, int isDecode) {
		postRpc.put("method", "getrawtransaction");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(txid);
		arrayNode.add(isDecode);
		postRpc.put("params", arrayNode);

		try {
			String strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String CreateRawTransaction(String txid, int n, Map<String, Double> toAddress) {
		JSONObject objectNode = new JSONObject();
		for (Map.Entry<String, Double> entry : toAddress.entrySet()) {
			objectNode.put(entry.getKey(), entry.getValue());
		}
		// String strParams;
		// postRpc.put("method", "createrawtransaction");
		// JSONArray arrayNode = new JSONArray();
		// arrayNode.add(fromAddress);
		// try {
		// strParams = postRpc.toJSONString();
		// return HttpPost(strParams);
		// }catch (IOException e) {
		// e.printStackTrace();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		return null;
	}

	public String ListAccounts() {
		postRpc.put("method", "listaccounts");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String ListAddressGroupings() {
		postRpc.put("method", "listaddressgroupings");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String ListAddressGroupings(String symbol) {
		postRpc.put("method", "listaddressgroupings");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(symbol);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String ListTransactions() {
		postRpc.put("method", "listtransactions");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String ListTransactions(String txid) {
		postRpc.put("method", "listtransactions");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(txid);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String Stop() {
		postRpc.put("method", "stop");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String AddNode(String node, NodeAction action) {
		postRpc.put("method", "addnode");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(node);
		arrayNode.add(action.toString());
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String SendMany(String fromAddress, Map<String, Double> toAddress, String feeAddress) {
		JSONObject objectNode = new JSONObject();
		for (Map.Entry<String, Double> entry : toAddress.entrySet()) {
			objectNode.put(entry.getKey(), entry.getValue());
		}
		String strParams;
		postRpc.put("method", "sendmany");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(fromAddress);
		arrayNode.add(objectNode);
		arrayNode.add(feeAddress);
		arrayNode.add(feeAddress);
		arrayNode.add(fromAddress);
		postRpc.put("params", arrayNode);
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
/**
 * 打币
 * @param fromAddress  付款地址
 * @param toAddress    首款地址
 * @param amount       金额，单位是比特币
 * @param feeaddress   付手续费地址
 * @param cashFeeAddress 找零钱的地址
 * @return
 */
//	public String SendAssettoAddress(String fromAddress, String toAddress, double amount, String feeaddress,
//			String cashFeeAddress) {
//		postRpc.put("method", "sendassettoaddress");
//		JSONArray arrayNode = new JSONArray();
//		arrayNode.add(fromAddress);
//		arrayNode.add(toAddress);
//		arrayNode.add(amount);
//		arrayNode.add(feeaddress);
//		arrayNode.add(cashFeeAddress);
//		postRpc.put("params", arrayNode);
//		String strParams;
//		try {
//			strParams = postRpc.toJSONString();
//			return HttpPost(strParams);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	/**
	 * 精简过打币接口
	 * @param fromAddress 付款地址 GFB地址
	 * @param toAddress   收款地址 GFB地址
	 * @param amount      金额，单位是比特币 BTC
	 * @param feeaddress  手续费找零的地址 ABC地址
	 * @return
	 */
	public String SendAssettoAddressTool(String fromAddress, String toAddress, double amount, String feeaddress){
		return  SendAssettoAddress(fromAddress,toAddress,amount,feeaddress,feeaddress,fromAddress);
	}
/**
 * 打币
 * @param fromAddress 付款地址 GFB地址
 * @param toAddress   收款地址 GFB地址
 * @param amount      金额，单位是比特币 BTC
 * @param feeaddress  付手续费地址 ABC地址
 * @param feechangeaddress 手续费找零的地址 ABC地址
 * @param assetchangeaddress 找零地址 GFB地址
 * @return
 */
	public String SendAssettoAddress(String fromAddress, String toAddress, double amount, String feeaddress,
			String feechangeaddress, String assetchangeaddress) {
		postRpc.put("method", "sendassettoaddress");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(fromAddress);
		arrayNode.add(toAddress);
		arrayNode.add(amount);
		arrayNode.add(feeaddress);
		arrayNode.add(feechangeaddress);
		arrayNode.add(assetchangeaddress);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetDifficulty() {
		postRpc.put("method", "getdifficulty");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetMiningInfo() {
		postRpc.put("method", "getmininginfo");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetCFOSInfo() {
		postRpc.put("method", "getcfosinfo");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetRawMemPool() {
		postRpc.put("method", "getrawmempool");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String RepairWallet(boolean isFix) {
		postRpc.put("method", "repairwallet");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(isFix);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetReceivedByAccount(String account) {
		postRpc.put("method", "getreceivedbyaccount");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(account);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetReceivedByAddress(String bitcoinAddress) {
		postRpc.put("method", "getreceivedbyaddress");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(bitcoinAddress);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String Help() {
		postRpc.put("method", "help");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String ListReceivedByAccount() {
		postRpc.put("method", "listreceivedbyaccount");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String ListReceivedByAddress() {
		postRpc.put("method", "listreceivedbyaddress");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String ListSinceBlock() {
		postRpc.put("method", "listsinceblock");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String ListLockUnspent() {
		postRpc.put("method", "listlockunspent");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetGENBalance(String account) {
		postRpc.put("method", "getgenbalance");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(account);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String SetTxFee(float amount) {
		postRpc.put("method", "settxfee");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(amount);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String ValidateAddress(String bitcoinAddress) {
		postRpc.put("method", "validateaddress");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(bitcoinAddress);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String SetGenerate(boolean variable) {
		postRpc.put("method", "setgenerate");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(variable);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String SetAccount(String bitcoinAddress, String account) {
		postRpc.put("method", "setaccount");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(bitcoinAddress);
		arrayNode.add(account);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//
	public String AddMulTiSigAddress(int signNum, List<String> pubKeyList) {
		// JSONObject objectNode = new JSONObject();
		postRpc.put("method", "addmultisigaddress");
		// for(int i = 0; i < pubKeyList.size(); ++i){
		// objectNode.put(key, value)(pubKeyList.get(i));
		// objectNode.
		// }
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(signNum);
		arrayNode.add(pubKeyList);
		// arrayNode.add(objectNode);
		// arrayNode.add(feeAddress);
		// arrayNode.add(feeAddress);
		// arrayNode.add(fromAddress);
		// for(int i = 0; i < pubKeyList.size(); ++i)
		// arrayNode.add(pubKeyList.get(i));
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String SendRawTransaction(String rawTrans) {
		postRpc.put("method", "sendrawtransaction");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(rawTrans);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetAddedNodeInfo(String dns) {
		postRpc.put("method", "getaddednodeinfo");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(dns);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetTxOut(String txId, int n) {
		postRpc.put("method", "gettxout");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(txId);
		arrayNode.add(n);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetTxOutSetInfo() {
		postRpc.put("method", "gettxoutsetinfo");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String GetTransaction(String txid) {
		postRpc.put("method", "gettransaction");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(txid);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String KeyPoolRefill() {
		postRpc.put("method", "keypoolrefill");
		JSONArray arrayNode = new JSONArray();
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String SendFrom(String fromAccount, String toBitcoinAddress, BigDecimal amount) {
		postRpc.put("method", "sendfrom");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(fromAccount);
		arrayNode.add(toBitcoinAddress);
		arrayNode.add(amount);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String SignMessage(String bitcoinAddress, String message) {
		postRpc.put("method", "signmessage");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(bitcoinAddress);
		arrayNode.add(message);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String SubmitBlock(String hexData) {
		postRpc.put("method", "submitblock");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(hexData);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String VerifyMessage(String bitcoinAddress, String signature, String message) {
		postRpc.put("method", "verifymessage");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(bitcoinAddress);
		arrayNode.add(signature);
		arrayNode.add(message);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String Move(String fromAccount, String toAccount, float amount) {
		postRpc.put("method", "move");
		JSONArray arrayNode = new JSONArray();
		arrayNode.add(fromAccount);
		arrayNode.add(toAccount);
		arrayNode.add(amount);
		postRpc.put("params", arrayNode);
		String strParams;
		try {
			strParams = postRpc.toJSONString();
			return HttpPost(strParams);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//
	//
	// public void InitConnecter() throws IOException{
	// ReadConfig(configFilePath);
	//
	// }
	//
	// private JsonNode jsonConvert(String metaJson) throws
	// JsonProcessingException, IOException{
	// System.out.println(metaJson);
	// ObjectMapper mapperTemp = new ObjectMapper();
	// return mapperTemp.readTree(metaJson).path("result");
	// }

	// private void ReadConfig(String strFilePath) throws IOException{
	// System.out.println("strFilePath:" + strFilePath);
	// Properties pp = new Properties();
	// FileInputStream fis = new FileInputStream(strFilePath);
	// pp.load(fis);
	// this.rpcuser = pp.getProperty("rpcuser");
	// this.rpcpassword = pp.getProperty("rpcpassword");
	// }

	private String HttpPost(String strParams) throws Exception {
		URL localURL = new URL(this.url);
		URLConnection connection = openConnection(localURL);
		HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setRequestMethod(this.requestMethod);
		httpURLConnection.setRequestProperty("Accept-Charset", charset);
		httpURLConnection.setRequestProperty("Content-Type", "application/json-rpc");

		String input = rpcuser + ":" + rpcpassword;
		String encoding = new String(Base64.encode(input.getBytes()));
		httpURLConnection.setRequestProperty("Authorization", "Basic " + encoding);
		httpURLConnection.setRequestProperty("Content-Length", String.valueOf(strParams.length()));

		OutputStream outputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;

		try {
			outputStream = httpURLConnection.getOutputStream();
			outputStreamWriter = new OutputStreamWriter(outputStream);
			outputStreamWriter.write(strParams);
			outputStreamWriter.flush();

			if (httpURLConnection.getResponseCode() >= 300) {
				throw new Exception(
						"HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
			}

			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			reader = new BufferedReader(inputStreamReader);

			while ((tempLine = reader.readLine()) != null) {
				resultBuffer.append(tempLine);
			}

		} finally {

			if (outputStreamWriter != null) {
				outputStreamWriter.close();
			}

			if (outputStream != null) {
				outputStream.close();
			}

			if (reader != null) {
				reader.close();
			}

			if (inputStreamReader != null) {
				inputStreamReader.close();
			}

			if (inputStream != null) {
				inputStream.close();
			}

			if (httpURLConnection != null) {
				httpURLConnection.disconnect();
				httpURLConnection = null;
			}

		}

		return resultBuffer.toString();

	}

	// private String doGet() throws Exception {
	//
	// URL localURL = new URL(url);
	//
	// URLConnection connection = openConnection(localURL);
	// HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
	//
	// httpURLConnection.setRequestProperty("Accept-Charset", charset);
	// httpURLConnection.setRequestProperty("Content-Type",
	// "application/x-www-form-urlencoded");
	//
	// InputStream inputStream = null;
	// InputStreamReader inputStreamReader = null;
	// BufferedReader reader = null;
	// StringBuffer resultBuffer = new StringBuffer();
	// String tempLine = null;
	//
	// if (httpURLConnection.getResponseCode() >= 300) {
	// throw new Exception("HTTP Request is not success, Response code is " +
	// httpURLConnection.getResponseCode());
	// }
	//
	// try {
	// inputStream = httpURLConnection.getInputStream();
	// inputStreamReader = new InputStreamReader(inputStream);
	// reader = new BufferedReader(inputStreamReader);
	//
	// while ((tempLine = reader.readLine()) != null) {
	// resultBuffer.append(tempLine);
	// }
	//
	// } finally {
	//
	// if (reader != null) {
	// reader.close();
	// }
	//
	// if (inputStreamReader != null) {
	// inputStreamReader.close();
	// }
	//
	// if (inputStream != null) {
	// inputStream.close();
	// }
	//
	// }
	//
	// return resultBuffer.toString();
	// }

	private URLConnection openConnection(URL localURL) throws IOException {
		URLConnection connection;
		if (proxyHost != null && proxyPort != null) {
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
			connection = localURL.openConnection(proxy);
		} else {
			connection = localURL.openConnection();
		}
		return connection;
	}

	/*
	 * Getter & Setter
	 */
	public Integer getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(Integer connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public Integer getSocketTimeout() {
		return socketTimeout;
	}

	public void setSocketTimeout(Integer socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public Integer getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(Integer proxyPort) {
		this.proxyPort = proxyPort;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

}
