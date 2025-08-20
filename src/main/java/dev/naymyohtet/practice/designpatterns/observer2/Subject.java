package dev.naymyohtet.practice.designpatterns.observer2;

public interface Subject {
    void addSubscriber(Observer observer);

    void removeSubscriber(Observer observer);

    void notifySubscribers(YoutubeEvent event);
}
