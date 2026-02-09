package org.project.haloproject.web.config;

import org.aeonbits.owner.ConfigCache;

public class EndpointManager {

    private EndpointManager() {
    }

    public static Endpoints getEndpoint() {
        return ConfigCache.getOrCreate(Endpoints.class);
    }
}
