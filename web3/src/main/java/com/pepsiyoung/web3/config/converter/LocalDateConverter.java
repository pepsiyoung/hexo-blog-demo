package com.pepsiyoung.web3.config.converter;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

public class LocalDateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(@NonNull String source) {
        return LocalDate.parse(source);
    }
}
