package com.pepsiyoung.web.controller;

import com.pepsiyoung.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

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

    @GetMapping("localDateTime/{date}")
    public String convertLocalDateTime(@PathVariable LocalDateTime date) {
        return date.toString();
    }

    @GetMapping("date/{date}")
    public String convertDate(@PathVariable Date date) {
        System.out.println(date);
        return date.toString();
    }

    @PostMapping("")
    public String convert(User user) {
        return user.toString();
    }

    @PostMapping("json")
    public String convertJson(@RequestBody User user) {
        return user.toString();
    }

    @Autowired
    ConversionService conversionService;

    @GetMapping("test")
    public Object test() {
        String source = "2020-12-01 12:23:23";
        return conversionService.convert(source, LocalDateTime.class);
        // return conversionService.convert(Arrays.asList(1, 2, 3, 4, 5), String.class);
    }
}
