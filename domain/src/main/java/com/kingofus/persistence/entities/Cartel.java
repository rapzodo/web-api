package com.kingofus.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
public class Cartel {

    @Id
    @GeneratedValue
    public Long id;
    @OneToOne
    public User rival;
    @OneToOne
    public Game game;
}
