package test.system;

import com.github.t1.testcontainers.jee.JeeContainer;
import com.github.t1.testcontainers.jee.WildflyContainer;
import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import io.smallrye.graphql.client.typesafe.api.TypesafeGraphQLClientBuilder;
import org.eclipse.microprofile.graphql.Query;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.BDDAssertions.then;

@Testcontainers
class PingIT {
    @Container static JeeContainer CONTAINER = WildflyContainer
        .create("rdohna/wildfly", "latest")
        .withDeployment("target/ROOT.war");

    @GraphQLClientApi
    public interface Api {
        @Query String ping();
    }

    Api api = TypesafeGraphQLClientBuilder.newBuilder()
        .endpoint(CONTAINER.baseUri() + "/graphql")
        .build(Api.class);

    @Test
    void shouldPing() {
        var pong = api.ping();

        then(pong).isEqualTo("pong");
    }
}
