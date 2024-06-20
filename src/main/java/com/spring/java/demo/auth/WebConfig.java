package com.spring.java.demo.auth;

import com.spring.java.demo.functions.DateConverter;
import com.spring.java.demo.functions.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private DateConverter dateConverter;
    @Autowired
    private DateFormatter dateFormatter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter);
        registry.addFormatter(dateFormatter);
    }
}
