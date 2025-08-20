package dev.naymyohtet.practice.designpatterns.observer2;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject {

    private String name;
    private List<Observer> subscribers = new ArrayList<>();

    public YoutubeChannel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void addSubscriber(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeSubscriber(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifySubscribers(YoutubeEvent event) {
        for (Observer observer : subscribers) {
            observer.notifyMe(name, event);
        }
    }

}
