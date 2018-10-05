package com.kingofus.webapi.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Genre {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    @ManyToOne
    private Game game;
}
