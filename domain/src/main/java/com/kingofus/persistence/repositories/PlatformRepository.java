package com.kingofus.persistence.repositories;

import com.kingofus.persistence.entities.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
}
