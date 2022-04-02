package org.deathkiller.wow.alpha.network.endpoint;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Verticle;

public interface NetworkEndpoint extends Verticle {

    DeploymentOptions getOptions();
}
