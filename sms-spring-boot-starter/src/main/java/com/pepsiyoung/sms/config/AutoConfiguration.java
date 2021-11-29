package com.pepsiyoung.sms.config;

import com.pepsiyoung.sms.properties.SmsProperties;
import com.pepsiyoung.sms.service.MessageService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(SmsProperties.class)
@Configuration
public class AutoConfiguration {

    final
    SmsProperties smsProperties;

    public AutoConfiguration(SmsProperties smsProperties) {
        this.smsProperties = smsProperties;
    }

    @Bean
    public MessageService messageService() {
        return new MessageService(smsProperties);
    }
}
