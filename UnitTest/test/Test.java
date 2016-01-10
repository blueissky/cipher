package test;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

import com.AxelRsa.AxelRsa;
import com.axel.aes.AxelAes;

public class Test {
	public static void main(String[] args) throws Exception{
		String Node=new String("段铭浩".getBytes("utf-8"),"utf-8");
		
//		DES测试
//		AxelAes aes = new AxelAes();
//		byte[] key = aes.initKey();
//		byte[] a = aes.encrypt(Node.getBytes(), key);
//		byte[] b = aes.decrypt(a, key);
//		System.out.println(new String(a));
//		System.out.println(new String(b));
		
//		RSA测试
		AxelRsa rsa = new AxelRsa();
		Map<String, Object> key = rsa.initKey();
		RSAPrivateKey privateKey = rsa.getPrivateKey(key);
		RSAPublicKey publicKey = rsa.getPublicKey(key);
		byte[] enc = rsa.encrypt(Node.getBytes(), publicKey);//加密
		byte[] dec = rsa.decrypt(enc, privateKey);
		System.out.println(new String(enc));
		System.out.println(new String(dec));
	}
}
