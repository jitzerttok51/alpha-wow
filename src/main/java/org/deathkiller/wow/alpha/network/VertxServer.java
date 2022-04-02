package org.deathkiller.wow.alpha.network;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deathkiller.wow.alpha.network.endpoint.NetworkEndpoint;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class VertxServer implements ApplicationRunner {

    private Vertx vertx;

    private final VertxOptions options;
    private final Set<NetworkEndpoint> endpoints;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        vertx = Vertx.vertx(options);
        endpoints
                .stream()
                .map(this::deploy)
                .forEach(f->f.onSuccess(s-> log.info("Deployed vertical {}", s) ));
    }

    public Future<String> deploy(NetworkEndpoint endpoint) {
        return vertx.deployVerticle(endpoint, endpoint.getOptions()).map(endpoint.getClass().getSimpleName());
    }
}
