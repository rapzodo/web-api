package com.kingofus.service;

import com.kingofus.persistence.entities.User;
import com.kingofus.persistence.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsersManagementServiceImpl implements UsersManagementService<Long> {

    private UsersRepository usersRepository;

    @Autowired
    public UsersManagementServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAll() {
        return usersRepository.findAll();
    }

    @Override
    @Transactional
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    public Optional<User> findOne(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Optional<User> findByUserNameAndPassword(String username, String password) {
        return usersRepository.findUserByEmailAndPassword(username,password);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return usersRepository.findUserByEmail(userName);
    }
}
