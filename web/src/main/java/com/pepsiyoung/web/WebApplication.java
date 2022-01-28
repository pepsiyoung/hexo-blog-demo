package com.pepsiyoung.web;

import com.google.common.collect.ImmutableMap;
import com.pepsiyoung.web.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.DataBinder;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

//    @Bean
//    public ApplicationRunner applicationRunner(ApplicationContext applicationContext) {
//        return args -> {
//            User user = new User();
//            DataBinder binder = new DataBinder(user, "");
//
//            Map<String, Object> source = ImmutableMap.of("id", 99, "name", "pepsiYoung");
//            PropertyValues propertyValues = new MutablePropertyValues(source);
//            binder.bind(propertyValues);
//            System.out.println(user);
//            System.out.println(binder.getBindingResult());
//
////            List<User> list = excelToList(User.class);
////            System.out.println(list);
////
////            User.class.getField("").getAnnotation()
//
//            SpringApplication.exit(applicationContext);
//        };
//    }

    public static <T> List<T> excelToList(Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        List<T> resList = new ArrayList<>();

        T model = clazz.newInstance();
        DataBinder binder = new DataBinder(model, "");
        Map<String, Object> source = ImmutableMap.of("id", 1, "name", "pepsiYoung");
        PropertyValues propertyValues = new MutablePropertyValues(source);
        binder.bind(propertyValues);
        resList.add(model);
        return resList;
    }


}
