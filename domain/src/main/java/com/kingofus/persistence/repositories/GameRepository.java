package com.kingofus.persistence.repositories;

import com.kingofus.persistence.entities.Game;
import com.kingofus.persistence.entities.Genre;
import com.kingofus.persistence.entities.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface GameRepository extends JpaRepository<Game,Long> {

    Stream<Game> readByTitle(String title);

    Stream<Game> readAllByPlatform(Platform platform);

    Stream<Game> readAllByGenre(Genre genre);

    Game findByTitleAndPlatform(String title, Platform platform);
}
