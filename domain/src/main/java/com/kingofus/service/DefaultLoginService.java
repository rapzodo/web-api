package com.kingofus.service;

import com.kingofus.exceptions.InvalidCredentialsException;
import com.kingofus.persistence.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultLoginService implements LoginService {

    private UsersManagementService usersManagementService;

    @Autowired
    public DefaultLoginService(UsersManagementService usersManagementService) {
        this.usersManagementService = usersManagementService;
    }

    @Override
    public User login(String username, String password) throws Throwable {
        return (User) usersManagementService.findByUserNameAndPassword(username, password)
                .orElseThrow(InvalidCredentialsException::new);
    }

}
