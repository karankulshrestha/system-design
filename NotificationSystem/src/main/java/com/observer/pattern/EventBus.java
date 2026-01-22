package com.observer.pattern;

import java.util.*;

public class EventBus {
    // key -> Event Type
    // value -> list of subscriber
    private Map<String, List<Subscriber>> subscribers = new HashMap<>();

    // add a subscriber to the specific event
    public void subscribe(String eventType, Subscriber s) {
        subscribers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(s);
    }

    // when something happens notify all the subscribers
    public void publish(Event event) {
        List<Subscriber> userList = subscribers.get(event.type);
        if (userList != null) {
            for(Subscriber s: userList) {
                s.handleEvent(event);
            }
        }
    }

    // unsubscribe to the event
    public void unsubscribe(String eventType, Subscriber s) {
        List<Subscriber> userList = subscribers.get(eventType);
        if (userList != null) {
            userList.remove(s);
            System.out.println("[SYSTEM] A subscriber has opted out of: " + eventType);
        }
    }
}
