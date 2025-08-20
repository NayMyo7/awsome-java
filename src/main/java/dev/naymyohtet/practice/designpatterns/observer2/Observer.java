package dev.naymyohtet.practice.designpatterns.observer2;

public interface Observer {
    void notifyMe(String youtubeChannelName, YoutubeEvent event);
}
