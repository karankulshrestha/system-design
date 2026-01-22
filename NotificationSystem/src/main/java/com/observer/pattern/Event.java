package com.observer.pattern;

public class Event {
    public String type;
    public String message;

    public Event(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
