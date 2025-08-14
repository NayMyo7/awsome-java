package dev.naymyohtet.practice.designpatterns.singleton;

public class Main {
    public static void main(String[] args) {

        // Get the singleton instances
        Clipboard clipboard1 = Clipboard.getInstance();
        Clipboard clipboard2 = Clipboard.getInstance();

        clipboard1.copy("Java");
        clipboard2.copy("Design Patterns");

        System.out.println(clipboard1.paste()); // output: Design patterns
        System.out.println(clipboard2.paste()); // output: Design patterns
    }
}
