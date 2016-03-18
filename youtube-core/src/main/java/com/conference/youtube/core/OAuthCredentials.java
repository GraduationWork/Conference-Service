package com.conference.youtube.core;

import com.google.api.client.auth.oauth2.Credential;

public class OAuthCredentials extends Credential{

	protected OAuthCredentials(Builder builder) {
		super(builder);
	}

}
