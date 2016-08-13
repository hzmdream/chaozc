package com.czc.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignUtil {

	//与开发模式接口配置信息中的Token保持一致
	private static String token = "fangcunzhijian";
	/**
	 * 校验签名
	 */
	public static boolean checkSignature(String signature,String timestamp,String nonce,String echostr){
		//对token,timestamp,nonce进行字典排序
		String [] paramArr = new String[]{token,timestamp,nonce};
		Arrays.sort(paramArr);
		
		//将排序后的结果拼接成一个字符串
		String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);
		
		//对拼接后的字符串进行sha1加密
		String ciphertext = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte [] digest = md.digest(content.getBytes());
			ciphertext = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ciphertext!=null?ciphertext.equals(signature.toUpperCase()):false;
	}
	
	private static String byteToStr(byte [] bytearray){
		String strDigest = "";
		for (int i = 0; i < bytearray.length; i++) {
			strDigest += byteToHexStr(bytearray[i]);
		}
		return strDigest;
	}
	
	/**
	 * 将字节转换为十六进制字符串
	 * @param ib
	 * @return
	 */
	private static String byteToHexStr(byte ib){
		char [] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char [] ob = new char[2];
		ob[0] = Digit[(ib>>>4)&0X0F];
		ob[1] = Digit[ib & 0X0F];
		String s  = new String(ob);
		return s;
	}
}
