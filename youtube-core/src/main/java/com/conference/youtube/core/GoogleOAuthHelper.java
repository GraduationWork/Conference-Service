package com.conference.youtube.core;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.common.base.Joiner;

public class GoogleOAuthHelper {

	public static final String OAUTH_API = "https://accounts.google.com/o/oauth2/auth?client_id=698605801531-furmbme5fbdrt3njt95rrgrn4ed59vc0.apps.googleusercontent.com&redirect_uri=http://localhost:8083/conference-api/oauth2callback&scope=https://www.googleapis.com/auth/youtube https://www.googleapis.com/auth/youtube.force-ssl&response_type=code&access_type=offline";
	private static final String GOOGLE_OAUTH_API = "https://accounts.google.com/o/oauth2/auth?client_id=%s&redirect_uri=%s&scope=%s&response_type=code&access_type=offline";
	
	public void authenticate(String clientId, String redirectUrl, List<String> scopes, Map<String, String> headers) throws ClientProtocolException, IOException {
		Validate.notBlank(clientId);
		Validate.notBlank(redirectUrl);
		Validate.notEmpty(scopes);
		HttpClient client = HttpClientBuilder.create().build();
		String url = String.format(GOOGLE_OAUTH_API, clientId, redirectUrl, Joiner.on(" ").join(scopes));
		HttpGet request = new HttpGet(url);
		for (Map.Entry<String, String> entry : headers.entrySet()) {
			request.addHeader(entry.getKey(), entry.getValue());
		}
		HttpResponse response = client.execute(request);
		if (response.getStatusLine().getStatusCode() >= 400 ) {
			throw new RuntimeException("NotSuccessResponseCode");
		}
	}
	
	
}
