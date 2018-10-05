package com.kingofus.webapi.persistence.repositories;

import com.kingofus.webapi.persistence.entities.Game;
import org.springframework.data.repository.CrudRepository;

public interface GamesRepository extends CrudRepository<Game,Long> {
}
