package com.kingofus.persistence.entities;

import com.kingofus.domain.Manufacturer;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Platform {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Manufacturer manufacturer;
    @OneToMany(mappedBy = "platform")
    private List<Game> games;
}
