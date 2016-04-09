package com.conference.restful.api.auth.domain;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.conference.restful.api.auth.utils.AuthUtils;

public class AuthenticatedUser implements UserDetails{

	private String username;
	private String password;
	private boolean isActive;
	private List<GrantedAuthority> roles;
	
	@SuppressWarnings("unchecked")
	public AuthenticatedUser(Map<String,Object> claims) {
		Validate.notEmpty(claims);
		this.username = (String) claims.get("username");
		this.password = (String) claims.get("password");
		this.isActive = (boolean) claims.get("isActive");
		
		List<String> roles = (List<String>) claims.get("roles");
		this.roles = AuthUtils.convertRoles(roles);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isActive;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isActive;
	}

}
