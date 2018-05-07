package com.voidforce.spring.boot.controller;

import com.voidforce.spring.boot.bean.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping("")
	public String showForm(Model model, UserInfo userInfo) {
		model.addAttribute("userInfo", userInfo);
		return "form";
	}

	@PostMapping("")
	public String submitForm(@Validated UserInfo userInfo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		return "redirect:/hello";
	}
}
