package com.kingofus.api.persistence.repositories;

import com.kingofus.api.persistence.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User,Long> {

}
