package org.deathkiller.wow.alpha.network.config;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.net.NetServerOptions;
import lombok.Data;

@Data
public class RealmEndpointProperties {

    private DeploymentOptions deployment = new DeploymentOptions();
    private NetServerOptions network = new NetServerOptions();

    public RealmEndpointProperties() {
        this.deployment.setWorker(true);
        this.network.setHost("localhost");
        this.network.setPort(9100);
    }
}
