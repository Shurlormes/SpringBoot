package com.voidforce.spring.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class I18nConfig {

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		return slr;
	}

	/*@Bean
	public Validator validator() {
		return Validation.byDefaultProvider()
			.configure()
			.messageInterpolator(
				new ResourceBundleMessageInterpolator(
					new PlatformResourceBundleLocator("i18n/validation/messages")
				)
			)
			.buildValidatorFactory()
			.getValidator();
	}*/

}
