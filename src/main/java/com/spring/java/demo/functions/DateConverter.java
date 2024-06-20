package com.spring.java.demo.functions;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateConverter implements Converter<String, Date> {

    private static final SimpleDateFormat inputFormatter = new SimpleDateFormat("dd.MM.yyyy");
    private static final SimpleDateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String source) {
        try {
            // Convert input format to the output format
            Date date = inputFormatter.parse(source);
            String formattedDate = outputFormatter.format(date);
            return outputFormatter.parse(formattedDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use dd.MM.yyyy");
        }
    }
}
