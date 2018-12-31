package com.kingofus.api.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

@Entity
@Data
public class Platform {
    @Id
    @GeneratedValue
    private BigInteger id;
    private String name;
    @ManyToOne
    private Game game;
}
