package utility;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class StringEncryptor {
	public static final String HASHALGO = "HmacSHA512";
	
	public static String encryptString(final String plainText, final String salt){
		return encryptString(plainText.getBytes(), salt.getBytes());
	}

	public static String encryptString(final byte[] plainText, final byte[] salt) {
		try{
			SecretKeySpec skspec = new SecretKeySpec(salt, HASHALGO);
			
			Mac mac = Mac.getInstance(HASHALGO);
			
			mac.init(skspec);
			
			byte[] encryptedPassword = mac.doFinal(plainText);
			return DatatypeConverter.printBase64Binary(encryptedPassword);
		}catch(NoSuchAlgorithmException | InvalidKeyException e){
			throw new RuntimeException(e);
		}
	}
}
