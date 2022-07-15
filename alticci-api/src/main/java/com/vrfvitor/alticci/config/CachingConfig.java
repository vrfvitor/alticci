package com.vrfvitor.alticci.config;

import org.springframework.cache.*;
import org.springframework.cache.annotation.*;
import org.springframework.cache.concurrent.*;
import org.springframework.cache.support.*;
import org.springframework.context.annotation.*;

import java.util.*;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("alticci-results")));
        return cacheManager;
    }
}