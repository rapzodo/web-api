package com.kingofus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoggedUser {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime lastLogin;

}