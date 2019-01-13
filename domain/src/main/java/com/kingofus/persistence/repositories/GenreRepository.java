package com.kingofus.persistence.repositories;

import com.kingofus.persistence.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {

}
