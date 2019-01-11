package com.kingofus.persistence.repositories;

import com.kingofus.persistence.entities.Game;
import com.kingofus.persistence.entities.Genre;
import com.kingofus.persistence.entities.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface GamesRepository extends JpaRepository<Game,Long> {

    Game findGameByTitle(String title);

    Stream<Game> readAllByPlatforms(Platform platform);

    Stream<Game> readAllByGenre(Genre genre);
}
