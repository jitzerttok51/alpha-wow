package org.deathkiller.wow.alpha.network.endpoint;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.net.NetServerOptions;
import io.vertx.core.net.NetSocket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deathkiller.wow.alpha.dto.RealmListDTO;
import org.deathkiller.wow.alpha.network.config.ProxyEndpointProperties;
import org.deathkiller.wow.alpha.network.config.RealmEndpointProperties;
import org.deathkiller.wow.alpha.network.packet.PacketWriter;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RealmEndpoint extends AbstractEndpoint {

    private final RealmEndpointProperties configuration;
    private final ProxyEndpointProperties proxyConfiguration;

    @Override
    public DeploymentOptions getOptions() {
        return configuration.getDeployment();
    }

    @Override
    protected void accept(NetSocket socket) {
        var writer = new RealmListDTO
                .Builder(configuration.getHost())
                .addRealm("|cFF00FFFFTest Realm for Alpha", proxyConfiguration.getPort(), 12)
                .build()
                .write();
        socket.end(writer.bufferAuth());
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
