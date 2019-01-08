package com.kingofus.service;

import com.kingofus.exceptions.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultLoginService implements LoginService{

    private UsersManagementService usersManagementService;

    @Autowired
    public DefaultLoginService(UsersManagementService usersManagementService) {
        this.usersManagementService = usersManagementService;
    }

    @Override
    public void login(String username, String password) throws Throwable {
        usersManagementService.findByUserNameAndPassword(username, password).orElseThrow(InvalidCredentialsException::new);
    }

}
