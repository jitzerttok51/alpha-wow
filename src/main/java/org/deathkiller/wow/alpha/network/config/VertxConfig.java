package org.deathkiller.wow.alpha.network.config;

import io.vertx.core.VertxOptions;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VertxConfig {

    @Bean
    @ConfigurationProperties(prefix = "vertx")
    public VertxOptions getOptions() {
        return new VertxOptions();
    }

    @Bean
    @ConfigurationProperties(prefix = "endpoint.basic")
    public BasicEndpointProperties getBasicEndpointProperties() {
        return new BasicEndpointProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "endpoint.realm")
    public RealmEndpointProperties getRealmEndpointProperties() {
        return new RealmEndpointProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "endpoint.proxy")
    public ProxyEndpointProperties getProxyEndpointProperties() {
        return new ProxyEndpointProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "endpoint.world")
    public WorldEndpointProperties getWorldEndpointProperties() {
        return new WorldEndpointProperties();
    }
}
