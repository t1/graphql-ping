package com.github.t1.graphqlping;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;

@Slf4j
@GraphQLApi
public class Pings {
    @Inject @ConfigProperty(name = "pong", defaultValue = "annotation-pong") String pong;

    @Query
    public String ping() {
        log.info("got pinged");
        ConfigProvider.getConfig().getConfigSources().forEach(configSource ->
            log.info("config source {} [{}]", configSource.getName(), configSource.getClass().getName()));
        return pong;
    }
}
