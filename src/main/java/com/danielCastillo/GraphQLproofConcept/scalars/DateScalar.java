package com.danielCastillo.GraphQLproofConcept.scalars;

import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateScalar extends GraphQLScalarType {

    public DateScalar(){
        super("Date", "Date type", new Coercing() {
            @Override
            public String serialize(Object o) {
                if(o instanceof Date) return String.valueOf(((Date) o).getTime());
                return null;
            }

            @Override
            public Date parseValue(Object o) {
                if(o instanceof String) return new Date(Long.valueOf(o.toString()));
                return null;
            }

            @Override
            public Date parseLiteral(Object o) {
                if(o instanceof String) return new Date(Long.valueOf(o.toString()));
                return null;
            }
        });
    }
}
