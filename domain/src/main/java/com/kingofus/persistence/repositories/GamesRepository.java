package com.kingofus.persistence.repositories;

import com.kingofus.persistence.entities.Game;
import org.springframework.data.repository.CrudRepository;

public interface GamesRepository extends CrudRepository<Game,Long> {
}
