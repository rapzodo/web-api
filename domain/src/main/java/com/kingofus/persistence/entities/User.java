package com.kingofus.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User{

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gamerTag;
    private String password;
    private LocalDate birthDate;
    private LocalDateTime created;
    private LocalDateTime modifiedAt;
    private Boolean isActive;
    private Boolean isLocked;
    private LocalDateTime lastLogin;
    @OneToMany
    private List<Cartel> cartels;

}
