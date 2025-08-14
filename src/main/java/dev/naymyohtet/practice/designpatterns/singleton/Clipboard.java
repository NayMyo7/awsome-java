package dev.naymyohtet.practice.designpatterns.singleton;

/**
 * https://medium.com/javarevisited/mastering-design-patterns-in-java-1e39194ac480
 */
public class Clipboard {

    private String value;

    private static Clipboard clipboard = null;

    // private constructor to prevent instantiation form outside
    private Clipboard() {

    }

    // method to provide access to the singleton instance
    public static Clipboard getInstance() {
        if (clipboard == null) {
            clipboard = new Clipboard();
        }
        return clipboard;
    }

    public void copy(String value) {
        this.value = value;
    }

    public String paste() {
        return value;
    }

}
