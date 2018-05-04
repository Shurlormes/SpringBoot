package com.voidforce.spring.boot.controller;

import com.voidforce.spring.boot.bean.UserInfo;
import com.voidforce.spring.boot.service.common.BaseMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Locale;

@Controller
public class HelloController {

	@Autowired
	private BaseMessageSource baseMessageSource;

	@GetMapping("/say/{str}")
	@ResponseBody
	public String say(@PathVariable String str) {
		return "Hello Spring Boot! " + str;
	}

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", baseMessageSource.getMessage("home.message.welcome"));
		return "hello";
	}

	@GetMapping("/form")
	public String showForm(Model model, UserInfo userInfo) {
		model.addAttribute("userInfo", userInfo);
		return "form";
	}

	@PostMapping("/form")
	public String submitForm(@Valid UserInfo userInfo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		return "redirect:/hello";
	}

	@GetMapping("/changeSessionLanguage")
	public String changeSessionLanguage(HttpSession session, @RequestParam String lang) {
		if ("zh".equals(lang)) {
			session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh", "CN"));
		} else if ("en".equals(lang)) {
			session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", "US"));
		}
		return "redirect:/hello";
	}
}
