package com.danielCastillo.GraphQLproofConcept.datafetchers;

import com.danielCastillo.GraphQLproofConcept.entities.Film;
import com.danielCastillo.GraphQLproofConcept.repositories.FilmRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmDataFetcher implements DataFetcher<Film> {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Film get(DataFetchingEnvironment env) {
        Film film = filmRepository.findOne(Long.valueOf(env.getArguments().get("id").toString()));
        return film;
    }
}
