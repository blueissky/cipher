package com.axel.aes;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AxelAes {
	/**
	 * 生成秘钥
	 */
	public static byte[] initKey() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		keyGen.init(56);
		SecretKey secreKey = keyGen.generateKey();
		return secreKey.getEncoded();
	}
	/**
	 * 加密
	 */
	public static byte[] encrypt(byte[] data,byte[] key) throws Exception{
		SecretKeySpec secretKey = new SecretKeySpec(key,"DES");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE,secretKey);
		byte[] cipherBytes = cipher.doFinal(data);
		return cipherBytes;
	}
	/**
	 * 解密
	 */
	public static byte[] decrypt(byte[] data,byte[] key) throws Exception{
		SecretKeySpec secretKey = new SecretKeySpec(key,"DES");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE,secretKey);
		byte[] cipherBytes = cipher.doFinal(data);
		return cipherBytes;
	}
	
	
}
