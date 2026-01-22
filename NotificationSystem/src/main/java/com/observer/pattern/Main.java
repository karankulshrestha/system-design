package com.observer.pattern;


public class Main {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        EmailService emailService = new EmailService();
        PushService pushService = new PushService();

        eventBus.subscribe("NEW_POST", emailService);

        eventBus.subscribe("NEW_POST", pushService);
        eventBus.subscribe("FRIEND_REQ", pushService);

        System.out.println("--- Triggering New Post Event ---");
        eventBus.publish(new Event("NEW_POST", "User 'TechGeek' just posted a blog!"));

        System.out.println("\n--- Triggering Friend Request Event ---");
        eventBus.publish(new Event("FRIEND_REQ", "Bob sent you a friend request."));
    }
}