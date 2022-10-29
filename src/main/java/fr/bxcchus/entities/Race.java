package fr.bxcchus.entities;

public class Race {
    private final int id;
    private String name;

    public Race(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Race(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
