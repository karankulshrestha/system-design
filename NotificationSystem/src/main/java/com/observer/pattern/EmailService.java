package com.observer.pattern;

public class EmailService implements Subscriber {
    @Override
    public void handleEvent(Event event) {
        System.out.println("[EMAIL] Sending email: " + event.message);
    }
}
