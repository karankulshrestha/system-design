package org.karan.urlshortener.controller;

import org.karan.urlshortener.service.UrlShortenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UrlController {

    private final UrlShortenerService service;

    public UrlController(UrlShortenerService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public ResponseEntity<ShortenResponse> shorten(@RequestBody ShortenRequest request) {
        String shortCode = service.shortenUrl(request.getLongUrl());
        String shortUrl = "http://localhost:8080/" + shortCode;

        ShortenResponse response = new ShortenResponse(shortCode, shortUrl);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{shortCode}")
    public void redirect(@PathVariable String shortCode,
                         HttpServletResponse response) throws IOException {

        String longUrl = service.getLongUrl(shortCode);

        if (longUrl == null) {
            response.sendError(HttpStatus.NOT_FOUND.value());
        } else {
            response.sendRedirect(longUrl);
        }
    }
}
