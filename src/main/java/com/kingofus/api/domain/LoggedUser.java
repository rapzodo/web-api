package com.kingofus.api.domain;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Value
@AllArgsConstructor
@Component
public class LoggedUser {
    String name;
    String email;
    LocalDateTime lastLogin;
}