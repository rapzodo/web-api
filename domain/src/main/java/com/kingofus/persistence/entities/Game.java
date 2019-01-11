package com.kingofus.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @OneToMany(mappedBy = "game")
    @Fetch(FetchMode.SUBSELECT)
    private List<Genre> genre;
    @OneToMany(mappedBy = "game")
    @Fetch(FetchMode.SUBSELECT)
    private List<Platform> platforms;
}
