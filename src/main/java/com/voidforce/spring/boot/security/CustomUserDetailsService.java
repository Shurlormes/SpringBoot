package com.voidforce.spring.boot.security;

import com.voidforce.spring.boot.bean.UserInfo;
import com.voidforce.spring.boot.bean.UserRole;
import com.voidforce.spring.boot.service.userInfo.UserInfoService;
import com.voidforce.spring.boot.service.userRole.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private UserRoleService userRoleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = userInfoService.getByEmail(username);
		if(userInfo == null) {
			log.error("Email {} not fount!", username);
			throw new UsernameNotFoundException("用户名："+username+"不存在");
		}

		Collection<GrantedAuthority> authorities = new ArrayList<>();

		List<UserRole> roleList = userRoleService.findByUserInfoId(userInfo.getUserInfoId());
		for (UserRole userRole : roleList) {
			GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getRole());
			authorities.add(authority);
		}

		userInfo.setAuthorities(authorities);

		return userInfo;
	}
}
