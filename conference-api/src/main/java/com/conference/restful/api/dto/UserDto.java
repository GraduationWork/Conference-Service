package com.conference.restful.api.dto;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.conference.dataprovider.domain.User;

public class UserDto {
	@NotNull
	private String username;
	@NotNull
	private String password;
	
	public UserDto() {}
	public UserDto(User user) {
		BeanUtils.copyProperties(user, this);
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
