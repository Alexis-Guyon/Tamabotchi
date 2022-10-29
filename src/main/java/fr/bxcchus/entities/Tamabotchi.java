package fr.bxcchus.entities;

public class Tamabotchi {
    private final int id;
    private final String name;
    private final int lvl;
    private final int hp;
    private final int happiness;
    private final int hydration;
    private final int hunger;
    private final Race race;
    private final Player player;

    public Tamabotchi(int id, String name, int lvl, int hp, int happiness, int hydration, int hunger, Race race, Player player) {
        this.id = id;
        this.name = name;
        this.lvl = lvl;
        this.hp = hp;
        this.happiness = happiness;
        this.hydration = hydration;
        this.hunger = hunger;
        this.race = race;
        this.player = player;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }

    public int getHp() {
        return hp;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHydration() {
        return hydration;
    }

    public int getHunger() {
        return hunger;
    }

    public Race getRace() {
        return race;
    }

    public Player getPlayer() {
        return player;
    }
}
