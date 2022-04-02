package org.deathkiller.wow.alpha.network.endpoint;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.net.NetServerOptions;
import io.vertx.core.net.NetSocket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deathkiller.wow.alpha.network.config.RealmEndpointProperties;
import org.deathkiller.wow.alpha.network.packet.PacketWriter;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RealmEndpoint extends AbstractEndpoint {

    private final RealmEndpointProperties configuration;

    @Override
    public DeploymentOptions getOptions() {
        return configuration.getDeployment();
    }

    @Override
    protected void accept(NetSocket socket) {
        socket.handler(buffer -> {
            var writer = new PacketWriter()
                    .writeUInt8((byte) 0)
                    .writeString("|cFF00FFFFAlpha Test Realm")
                    .writeString(getNetworkOptions().getHost()+":"+getServer().actualPort())
                    .writeUInt32(12);

            socket.write(writer.buffer());
            socket.end();
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
