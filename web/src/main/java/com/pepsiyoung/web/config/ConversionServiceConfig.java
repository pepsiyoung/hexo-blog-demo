package com.pepsiyoung.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;


@Configuration
public class ConversionServiceConfig {

//    @Bean
//    public GenericConversionService getConversionService(GenericConversionService genericConversionService) {
//        genericConversionService.addConverter(new LocalDateTimeConverter());
//        System.out.println("类型转换已加入！");
//        return genericConversionService;
//    }

//    @Bean
//    public ConversionServiceFactoryBean conversionService(Set<Converter<?, ?>> converters) {
//        ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
//        converters.add(new LocalDateTimeConverter());
//        factory.setConverters(converters);
//        return factory;
//    }

    @Bean
    public RequestMappingHandlerAdapter RequestMappingHandlerAdapter(RequestMappingHandlerAdapter adapter) {
        adapter.setWebBindingInitializer(new MyWebBindingInitializer());
        return adapter;
    }
}


