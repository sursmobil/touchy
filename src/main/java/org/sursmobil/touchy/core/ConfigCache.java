package org.sursmobil.touchy.core;

import org.sursmobil.touchy.util.CachedFactory;

/**
 * Created by CJ on 29/08/2015.
 */
class ConfigCache {

    private final CachedFactory cache;

    ConfigCache() {
        cache = CachedFactory.create(this::instantiateConfig);
    }

    public <T> T getConfig(Class<T> configClass) {
        return cache.getInstance(configClass);
    }

    private <T> T instantiateConfig(Class<T> configClass) {
        return new ConfigClassParser<>(configClass).createInstance();
    }
}