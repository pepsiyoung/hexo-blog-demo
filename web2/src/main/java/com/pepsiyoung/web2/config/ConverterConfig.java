package com.pepsiyoung.web2.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.pepsiyoung.web2.config.converter.LocalDateTimeConverter;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import java.time.format.DateTimeFormatter;
import java.util.Set;

@Configuration
public class ConverterConfig {

    //项目全局的时间出参格式化
    private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    @Bean
    public ConversionServiceFactoryBean conversionService(Set<Converter<?, ?>> converters) {
        ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
        converters.add(new LocalDateTimeConverter());
        factory.setConverters(converters);
        return factory;
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
