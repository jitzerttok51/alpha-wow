package org.deathkiller.wow.alpha.network.endpoint;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetServerOptions;
import io.vertx.core.net.NetSocket;
import org.slf4j.Logger;


public abstract class AbstractEndpoint extends AbstractVerticle implements NetworkEndpoint {

    private NetServer server;

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        server = getVertx().createNetServer(getNetworkOptions());
        getLogger().info("Starting {} on port {}", this.getClass().getSimpleName(), getNetworkOptions().getPort());
        server.connectHandler(this::accept);
        server.listen(res -> {
            if(res.succeeded()) {
                getLogger().info("{} started listening on port: {}", this.getClass().getSimpleName(), res.result().actualPort());
                startPromise.complete();
            } else {
                getLogger().error("{} failed to bind on port: {}", this.getClass().getSimpleName(), res.result().actualPort());
                getLogger().error("Exception: ", res.cause());
                startPromise.fail(res.cause());
            }
        });
    }

    protected NetServer getServer() {
        return server;
    }

    protected abstract void accept(NetSocket socket);

    protected abstract Logger getLogger();

    protected abstract NetServerOptions getNetworkOptions();
}
