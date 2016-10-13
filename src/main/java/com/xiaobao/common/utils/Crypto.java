package com.xiaobao.common.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class Crypto {

	/**
	 * 进行加密
	 * 
	 * @param message
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String desEncrypt(String message, String key)
			throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

		byte[] b = cipher.doFinal(message.getBytes("UTF-8"));
		/*
		 * for(int i=0;i<b.length;i++){ System.out.println(b[i]); }
		 */
		BASE64Encoder base64encoder = new BASE64Encoder();
		String encryptStr = base64encoder.encode(b);
		return encryptStr;

	}

	/**
	 * 进行解密
	 * 
	 * @param message
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String desDecrypt(String message, String key)
			throws Exception {
		BASE64Decoder base64decoder = new BASE64Decoder();
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
		byte[] b = cipher.doFinal(base64decoder.decodeBuffer(message));
		String returnData = new String(b, "UTF-8");
		return returnData;
	}

	public static String md5Digest(String str) {
		str = Objects.toString(str, "");
		if (!str.equals("")) {
			try {
				//确定计算方法
		        MessageDigest md5= MessageDigest.getInstance("MD5");
		        BASE64Encoder base64en = new BASE64Encoder();
		        //加密后的字符串
		        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
		        return newstr;
			} catch (Exception e) {
				e.printStackTrace();
				return str; 
			}
		}
		return "";
	}

	/**
	 * 单元测试方法
	 * 
	 * @param args
	 * @throws Exception 
	 * @throws IOException 
	 */
//	public static void main(String[] args) {
//		try {
//
//			long t = System.currentTimeMillis();
//			String key = "uSLE@k6v";
//			String original = "kfcio";
//			System.out.println("***** 加密测试 *****");
//			String encryptStr = Crypto.desEncrypt(original, key);
//			System.out.println(encryptStr);
//			System.out.println("***** 解密测试 *****");
//			String decryptStr = Crypto.desDecrypt(encryptStr, key);
//			System.out.println(decryptStr);
//			System.out.println(original.hashCode() == decryptStr.hashCode());
//			System.out.println(System.currentTimeMillis() - t);
//			System.out.println(md5Digest("password"));
//			System.out.println("1010".charAt(0)=='1');
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
	public static void main(String[] args) throws IOException, Exception {
//		String key = "uSLE@k6v";
		String key = "uEUI&@k6";
//		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("输入用户名:");
//		System.out.println((Crypto.desEncrypt(reader.readLine().trim(), key)));
//		System.out.println("输入密码:");
//		System.out.println((Crypto.desEncrypt(reader.readLine().trim(), key)));
		//System.out.println(Crypto.desDecrypt("278bec45976716b5", key));
//		System.out.println("输入用户名:");
//		System.out.println(Crypto.desEncrypt("dgwf_user", key));
//		System.out.println("输入密码:");
//		System.out.println(Crypto.desEncrypt("Dgaotech", key));
//		System.out.println(Crypto.desEncrypt("dg_test", key));
		//System.out.println(desDecrypt("1FgTWTKJ6bZpeeKZRmi9Qg==", key));
		//System.out.println(desDecrypt("+h0nu6fjZirUedx5MD7TZg==", key));
		System.out.println(Crypto.desEncrypt("123456", key));
	}
}
