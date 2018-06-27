package com.voidforce.spring.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//设置允许跨域的路径
		registry.addMapping("/**")
			//设置允许跨域请求的域名
			.allowedOrigins("http://localhost:3000")
			//是否允许证书 不再默认开启
			.allowCredentials(true)
			//设置允许的方法
			.allowedMethods("*")
			//设置允许的请求头
			.allowedHeaders("*")
			//跨域允许时间
			.maxAge(3600);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}
}
