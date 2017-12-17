package com.danielCastillo.GraphQLproofConcept.repositories;

import com.danielCastillo.GraphQLproofConcept.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {


}
