  
  
  #Concept Proof with Spring boot and GraphQL
    
    Description: 
     A litle api using GraphQL, the idea of graphl is to use a unique endpoint,
     with this endpoint we can realize queries using the graphql language and To get
     only the data that we need.
     
     
 #Endpoind
 
    URL : http:localhost:8080/graphql 
    httpMethod: POST    
       
 
 #Queries
 
    Send the query as text not like json.
    
   ```graphql
{ 
film(id: 1) {
    id
    title
    sinopsis
    publishAt
    director {
        name
        surname
    }
}
} 
   ```
   ```graphql
{ 
    films {
        id
        title
        sinopsis
        director {
            name
            surname
            age
            phone
        }
    }
}
   ```

 