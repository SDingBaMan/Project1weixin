package com.sdingba.util;

import java.security.MessageDigest;
import java.util.Arrays;

public class SignUtil {

	// 与接口 配置 信息的中 的 Token 要一致
	private static String token = "Alphabet";

	/**
	 * 验证签名
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature, String timestamp,
										 String nonce) {
		String[] arr = new String[] { token, timestamp, nonce };
		// 将token timestamp nonce 三个参数进行字典排序
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接一个  字符串  进行sha1加密
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = byteToStr(digest);

		} catch (Exception e) {
			e.printStackTrace();
		}
		content = null;
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;

	}

	/**
	 * 字节数组 将 字节数组 转化为 16 进制字符串
	 *
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}

		return strDigest;

	}

	/**
	 * 字节 将字节转化为 16 进制字符串
	 *
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];
		String s = new String(tempArr);

		return s;
	}
}
