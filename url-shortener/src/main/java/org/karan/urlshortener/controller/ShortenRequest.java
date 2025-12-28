package org.karan.urlshortener.controller;

public class ShortenRequest {
    private String longUrl;

    public ShortenRequest() {}

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}