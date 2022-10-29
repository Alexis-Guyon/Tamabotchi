package fr.bxcchus.entities;

public class Death {
    private final int id;
    private final String cause;

    public Death(int id, String cause) {
        this.id = id;
        this.cause = cause;
    }

    public int getId() {
        return id;
    }

    public String getCause() {
        return cause;
    }
}
