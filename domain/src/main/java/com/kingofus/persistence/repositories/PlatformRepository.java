package com.kingofus.persistence.repositories;

import com.kingofus.persistence.entities.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatformRepository extends JpaRepository<Platform, Long> {

    List<Platform> findAllByIdIn(List<Long> ids);
}
