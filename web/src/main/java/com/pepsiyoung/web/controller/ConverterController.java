package com.pepsiyoung.web.controller;

import com.pepsiyoung.web.config.LocalDateTimeConverter;
import com.pepsiyoung.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@RestController
@RequestMapping("converter")
public class ConverterController {

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//
////        GenericConversionService genericConversionService = (GenericConversionService) binder.getConversionService();
////        if (genericConversionService != null) {
////            genericConversionService.addConverter(new LocalDateTimeConverter());
////        }
//    }

    @GetMapping("localDateTime")
    public LocalDateTime convertLocalDateTime(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-ddHH:mm:ss") LocalDateTime date) {
        return date;
    }

    @GetMapping("date/{date}")
    public String convertDate(@PathVariable Date date) {
        return date.toString();
    }

    @PostMapping("")
    public String convert(User user) {
        return user.toString();
    }

    @PostMapping("json")
    public User convertJson(@RequestBody User user) {
        if (user.getLocalDateTime() == null)
            user.setLocalDateTime(LocalDateTime.now());
        return user;
    }

    @Autowired
    ConversionService conversionService;

    @GetMapping("test")
    public LocalDateTime test() {
        String source = "2020-12-01 12:23:23";
        return conversionService.convert(source, LocalDateTime.class);
    }
}
