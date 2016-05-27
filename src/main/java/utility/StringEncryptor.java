package utility;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

public class StringEncryptor {
	public static final String HASHALGO = "PBKDF2WithHmacSHA512";
	public static final int KEYLENGTH = 256;
	public static final int ITERCOUNT = 65536;
	
	public static String encryptString(final String plainText, final String salt){
		return encryptString(plainText.toCharArray(), salt.getBytes());
	}

	public static String encryptString(final char[] plainText, final byte[] salt) {
		byte[] encryptedPassword = null;

		try {
			SecretKeyFactory skfactory = SecretKeyFactory.getInstance(HASHALGO);
			PBEKeySpec pbspec = new PBEKeySpec(plainText, salt, ITERCOUNT, KEYLENGTH);
			SecretKey key = skfactory.generateSecret(pbspec);

			encryptedPassword = key.getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}

		return DatatypeConverter.printBase64Binary(encryptedPassword);
	}
}
