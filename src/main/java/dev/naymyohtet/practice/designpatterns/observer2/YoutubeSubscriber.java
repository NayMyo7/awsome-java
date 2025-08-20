package dev.naymyohtet.practice.designpatterns.observer2;

public class YoutubeSubscriber implements Observer {

    private String name;

    public YoutubeSubscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void notifyMe(String youtubeChannelName, YoutubeEvent event) {
        System.out.println("Dear " + getName() + ", Notification from " + youtubeChannelName + ": " + event);
    }

}
