package dev.naymyohtet.practice.designpatterns.builder;

public class Main {
    public static void main(String[] args) {
        UserProfile userProfile = new UserProfile.Builder()
                .name("John Smith")
                .email("johnsmith@gmail.com")
                .age(30)
                .build();
        System.out.println("User profile: " + userProfile);

        UserProfile userProfile2 = new UserProfile.Builder()
                .name("Angel")
                .build();
        System.out.println("User profile: " + userProfile2);
    }
}
