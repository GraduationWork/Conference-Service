package com.conference.restful.api.auth.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.conference.core.domain.Roles;
import com.conference.restful.api.auth.domain.UserGrantedAuthority;

public class AuthUtils {

	public static List<GrantedAuthority> convertRoles(List<Roles> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Roles role: roles) {
			authorities.add(new UserGrantedAuthority(role));
		}
		return authorities;
	}
	
}
