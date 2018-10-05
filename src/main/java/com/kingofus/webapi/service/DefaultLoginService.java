package com.kingofus.webapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DefaultLoginService implements LoginService{

    @Value(value = "${app.hello.message}")
    private String loginMessage;

    @Override
    public String login(String username,String password) {
        return loginMessage;
    }
}
