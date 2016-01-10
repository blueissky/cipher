package test;

import com.axel.aes.AxelAes;

public class Test {
	public static void main(String[] args) throws Exception{
		String Node=new String("段铭浩".getBytes("utf-8"),"utf-8");
		AxelAes aes = new AxelAes();
		byte[] key = aes.initKey();
		byte[] a = aes.encrypt(Node.getBytes(), key);
		byte[] b = aes.decrypt(a, key);
		System.out.println(new String(a));
		System.out.println(new String(b));
	}
}
