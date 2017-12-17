package com.danielCastillo.GraphQLproofConcept.controllers;

import com.danielCastillo.GraphQLproofConcept.datafetchers.FilmDataFetcher;
import com.danielCastillo.GraphQLproofConcept.datafetchers.FilmsDataFetcher;
import com.danielCastillo.GraphQLproofConcept.scalars.DateScalar;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("/graphql")
@Slf4j
public class GraphQLController {

    @Value("classpath:film.graphqls")
    private Resource schemaResource;

    private GraphQL graphQL;

    @Autowired
    private FilmDataFetcher filmDataFetcher;
    @Autowired
    private FilmsDataFetcher filmsDataFetcher;
    @Autowired
    private DateScalar dateScalar;

    @PostConstruct
    public void loadSchema() throws IOException {
        File schemaFile = schemaResource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = builRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry,wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring builRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring().type("GraphQL", typeWiring -> typeWiring
                .dataFetcher("films", filmsDataFetcher)
                .dataFetcher("film", filmDataFetcher))
                .scalar(dateScalar)
                .build();
    }


    @PostMapping
    public ResponseEntity graphQlEntryPoint(@RequestBody String query){
        ExecutionResult result = graphQL.execute(query);

        if(result.getErrors().size() > 0) {
            log.error(result.getErrors().toString());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result.getErrors());
        }

        return ResponseEntity.ok(result.getData());
    }
}
