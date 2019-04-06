package com.dh.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
public class MD5Util {
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	private static MessageDigest digest = null;
	private static String key="my_pass";
	/**
	 * 加密
	 * @param message(需要加密的字段)
	 * @param key(密钥)
	 * @return
	 */
	public static String addKey(String message){
		try {
			byte[] bt=encrypt(message,hash(key).substring(0,8));
			return toHexString(bt);
		} catch (Exception e) {
			e.printStackTrace();
		}//加密
		return null;
	}
	
	/**
	 * 解密
	 * @param message(加密后的的字段)
	 * @param key(密钥)
	 * @return
	 */
	public static String removeKey(String message){
//		byte[] bt=message.getBytes();
		try {

			String value=decrypt(message,key,"UTF-8");
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String sha256(String base) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }
	        return hexString.toString();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	
	public synchronized static final String hash(String data) {
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException nsae) {
				System.err.println("Failed to load the MD5 MessageDigest. "
						+ "We will be unable to function normally.");
				nsae.printStackTrace();
			}
		}
		// Now, compute hash.
		digest.update(data.getBytes());
		return encodeHex(digest.digest());
	}
	public static String toHexString(byte b[]) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {   
			String plainText = Integer.toHexString(0xff & b[i]); 
			if (plainText.length() < 2)      
				plainText = "0" + plainText; 
			hexString.append(plainText); 
		}          
		return hexString.toString(); 
	}
	public static final String encodeHex(byte[] bytes) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		int i;

		for (i = 0; i < bytes.length; i++) {
			if (((int) bytes[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString((int) bytes[i] & 0xff, 16));
		}
		return buf.toString().toUpperCase();
	}
	public static String decrypt(String data,String key,String encode) throws Exception{
		byte[] bytesrc =convertHexString(data);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(hash(key).substring(0,8).getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(hash(key).substring(0,8).getBytes("UTF-8"));
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] retByte = cipher.doFinal(bytesrc); 
        return new String(retByte,encode); 
	}
	private static byte[] convertHexString(String data) {
		byte[] digest=new byte[data.length()/2];
		for(int i=0;i<digest.length;i++){
			String str=data.substring(2*i,2*i+2);
			int value=Integer.parseInt(str,16);
			digest[i]=(byte)value;
		}
		return digest;
	}
	public static byte[] encrypt(String message, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);    
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8")); 
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);   
		return cipher.doFinal(message.getBytes("UTF-8"));   
	} 
	public static String getPassword(String pw) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(pw.getBytes());
		byte[] b = md.digest();
		StringBuffer sb = new StringBuffer("");
		int temp = 0;
		for (int i = 0; i < b.length; i++) {
			temp = b[i];
			if(temp < 0) {
				temp += 256;
			}
			if(temp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toHexString(temp).toUpperCase());
		}
		return sb.toString();
	}
	
	public static String Md516(String str) {
		  String result = null;
		  try {
			   MessageDigest md = MessageDigest.getInstance("MD5");
			   md.update(str.getBytes());
			   byte b[] = md.digest();
			   int temp;
			   StringBuffer buf = new StringBuffer("");
			   for (int i = 0; i < b.length; i++) {
				   temp = b[i];
			    if (temp < 0)
			    	temp += 256;
			    if (temp < 16)
			     buf.append("0");
			     buf.append(Integer.toHexString(temp));
			   }
			   result = buf.toString().substring(8, 24);
		  } catch (NoSuchAlgorithmException e) {
			  e.printStackTrace();
		  }
		  	return result;
		}
	
	public static String getMD5(String str) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		byte[] b = md.digest();
		StringBuffer sb = new StringBuffer("");
		int temp = 0;
		
		 for (int offset = 0; offset < b.length; offset++) {
			 temp = b[offset];
		     if (temp < 0) {
		    	 temp += 256;
		     }
		     if (temp < 16) {
		    	 sb.append("0");
		     }
		     // 将整型 十进制 i 转换为16位，用十六进制参数表示的无符号整数值的字符串表示形式。
		     sb.append(Integer.toHexString(temp));
		    }
		return sb.toString();
	}
	
	public static byte[] getMD5String(String str){
	    byte [] MD5Message = null; 
		try {
			MD5Message =  MessageDigest.getInstance("MD5".toUpperCase()).digest(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return MD5Message;
	}
	
	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
}
