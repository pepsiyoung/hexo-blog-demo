package com.pepsiyoung.web.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Configuration
public class ConversionServiceConfig {

//    @Primary
//    @Bean
//    public GenericConversionService getConversionService(GenericConversionService genericConversionService) {
//        genericConversionService.addConverter(new LocalDateTimeConverter());
//        System.out.println("类型转换已加入！");
//        return genericConversionService;
//    }

    @Bean
    public ConversionServiceFactoryBean conversionService(Set<Converter<?, ?>> converters) {
        ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
        converters.add(new LocalDateTimeConverter());
        factory.setConverters(converters);
        return factory;
    }

    @Bean
    public RequestMappingHandlerAdapter RequestMappingHandlerAdapter(RequestMappingHandlerAdapter adapter) {
        adapter.setWebBindingInitializer(new MyWebBindingInitializer());
        return adapter;
    }

    /**
     * 配置返回的null String用""替代 List用[]替代
     */
    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @SneakyThrows
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                String fieldName = jsonGenerator.getOutputContext().getCurrentName();
                Field field = jsonGenerator.getCurrentValue().getClass().getDeclaredField(fieldName);
                if (Objects.equals(field.getType(), String.class))
                    jsonGenerator.writeString("");
                else if (Objects.equals(field.getType(), List.class)) {
                    jsonGenerator.writeStartArray();
                    jsonGenerator.writeEndArray();
                } else {
                    jsonGenerator.writeObject(null);
                }
            }
        });
        return objectMapper;
    }
}


