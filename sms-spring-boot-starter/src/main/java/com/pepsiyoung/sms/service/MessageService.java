package com.pepsiyoung.sms.service;

import com.pepsiyoung.sms.properties.SmsProperties;

public class MessageService {

    private final SmsProperties smsProperties;

    public MessageService(SmsProperties smsProperties) {
        this.smsProperties = smsProperties;
    }

    public String sms(String phone, String content) {
        return String.format("假装发送[%s]给手机号[%s]的用户「%s」", phone, content, smsProperties.getOperator());
    }
}
