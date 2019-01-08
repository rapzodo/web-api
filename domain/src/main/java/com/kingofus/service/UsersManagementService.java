package com.kingofus.service;

import com.kingofus.persistence.entities.User;

import java.util.List;
import java.util.Optional;

public interface UsersManagementService<KEY> {

    List<User> getAll();

    void save(User User);

    Optional<User> findOne(KEY searchKey);

    Optional<User> findByUserNameAndPassword(String username, String password);

    Optional<User> findByUserName(String userName);
}
