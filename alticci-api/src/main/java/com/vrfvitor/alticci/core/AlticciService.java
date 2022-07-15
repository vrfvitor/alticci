package com.vrfvitor.alticci.core;

import lombok.*;
import org.springframework.cache.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AlticciService {

    private final AlticciService self;

    /*
     * Cache only responds to external calls
     * https://stackoverflow.com/questions/16899604/spring-cache-cacheable-not-working-while-calling-from-another-method-of-the-s
     * Workaround: proxy (lazy-ish inject) own instance so it can simulate a external call and get cached results from previous uses
     */
    @Cacheable("alticci-results")
    public Long of(Integer n) {
        if (n == 0) return 0L;
        if (n < 3) return 1L;
        return self.of(n - 3) + self.of(n - 2);
    }
}
