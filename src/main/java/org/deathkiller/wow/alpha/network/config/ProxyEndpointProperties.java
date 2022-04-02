package org.deathkiller.wow.alpha.network.config;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.net.NetServerOptions;
import lombok.Data;

@Data
public class ProxyEndpointProperties {

    private DeploymentOptions deployment = new DeploymentOptions();
    private NetServerOptions network = new NetServerOptions();

    public ProxyEndpointProperties() {
        this.deployment.setWorker(true);
        this.network.setHost("localhost");
        this.network.setPort(9090);
    }

    public int getPort() {
        return this.network.getPort();
    }

    public String getHost() {
        return this.network.getHost();
    }
}
