package com.kingofus.service;

import com.kingofus.persistence.entities.User;

public interface LoginService {
    User login(String username, String password);
}
