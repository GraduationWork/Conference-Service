package com.conference.restful.api.auth.domain;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.conference.core.domain.Roles;
import com.conference.core.domain.User;
import com.conference.restful.api.auth.utils.AuthUtils;

public class AuthenticatedUser implements UserDetails{

	private String username;
	private String password;
	private boolean isActive;
	private List<Roles> roles;
	
	public AuthenticatedUser(Map<String,Object> claims) {
		Validate.notEmpty(claims);
		this.username = (String) claims.get("username");
		this.password = (String) claims.get("password");
		this.isActive = (boolean) claims.get("isActive");
		this.roles = (List<Roles>) claims.get("roles");
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthUtils.convertRoles(user.getRoles());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.isActive();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isActive();
	}

}
