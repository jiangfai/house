package com.qfedu.house.dto;

import javax.validation.Valid;

import com.qfedu.house.domain.User;

public class UserDTO {
	@Valid
	private User user;
	private String code;
	private String ipAddress;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}