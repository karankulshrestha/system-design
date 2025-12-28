package org.karan.urlshortener.model;

public class UrlMapping {
    private long id;
    private String shortCode;
    private String longUrl;

    public UrlMapping(long id, String shortCode, String longUrl) {
        this.id = id;
        this.shortCode = shortCode;
        this.longUrl = longUrl;
    }

    public long getId() {
        return id;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getLongUrl() {
        return longUrl;
    }
}
