package org.deathkiller.wow.alpha.network.endpoint;

import io.vertx.core.*;
import io.vertx.core.net.NetServerOptions;
import io.vertx.core.net.NetSocket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deathkiller.wow.alpha.network.config.BasicEndpointProperties;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class BasicEndpoint extends AbstractEndpoint {

    private final BasicEndpointProperties configuration;

    @Override
    public DeploymentOptions getOptions() {
        return configuration.getDeployment();
    }

    @Override
    protected void accept(NetSocket socket) {
        socket.handler(buffer -> {
            System.out.println("I received some bytes: " + buffer.length());
        });
    }

    @Override
    protected Logger getLogger() {
        return log;
    }

    @Override
    protected NetServerOptions getNetworkOptions() {
        return configuration.getNetwork();
    }
}
