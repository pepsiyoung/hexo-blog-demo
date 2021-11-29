package com.pepsiyoung.sms.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sms")
@Data
public class SmsProperties {

    /**
     * 运营商(默认电信)
     */
    private String operator = "电信";
}
