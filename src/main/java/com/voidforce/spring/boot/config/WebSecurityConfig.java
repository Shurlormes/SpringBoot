package com.voidforce.spring.boot.config;

import com.voidforce.spring.boot.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/static/**", "/public/**", "/language/**").permitAll()
				.antMatchers("/").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.and()
			.logout().permitAll();
	}
}
