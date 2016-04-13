package com.conference.restful.api.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import com.conference.dataprovider.domain.User;

public class UserDto {
	@NotBlank private String username;
	@NotBlank @Min(6) private String password;
	@NotNull @Email private String email;
	@NotBlank private String firstname;
	@NotBlank private String lastname;
	
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
