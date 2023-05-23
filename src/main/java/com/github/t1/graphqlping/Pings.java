package com.github.t1.graphqlping;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
@Slf4j
public class Pings {
    @Query
    public String ping() {
        log.info("got pinged");
        return "pong";
    }
}
