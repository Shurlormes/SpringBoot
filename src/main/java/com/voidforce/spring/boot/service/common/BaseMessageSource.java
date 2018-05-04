package com.voidforce.spring.boot.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class BaseMessageSource {

	@Autowired
	private MessageSource messageSource;

	public String getMessage(String code) {
		return this.getMessage(code, null);
	}

	public String getMessage(String code, Object[] args) {
		return this.getMessage(code, null, null);
	}

	public String getMessage(String code, Object[] args, String defaultMessage) {
		return messageSource.getMessage(code, args, defaultMessage, LocaleContextHolder.getLocale());
	}
}
