package com.spring.java.demo.functions;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class DateFormatter implements Formatter<Date> {

    private static final String DATE_FORMAT = "dd.MM.yyyy";
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        return dateFormat.parse(text);
    }

    @Override
    public String print(Date date, Locale locale) {
        return dateFormat.format(date);
    }
}
