package com.kingofus.webapi.persistence.repositories;

import com.kingofus.webapi.persistence.entities.Game;
import com.kingofus.webapi.persistence.entities.Platform;
import org.springframework.data.repository.CrudRepository;

public interface PlatformRepository extends CrudRepository<Platform,Long> {
}
