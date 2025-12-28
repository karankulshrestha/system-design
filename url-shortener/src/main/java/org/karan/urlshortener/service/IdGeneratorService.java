package org.karan.urlshortener.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class IdGeneratorService {
    private final AtomicLong counter = new AtomicLong(1000000);

    public long generateId() {
        return counter.incrementAndGet();
    }
}
