package com.kingofus.api.domain;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

@Value
@AllArgsConstructor
@Component
public class LoginUser {
    String userName;
    String password;
}
