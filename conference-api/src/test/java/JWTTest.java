import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.conference.core.domain.User;


public class JWTTest {

	public static final String SECRET = "SECRET";
	
	@Test
	public void test() throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, SignatureException, IOException, JWTVerifyException {
		JWTSigner jwtSigner = new JWTSigner(SECRET);

		
		Map<String, Object> claims = new HashMap<String, Object>();
		User user = new User();
		user.setUsername("Aliaksandr_Kassirau");
		user.setPassword("0");
		claims.put("user", user);
		String token = jwtSigner.sign(claims);
		
		
		JWTVerifier jwtVerifier = new JWTVerifier(SECRET);
		Map<String, Object> verifiedClaims = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7InVzZXJuYW1lIjoiQWxpYWtzYW5kcl9LYXNzaXJhdSIsInBhc3N3b3JkIjoiMCIsImNyZWF0ZWQiOm51bGwsInVwZGF0ZWQiOm51bGwsImFjdGl2ZSI6ZmFsc2V9fd.5n8evTG6jYXaeDI6uWdI8AaLc-GxIfXZtWzj2dD4_p8");
		
	}
	
}
