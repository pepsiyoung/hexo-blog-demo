package com.pepsiyoung.web3.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.pepsiyoung.web3.entity.FooFactoryBean;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class MyConfig {

    //项目全局的时间出参格式化
    private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    @Bean
    public FooFactoryBean fooFactoryBean() {
        FooFactoryBean fooFactoryBean = new FooFactoryBean();
        fooFactoryBean.setName("www");
        return fooFactoryBean;
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            builder.simpleDateFormat(dateTimeFormat);
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
            builder.deserializers(new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
        };
    }
}