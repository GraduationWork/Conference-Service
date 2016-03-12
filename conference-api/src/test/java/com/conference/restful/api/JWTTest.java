package com.conference.restful.api;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;

import org.junit.Test;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.auth0.jwt.internal.org.apache.commons.codec.binary.Base64;

public class JWTTest {

	@Test
	public void verifyTokenTest() throws InvalidKeyException, NoSuchAlgorithmException, IOException, JWTVerifyException {
		try {
            Base64 decoder = new Base64(true);
            byte[] secret = decoder.decodeBase64("123");
            Map<String,Object> decodedPayload =
                new JWTVerifier(secret).verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.e30.KY2gjBzd-ORMMT97OsEkx-Uw6IzKHdU5knMjgULdnAk");

            // Get custom fields from decoded Payload
            System.out.println(decodedPayload.get("name"));
        } catch (SignatureException signatureException) {
            System.err.println("Invalid signature!");
        } catch (IllegalStateException illegalStateException) {
            System.err.println("Invalid Token! " + illegalStateException);
        }
	}
	
}
