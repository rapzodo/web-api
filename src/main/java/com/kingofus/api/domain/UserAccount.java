package com.kingofus.api.domain;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
@AllArgsConstructor
@Component
public class UserAccount {
    String userName;
    String email;
    String firstName;
    String lastName;
    LocalDate birthDate;
    LocalDateTime lastLogin;
}