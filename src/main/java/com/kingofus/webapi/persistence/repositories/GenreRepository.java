package com.kingofus.webapi.persistence.repositories;

import com.kingofus.webapi.persistence.entities.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
