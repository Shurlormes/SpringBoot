package com.voidforce.spring.boot.bean;

public class UserRole {

	private Long userRoleId;

	private Long userInfoId;

	private String role;

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRoleMapper{" +
			"userRoleId=" + userRoleId +
			", userInfoId=" + userInfoId +
			", role='" + role + '\'' +
			'}';
	}
}
