package com.kingofus.service;

import com.kingofus.exceptions.InvalidCredentialsException;
import com.kingofus.persistence.entities.User;
import com.kingofus.persistence.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultLoginService implements LoginService {

    private UsersRepository usersRepository;

    @Autowired
    public DefaultLoginService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User login(String username, String password) {
        return usersRepository.findUserByEmailAndPassword(username, password)
                .orElseThrow(InvalidCredentialsException::new);
    }

}
