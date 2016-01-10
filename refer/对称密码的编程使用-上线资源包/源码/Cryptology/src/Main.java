import java.io.IOException;


public class Main {

	//�����ܵ�����
	public static final String DATA = "jikexueyuan";
	public static final String PATH = "mysql-installer-web-community-5.6.22.0.msi";
	
	
	public static void main(String[] args) throws Exception {
		/* Test Base64 */
		String base64Result = Base64Util.encryptBase64(DATA.getBytes());
		System.out.println(DATA + "  >>>Base64����>>>" + base64Result);
		String base64String = Base64Util.decryptBase64(base64Result);
		System.out.println(base64Result + "  >>>Base64����>>>" + base64String);
		
		
		/* Test MD5 */
		String md5Result = MessageDigestUtil.encryptMD5(DATA.getBytes());
		System.out.println(DATA + ">>>MD5>>>" + md5Result);
		
		/* Test MD5 of File */
		String fileMD5Result = MessageDigestUtil.getMD5OfFile(PATH);
		System.out.println("File MD5 : " + fileMD5Result);
		
		/* Test SHA */
		String shaResult = MessageDigestUtil.encryptSHA(DATA.getBytes());
		System.out.println(DATA + ">>>SHA>>>" + shaResult);
		
		/* Test HMAC */
		byte[] hmacKey = MessageDigestUtil.initHmacKey();
		System.out.println("HMAC KEY: " + BytesToHex.fromBytesToHex(hmacKey));
		String hmacResult = MessageDigestUtil.encryptHmac(DATA.getBytes(), hmacKey);
		System.out.println(DATA + ">>>HMAC>>>" + hmacResult);
		
		/* Test DES */
		byte[] desKey = DESUtil.initKey();
		System.out.println("DES KEY : " + BytesToHex.fromBytesToHex(desKey));
		byte[] desResult = DESUtil.encrypt(DATA.getBytes(), desKey);
		System.out.println(DATA + ">>>DES ����>>>" + BytesToHex.fromBytesToHex(desResult));
		
		byte[] desPlain = DESUtil.decrypt(desResult, desKey);
		System.out.println(DATA + ">>>DES ����>>>" + new String(desPlain));
		
		
		/* Test 3DES */
		byte[] tridesKey = TripleDESUtil.initKey();
		System.out.println("3DES KEY : " + BytesToHex.fromBytesToHex(tridesKey));
		byte[] tridesResult = TripleDESUtil.encrypt(DATA.getBytes(), tridesKey);
		System.out.println(DATA + ">>>3DES ����>>>" + BytesToHex.fromBytesToHex(tridesResult));
		
		byte[] tridesPlain = TripleDESUtil.decrypt(tridesResult, tridesKey);
		System.out.println(DATA + ">>>3DES ����>>>" + new String(tridesPlain));
		
		
		/* Test AES */
		byte[] aesKey = AESUtil.initKey();
		System.out.println("AES KEY : " + BytesToHex.fromBytesToHex(aesKey));
		byte[] aesResult = AESUtil.encrypt(DATA.getBytes(), aesKey);
		System.out.println(DATA + ">>>AES ����>>>" + BytesToHex.fromBytesToHex(aesResult));
		
		byte[] aesPlain = AESUtil.decrypt(aesResult, aesKey);
		System.out.println(DATA + ">>>AES ����>>>" + new String(aesPlain));
		
		
		
		
	}

}
