package com.voidforce.spring.boot.util;

import com.voidforce.spring.boot.bean.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;

public class SessionUtil {

	public static UserInfo currentUserInfo() {
		Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user instanceof UserInfo) {
			return (UserInfo) user;
		}
		return null;
	}

}
