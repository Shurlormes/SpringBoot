package com.voidforce.spring.boot.service.userRole.impl;

import com.voidforce.spring.boot.bean.UserRole;
import com.voidforce.spring.boot.mapper.UserRoleMapper;
import com.voidforce.spring.boot.service.userRole.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserRoleImpl implements UserRoleService {

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public void insert(UserRole userRole) {
		userRoleMapper.insert(userRole);
	}

	@Override
	public List<UserRole> findByUserInfoId(Long userInfoId) {
		return userRoleMapper.findByUserInfoId(userInfoId);
	}
}
