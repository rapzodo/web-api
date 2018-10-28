package com.kingofus.webapi.service;

import com.kingofus.webapi.persistence.entities.Genre;
import com.kingofus.webapi.persistence.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreCrudService implements CrudService<Genre, Long> {

    private GenreRepository genreRepository;

    @Autowired
    public GenreCrudService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAll() {
        return null;
    }

    @Override
    public void store() {

    }

    @Override
    public Genre findOne(Long searchKey) {
        return null;
    }
}
