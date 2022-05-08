package com.pepsiyoung.web3.config;

import com.pepsiyoung.web3.config.converter.LocalDateTimeConverter;
import com.pepsiyoung.web3.config.converter.PersonConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LocalDateTimeConverter());
        registry.addConverter(new LocalDateTimeConverter());
        registry.addConverterFactory(new PersonConverter());
    }
}
