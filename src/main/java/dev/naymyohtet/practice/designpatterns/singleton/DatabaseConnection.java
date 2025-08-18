package dev.naymyohtet.practice.designpatterns.singleton;

public class DatabaseConnection {
    private static DatabaseConnection instance;

    // prevent instantiation from outside
    private DatabaseConnection(){

    }

    // provide access to the singleton instance
    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
