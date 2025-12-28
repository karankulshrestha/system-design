package org.karan.urlshortener.service;

import org.karan.urlshortener.model.UrlMapping;
import org.karan.urlshortener.repository.UrlRepository;
import org.karan.urlshortener.util.Base62Encoder;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {
    private final IdGeneratorService idGenerator;
    private final UrlRepository repository;

    public UrlShortenerService(IdGeneratorService idGenerator,
                               UrlRepository repository) {
        this.idGenerator = idGenerator;
        this.repository = repository;
    }

    public String shortenUrl(String longUrl) {
        long id = idGenerator.generateId();
        String shortCode = Base62Encoder.encode(id);

        UrlMapping mapping = new UrlMapping(id, shortCode, longUrl);
        repository.save(mapping);

        return shortCode;
    }

    public String getLongUrl(String shortCode) {
        long id = Base62Encoder.decode(shortCode);
        UrlMapping mapping = repository.findById(id);

        return mapping != null ? mapping.getLongUrl() : null;
    }
}
