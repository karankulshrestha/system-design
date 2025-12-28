package org.karan.urlshortener.repository;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.karan.urlshortener.model.UrlMapping;
import org.springframework.stereotype.Repository;

@Repository
public class UrlRepository {
    private final Map<Long, UrlMapping> store = new ConcurrentHashMap<>();

    public void save(UrlMapping mapping) {
        store.put(mapping.getId(), mapping);
    }

    public UrlMapping findById(long id) {
        return store.get(id);
    }
}
