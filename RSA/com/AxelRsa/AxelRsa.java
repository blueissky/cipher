package com.AxelRsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

public class AxelRsa {
	public static final String PUBLIC_KEY = "RSAPublicKey";
	public static final String PRIVATE_KEY = "RSAPrivateKey";
	/**
	 * 生成RSA 的公钥和私钥
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> initKey() throws Exception {
		KeyPairGenerator keypairgenerater = KeyPairGenerator.getInstance("RSA");
		keypairgenerater.initialize(1024);
		KeyPair keyPair = keypairgenerater.generateKeyPair();
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();
		HashMap<String, Object> keyMap = new HashMap<String,Object>();
		keyMap.put(PRIVATE_KEY, privateKey);
		keyMap.put(PUBLIC_KEY, publicKey);
		return keyMap;
	}
	/**
	 * 获得公钥
	 * @param keyMap
	 * @return
	 */
	public static RSAPublicKey getPublicKey(Map<String, Object> keyMap){
		RSAPublicKey publicKey = (RSAPublicKey) keyMap.get(PUBLIC_KEY);
		return publicKey;
	}
	/**
	 * 获得私钥
	 * @param keyMap
	 * @return
	 */
	public static RSAPrivateKey getPrivateKey(Map<String, Object> keyMap){
		RSAPrivateKey privateKey = (RSAPrivateKey) keyMap.get(PRIVATE_KEY);
		return privateKey;
	}
	/**
	 * 公钥加密
	 * @param data
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, RSAPublicKey publicKey) throws Exception{
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE,publicKey);
		byte[] cipherBytes = cipher.doFinal(data);
		return cipherBytes;
	}
	/**
	 * 私钥解密
	 * @param data
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, RSAPrivateKey privateKey) throws Exception{
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] cipherBytes = cipher.doFinal(data);
		return cipherBytes;
	}
}

























