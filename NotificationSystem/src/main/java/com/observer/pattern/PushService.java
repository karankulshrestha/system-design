package com.observer.pattern;

public class PushService implements Subscriber {
    @Override
    public void handleEvent(Event event) {
        System.out.println("[PUSH] Mobile Alert: " + event.message);
    }
}
