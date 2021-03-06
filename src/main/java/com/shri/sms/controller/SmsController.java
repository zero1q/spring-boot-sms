package com.shri.sms.controller;

import com.shri.sms.service.SmsRequester;
import com.shri.sms.service.TwilioSmsSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/sms")
public class SmsController {

    private final TwilioSmsSenderService service;

    @Autowired
    public SmsController(TwilioSmsSenderService service) {
        this.service = service;
    }

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequester smsRequester) {
        service.sendSms(smsRequester);
    }
}
