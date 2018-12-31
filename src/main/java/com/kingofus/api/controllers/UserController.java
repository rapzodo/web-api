package com.kingofus.api.controllers;

import com.kingofus.api.domain.LoggedUser;
import com.kingofus.api.domain.LoginUser;
import com.kingofus.api.persistence.entities.User;
import com.kingofus.api.service.LoginService;
import com.kingofus.api.service.UsersManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UsersManagementService usersManagementService;
    private LoginService loginService;

    @Autowired
    public UserController(UsersManagementService usersManagementService) {
        this.usersManagementService = usersManagementService;
    }

    @PostMapping("/login")
    public LoggedUser login(LoginUser user) throws Throwable {
        loginService.login(user.getUserName(), user.getPassword());
        User foundUser = (User) usersManagementService.findByUserName(user.getUserName()).get();
        return new LoggedUser(foundUser.getFirstName(),foundUser.getEmail(), LocalDateTime.now());
    }

    @GetMapping
    public String getGames(Model model) throws Exception {
        List all = usersManagementService.getAll();
        if (all == null || all.size() == 0)
            throw new Exception("deu merda , nao achou nada");
        model.addAttribute("games", all);
        return "games";
    }
}
