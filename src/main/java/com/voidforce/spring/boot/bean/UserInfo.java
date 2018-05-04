package com.voidforce.spring.boot.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserInfo {

	@NotNull(message = "{form.error.name.not.null}")
	@Size(min = 2, max = 30, message = "{form.error.name.size}")
	private String name;

	@NotNull(message = "{form.error.email.not.null}")
	@Pattern(regexp = "^[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?", message = "{form.error.email.pattern}")
	private String email;

	@NotNull(message = "{form.error.telephone.not.null}")
	@Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "{form.error.telephone.pattern}")
	private String telephone;

	@Size(max = 50, message = "{form.error.address.max.size}")
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
