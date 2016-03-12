package com.conference.restful.api;

import static org.junit.Assert.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTSigner.Options;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.auth0.jwt.internal.org.apache.commons.codec.binary.Base64;

public class JWTComposerTest {
	
	private static final String SECRET = "123";
	
	private static JWTSigner signer = new JWTSigner(SECRET);
	
	/*
	 * https://github.com/auth0/java-jwt/blob/master/src/test/java/com/auth0/jwt/JWTVerifierTest.java
	 * */
	
	@Test
	public void composeTokenTest() throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, SignatureException, IOException, JWTVerifyException {
//		Options options = new JWTSigner.Options()
//        	.setExpirySeconds(1000)
//        	.setNotValidBeforeLeeway(5)
//        	.setIssuedAt(true)
//        	.setJwtId(true);
//		
//		
//		
//		String token = signer.sign(null, options);
		
		JWTVerifier jwtVerifier = new JWTVerifier(new Base64(true).decode("YOUR_CLIENT_SECRET"),"YOUR_CLIENT_ID");
		
		
		HashMap<String, Object> claims = new HashMap<String, Object>();
	     String token = signer.sign(claims);
	     System.out.print(token);
	     
	     Base64 decoder = new Base64(true);
         byte[] secret = decoder.decodeBase64(SECRET);
         Map<String,Object> decodedPayload =
             new JWTVerifier(secret).verify(token);

         // Get custom fields from decoded Payload
         System.out.println(decodedPayload.get("name"));
         
	}
	
}
