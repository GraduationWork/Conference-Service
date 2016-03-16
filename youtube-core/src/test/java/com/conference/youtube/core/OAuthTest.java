package com.conference.youtube.core;

import java.io.IOException;

import org.junit.Test;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;

public class OAuthTest {

	@Test
	public void generateOAuthTokenTest() {

	}

	public static HttpResponse executeGet(HttpTransport transport,
			JsonFactory jsonFactory, String accessToken, GenericUrl url)
			throws IOException {
		Credential credential = new Credential(
				BearerToken.authorizationHeaderAccessMethod())
				.setAccessToken(accessToken);
		HttpRequestFactory requestFactory = transport
				.createRequestFactory(credential);
		return requestFactory.buildGetRequest(url).execute();
	}

}
