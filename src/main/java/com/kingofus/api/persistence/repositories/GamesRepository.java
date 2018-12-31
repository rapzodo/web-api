package com.kingofus.api.persistence.repositories;

import com.kingofus.api.persistence.entities.Game;
import org.springframework.data.repository.CrudRepository;

public interface GamesRepository extends CrudRepository<Game,Long> {
}
