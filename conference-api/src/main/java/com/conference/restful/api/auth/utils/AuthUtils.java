package com.conference.restful.api.auth.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.conference.restful.api.auth.domain.UserGrantedAuthority;

public class AuthUtils {

	public static List<GrantedAuthority> convertRoles(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(String role: roles) {
			authorities.add(new UserGrantedAuthority(role));
		}
		return authorities;
	}
	
}
