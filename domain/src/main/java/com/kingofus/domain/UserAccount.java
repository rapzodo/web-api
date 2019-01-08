package com.kingofus.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserAccount {
    private String email;
    private String password;
    private String fullName;
    private LocalDate birthDate;
    private LocalDateTime lastLogin;

}