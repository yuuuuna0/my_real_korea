package com.itwill.my_real_korea.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.my_real_korea.dto.user.EmailAuthRequest;
import com.itwill.my_real_korea.service.user.EmailService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @ApiOperation(value = "이메일 인증번호")
    @PostMapping(value = "user-find-id", produces = "application/json;charset=UTF-8")
    public String mailAuth(@RequestBody EmailAuthRequest emailDto) throws MessagingException, UnsupportedEncodingException {
        emailService.sendAuth(emailDto.getEmail());
        return "user-login-form";
    }
    
    @ApiOperation(value = "임시 비밀번호")
    @PostMapping(value = "user-find-password", produces = "application/json;charset=UTF-8")
    public String mailTempPassword(@RequestBody EmailAuthRequest emailDto) throws MessagingException, UnsupportedEncodingException {
        emailService.sendTempPassword(emailDto.getEmail());
        return "user-login-form";
    }

	
	
}