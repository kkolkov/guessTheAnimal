package database;

import java.util.HashMap;

public class InMemoryDb implements Database {
    private final HashMap<String, String> imdb = new HashMap<>();

    private InMemoryDb(){}

    public static InMemoryDb getInstance() {
        return new InMemoryDb();
    }
    public HashMap<String, String> getInMemoryDb() {
        return this.imdb;
    }
}