package com.voidforce.spring.boot.service.userRole;

import com.voidforce.spring.boot.bean.UserRole;

import java.util.List;

public interface UserRoleService {

	void insert(UserRole userRole);

	List<UserRole> findByUserInfoId(Long userInfoId);
}
