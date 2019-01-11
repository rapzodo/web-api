package com.kingofus.persistence.entities;

import com.kingofus.domain.Manufacturer;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Platform {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Manufacturer manufacturer;
    @ManyToOne
    private Game game;
}
