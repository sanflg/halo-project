package org.project.haloproject.web.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:endpoints.properties"})
public interface Endpoints extends Config {
    @Key("mtggoldfish.main")
    String MtgGoldFishMain();

    @Key("mtggoldfish.search")
    String MtgGoldFishSearch();
}
