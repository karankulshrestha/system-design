package com.observer.pattern;

public interface Subscriber {
    void handleEvent(Event event);
}
