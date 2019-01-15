package com.kingofus.management.controllers;

import com.kingofus.domain.UserAccount;
import com.kingofus.domain.mapping.OrikaBeansMapper;
import com.kingofus.exceptions.UserNotFoundException;
import com.kingofus.persistence.entities.User;
import com.kingofus.service.UsersManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/king-of-us/management/api/v1/users")
public class UsersManagementController {

    private UsersManagementServiceImpl usersManagementService;
    private OrikaBeansMapper beansMapper;

    @Autowired
    public UsersManagementController(UsersManagementServiceImpl usersManagementService, OrikaBeansMapper orikaBeansMapper) {
        this.usersManagementService = usersManagementService;
        this.beansMapper = orikaBeansMapper;
    }

    @GetMapping
    public List<UserAccount> getAllUserAccounts() {
        return usersManagementService.getAll().stream()
                .map(u -> beansMapper.mapUserToUserAccount(u))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void addUser(@RequestBody UserAccount userAccount) {
        usersManagementService.save(beansMapper.mapUserAccountToUser(userAccount));
    }

    @GetMapping("/{userId}")
    public UserAccount getUserById(@PathVariable("userId") Long userId) {
        User u = usersManagementService.findOne(userId).orElseThrow(UserNotFoundException::new);
        return beansMapper.mapUserToUserAccount(u);
    }


    @GetMapping("/search")
    public UserAccount getByUserName(@RequestParam("email") String username) {
        User u = usersManagementService.findByUserName(username).orElseThrow(UserNotFoundException::new);
        return beansMapper.mapUserToUserAccount(u);
    }


}
