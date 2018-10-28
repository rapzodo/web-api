package com.kingofus.webapi.service;

import com.kingofus.webapi.persistence.entities.Game;
import com.kingofus.webapi.persistence.repositories.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesCrudService implements CrudService<Game, Long> {

    private GamesRepository gamesRepository;

    @Autowired
    public GamesCrudService(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @Override
    public List<Game> getAll() {
        return (List<Game>) gamesRepository.findAll();
    }

    @Override
    public void store() {

    }

    @Override
    public Game findOne(Long searchKey) {
        return null;
    }
}
