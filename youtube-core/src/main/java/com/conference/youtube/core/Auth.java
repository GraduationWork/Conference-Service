package com.conference.youtube.core;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

public class Auth {

	public static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	public static final JsonFactory JSON_FACTORY = new JacksonFactory();
	
	
	public Credential authorize(List<String> scopes) {
		Reader clientSecretReader = new InputStreamReader(Auth.class.getResourceAsStream("/client_secrets.json"));
		
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, scopes).setCredentialDataStore(datastore)
                .build();
		
        LocalServerReceiver localReceiver =
        		new LocalServerReceiver.Builder().setPort(8083).build();
        VerificationCodeReceiver receiver = new VerificationCodeReceiver() {
			
			@Override
			public String waitForCode() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void stop() throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public String getRedirectUri() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return new AuthorizationCodeInstalledApp(flow, receiver).authorize();
	}
	
}
