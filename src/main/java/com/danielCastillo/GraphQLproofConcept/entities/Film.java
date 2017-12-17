package com.danielCastillo.GraphQLproofConcept.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Column(length = 50000)
    private String sinopsis;

    private Date publishAt;

    @ManyToOne
    private Director director;
}
