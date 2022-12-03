package tn.esprit.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Hex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenUtil {

	public static final String MAGIC_KEY = "IntelliTech";
	 
	public static String createToken(UserDetails userDetails) {
		long expires = System.currentTimeMillis() + 1000L * 60 * 60;
		return expires + ":" + computeSignature(userDetails, expires);
	}
 
	public static String computeSignature(UserDetails userDetails, long expires) {
		StringBuilder signatureBuilder = new StringBuilder();
		signatureBuilder.append(userDetails.getUsername()).append(":");
		signatureBuilder.append(expires).append(":");
		signatureBuilder.append(userDetails.getPassword()).append(":");
		signatureBuilder.append(TokenUtil.MAGIC_KEY);
 
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			log.error("No MD5 algorithm available!");
		}
		return new String(Hex.encode(digest.digest(signatureBuilder.toString().getBytes())));
	}
 
	public static String getUserNameFromToken(String authToken) {
		if (authToken == null) {
			return null;
		}
		String[] parts = authToken.split(":");
		return parts[0];
	}
 
	public static boolean validateToken(String authToken, UserDetails userDetails) {
		String[] parts = authToken.split(":");
		long expires = Long.parseLong(parts[1]);
		String signature = parts[2];
		String signatureToMatch = computeSignature(userDetails, expires);
		return expires >= System.currentTimeMillis() && signature.equals(signatureToMatch);
	}
}
