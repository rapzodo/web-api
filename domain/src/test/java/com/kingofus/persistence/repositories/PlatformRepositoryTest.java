package com.kingofus.persistence.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlatformRepositoryTest {

    @Autowired
    private PlatformRepository repository;

    @Test
    public void shouldRerturnAllPlatforms(){
        Assertions.assertThat(repository.findAll()).hasSize(7);
    }

}