package com.danielCastillo.GraphQLproofConcept.datafetchers;

import com.danielCastillo.GraphQLproofConcept.entities.Film;
import com.danielCastillo.GraphQLproofConcept.repositories.FilmRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmsDataFetcher implements DataFetcher<List<Film>> {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Film> get(DataFetchingEnvironment dataFetchingEnvironment) {
        List<Film> list = filmRepository.findAll();
        return list;
    }
}
