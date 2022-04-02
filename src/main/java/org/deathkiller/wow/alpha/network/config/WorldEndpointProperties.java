package org.deathkiller.wow.alpha.network.config;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.net.NetServerOptions;
import lombok.Data;

@Data
public class WorldEndpointProperties {

    private DeploymentOptions deployment = new DeploymentOptions();
    private NetServerOptions network = new NetServerOptions();

    public WorldEndpointProperties() {
        this.deployment.setWorker(true);
        this.network.setHost("localhost");
        this.network.setPort(8100);
    }

    public int getPort() {
        return this.network.getPort();
    }

    public String getHost() {
        return this.network.getHost();
    }
}
