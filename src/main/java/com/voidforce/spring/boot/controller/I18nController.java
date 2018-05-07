package com.voidforce.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@RequestMapping("/language")
public class I18nController {

	@GetMapping("/changeSessionLanguage")
	public String changeSessionLanguage(HttpSession session, @RequestParam String lang) {
		if ("zh".equals(lang)) {
			session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.SIMPLIFIED_CHINESE);
		} else if ("en".equals(lang)) {
			session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.US);
		}
		return "redirect:/";
	}
}
