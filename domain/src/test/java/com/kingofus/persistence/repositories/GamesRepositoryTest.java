package com.kingofus.persistence.repositories;

import com.kingofus.persistence.entities.Game;
import com.kingofus.persistence.entities.Platform;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GamesRepositoryTest {

    @Autowired
    private GamesRepository repository;
    @Autowired
    private PlatformRepository platformRepository;

    @Test
    @Transactional
    public void shouldFindGamesByPlatform(){
        Platform platform = platformRepository.findById(2000L).get();
        Game nba2k = new Game(null,"NBA 2K19", null, Arrays.asList(platform));
        repository.saveAndFlush(nba2k);
        try(Stream<Game> gameStream = repository.readAllByPlatforms(platform)){
            assertThat(gameStream).isNotNull();
        }
    }

}