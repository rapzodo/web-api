package com.kingofus.api.service;

import com.kingofus.api.persistence.entities.User;
import com.kingofus.api.persistence.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersManagementServiceImpl implements UsersManagementService<User, Long> {

    private UsersRepository usersRepository;

    @Autowired
    public UsersManagementServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) usersRepository.findAll();
    }

    @Override
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    public User findOne(Long id) {
        Optional<User> user = usersRepository.findById(id);
        return user.orElseThrow(() -> new UsernameNotFoundException("User " + id + " not found"));
    }

    @Override
    public Optional<User> findByUserNameAndPassword(String username, String password) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return Optional.empty();
    }
}
