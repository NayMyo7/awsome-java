package dev.naymyohtet.practice.designpatterns.observer2;

public class ObserverMain {

    public static void main(String[] args) throws InterruptedException {
        YoutubeChannel myChannel = new YoutubeChannel("MyChannel");

        Observer john = new YoutubeSubscriber("John");
        Observer bob = new YoutubeSubscriber("Bob");
        Observer tom = new YoutubeSubscriber("Tom");

        myChannel.addSubscriber(john);
        myChannel.addSubscriber(bob);
        myChannel.addSubscriber(tom);
        myChannel.notifySubscribers(new YoutubeEvent(EventType.NEW_VIDEO, "Design Patterns"));

        myChannel.removeSubscriber(tom);
        System.out.println();
        Thread.sleep(5000);
        myChannel.notifySubscribers(new YoutubeEvent(EventType.LIVE_STREAM, "Java for beginners"));
    }

}
