package com.kingofus.api.service;

import com.kingofus.api.persistence.entities.User;

import java.util.List;
import java.util.Optional;

public interface UsersManagementService<VALUE, KEY> {

    List<VALUE> getAll();

    void save(User user);

    VALUE findOne(KEY searchKey);

    Optional<VALUE> findByUserNameAndPassword(String username, String password);

    Optional<VALUE> findByUserName(String userName);
}
