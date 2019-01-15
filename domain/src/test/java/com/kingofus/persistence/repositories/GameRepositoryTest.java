package com.kingofus.persistence.repositories;

import com.kingofus.persistence.entities.Game;
import com.kingofus.persistence.entities.Genre;
import com.kingofus.persistence.entities.Platform;
import org.junit.Before;
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
public class GameRepositoryTest {

    public static final long SPORTS_GENRE_ID = 1000L;
    private final Long XBOXONE_ID = 2000L;
    private final Long PS4_ID = 5000L;

    @Autowired
    private GameRepository repository;
    @Autowired
    private PlatformRepository platformRepository;
    @Autowired
    private GenreRepository genreRepository;
    private Platform xboxOne;
    private Platform ps4;
    private Genre sports;

    @Before
    public void setup() {
        ps4 = platformRepository.getOne(PS4_ID);
        xboxOne = platformRepository.getOne(XBOXONE_ID);
        sports = genreRepository.getOne(SPORTS_GENRE_ID);
        insertGames();
    }

    @Test
    @Transactional
    public void shouldFindGamesByPlatform() {
        try (Stream<Game> gamesXboxOne = repository.readAllByPlatform(xboxOne)) {
            assertThat(gamesXboxOne.count()).isEqualTo(2);
        }
        try (Stream<Game> gamesPs4 = repository.readAllByPlatform(ps4)) {
            assertThat(gamesPs4.count()).isEqualTo(2);
        }
    }

    @Test
    @Transactional
    public void shouldFindGamesByGenre() {
        try (Stream<Game> gameStream = repository.readAllByGenre(sports)) {
            assertThat(gameStream.count()).isEqualTo(4);
        }
    }

    @Test
    @Transactional
    public void shouldFindGamesByTitle() {
        try (Stream<Game> nba2k19 = repository.readByTitle("NBA 2K19")) {
            assertThat(nba2k19.count()).isEqualTo(2);
        }
    }

    @Test
    @Transactional
    public void shouldFindGameByTitleAndPlatform() {
        String title = "NBA 2K19";
        assertThat(repository.findByTitleAndPlatform(title,xboxOne))
                .matches(game -> game.getTitle().equals(title) && game.getPlatform().equals(xboxOne));
    }

    public void insertGames() {
        Game nba2k = new Game(null, "NBA 2K19", sports, xboxOne);
        Game nba2kPs4 = new Game(null, "NBA 2K19", sports, ps4);
        Game granTurismo = new Game(null, "GRAN TURISMO", sports, ps4);
        Game forza = new Game(null, "FORZA HORIZON 4", sports, xboxOne);
        repository.saveAll(Arrays.asList(nba2k, nba2kPs4, granTurismo, forza));
        repository.flush();
    }

}