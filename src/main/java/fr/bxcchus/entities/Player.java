package fr.bxcchus.entities;

public class Player {
    private final  int id;
    private final  long uid;
    private final String username;

    public Player(int id, long uid, String username) {
        this.id = id;
        this.uid = uid;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public long getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }
}
