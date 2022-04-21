package com.github.t1.graphqlping;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class Pings {
    @Query
    public String ping() {
        return "pong";
    }
}
