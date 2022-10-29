package fr.bxcchus.entities;

public class Player {
    private final String uid;
    private final String username;

    public Player(String uid, String username) {
        this.uid = uid;
        this.username = username;
    }

    public String getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }
}
