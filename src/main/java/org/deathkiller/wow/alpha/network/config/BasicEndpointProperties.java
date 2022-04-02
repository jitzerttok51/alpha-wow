package org.deathkiller.wow.alpha.network.config;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.net.NetServerOptions;
import lombok.Data;

@Data
public class BasicEndpointProperties {

    private DeploymentOptions deployment = new DeploymentOptions();
    private NetServerOptions network = new NetServerOptions();

    public BasicEndpointProperties() {
        this.deployment.setWorker(true);
        this.network.setHost("localhost");
        this.network.setPort(8081);
    }
}
