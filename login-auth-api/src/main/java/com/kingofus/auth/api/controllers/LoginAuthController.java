package com.kingofus.auth.api.controllers;

import com.kingofus.domain.LoggedUser;
import com.kingofus.domain.LoginUser;
import com.kingofus.domain.mapping.OrikaBeansMapper;
import com.kingofus.persistence.entities.User;
import com.kingofus.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/king-of-us/auth/api/v1")
public class LoginAuthController {

    private LoginService loginService;
    private OrikaBeansMapper orikaBeansMapper;

    @Autowired
    public LoginAuthController(LoginService loginService, OrikaBeansMapper orikaBeansMapper) {
        this.loginService = loginService;
        this.orikaBeansMapper = orikaBeansMapper;
    }

    @PostMapping("/login")
    public LoggedUser login(@RequestBody LoginUser loginUser) throws Throwable {
        User user = loginService.login(loginUser.getUserName(), loginUser.getPassword());
        return orikaBeansMapper.map(user, LoggedUser.class);
    }
}
