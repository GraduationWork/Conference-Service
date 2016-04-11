package com.conference.restful.api.auth.domain;

import org.apache.commons.lang3.Validate;
import org.springframework.security.core.GrantedAuthority;

import com.conference.dataprovider.domain.Role;

public class UserGrantedAuthority implements GrantedAuthority{

	private static final long serialVersionUID = -8258052975520252264L;
	
	private String authority;
	
	public UserGrantedAuthority(Role role) {
		Validate.notNull(role);
		this.authority = role.name();
	}
	public UserGrantedAuthority(String role) {
		Validate.notEmpty(role);
		this.authority = role;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

}
