package fr.bxcchus.repositories;

import fr.bxcchus.database.Database;
import fr.bxcchus.entities.Death;
import fr.bxcchus.entities.Player;
import fr.bxcchus.entities.Race;
import fr.bxcchus.entities.Tamabotchi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TamabotchiRepository {
    private static TamabotchiRepository INSTANCE;
    private String sql = "";


    public static TamabotchiRepository getInstance() {
        if (INSTANCE == null) INSTANCE = new TamabotchiRepository();
        return INSTANCE;
    }
    private TamabotchiRepository() {}

    public List<Tamabotchi> getTamabotchis() throws SQLException {
        List<Tamabotchi> tamabotchis = new ArrayList<>();

        int id;
        String name;
        int lvl;
        int hp;
        int happiness;
        int hydration;
        int hunger;


        int raceId;
        String raceName;

        String playerUid;
        String playerUsername;

        int deathId;
        String cause;

        int poopness;

        Database db = Database.getInstance();
        Statement statement = db.getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM tamabotchi JOIN player ON player_id = player.uid JOIN race ON race_id = race.id JOIN death ON death_id = death.id");

        while (rs.next()) {
            id = rs.getInt("id");
            name = rs.getString("name");
            lvl = rs.getInt("level");
            hp = rs.getInt("hp");
            happiness = rs.getInt("happiness");
            hydration = rs.getInt("hydration");
            hunger = rs.getInt("hunger");

            raceId = rs.getInt("race_id");
            raceName = rs.getString("race.name");

            playerUid = rs.getString("player_id");
            playerUsername = rs.getString("player.username");

            deathId = rs.getInt("death_id");
            cause = rs.getString("death.cause");

            poopness = rs.getInt("poopness");


            Race race = new Race(raceId, raceName);
            Player player = new Player(playerUid, playerUsername);
            Death death = new Death(deathId, cause);
            tamabotchis.add(new Tamabotchi(id, name, lvl, hp, happiness, hydration, hunger, race, player, death, poopness));
        }
        return tamabotchis;
    }

    public boolean addTamabotchi(Tamabotchi tamabotchi) throws SQLException {
        Database db = Database.getInstance();
        Statement statement = db.getConnection().createStatement();
        statement.executeUpdate("insert into tamabotchi (id, name, level, hp, happiness, hydration, hunger, race_id, player_id, death_id, poopness) VALUES(" + 0 + ",'" + tamabotchi.getName() + "'," + tamabotchi.getLvl() + "," + tamabotchi.getHp() + "," + tamabotchi.getHappiness() + "," + tamabotchi.getHydration() + "," + tamabotchi.getHunger() + "," + tamabotchi.getRace().getId() + ",'" + tamabotchi.getPlayer().getUid() +"'," + tamabotchi.getDeath().getId() + "," + tamabotchi.getPoopness() + ");");
        return true;
    }

    public boolean removeTamabotchi(Tamabotchi tamabotchi) throws SQLException {
        Database db = Database.getInstance();
        Statement statement = db.getConnection().createStatement();
        statement.executeUpdate("delete from tamabotchi where id = " + tamabotchi.getId());
        return true;
    }

    public boolean updateTamabotchiPoop(Tamabotchi tamabotchi) throws SQLException {
        Database db = Database.getInstance();
        int poopness = tamabotchi.getPoopness() - 1;

        int hp = tamabotchi.getHp() - 4;
        Statement statement = db.getConnection().createStatement();

        switch (tamabotchi.getHappiness()) {
            case 80, 20, 40, 0, 60 -> {
                sql = "UPDATE tamabotchi SET hp = " + hp + " WHERE id = " + tamabotchi.getId();
                statement.executeUpdate(sql);
            }
        }
        sql = "UPDATE tamabotchi SET poopness = " + poopness + " WHERE id = " + tamabotchi.getId();
        statement.executeUpdate(sql);
        return true;
    }
    public boolean updateTamabotchiHunger(Tamabotchi tamabotchi) throws SQLException {
        Database db = Database.getInstance();
        int hunger = tamabotchi.getHunger() - 1;

        int hp = tamabotchi.getHp() - 4;
        Statement statement = db.getConnection().createStatement();

        switch (tamabotchi.getHappiness()) {
            case 80, 20, 40, 0, 60 -> {
                sql = "UPDATE tamabotchi SET hp = " + hp + " WHERE id = " + tamabotchi.getId();
                statement.executeUpdate(sql);
            }
        }
        sql = "UPDATE tamabotchi SET happiness = " + hunger + " WHERE id = " + tamabotchi.getId();
        statement.executeUpdate(sql);
        return true;
    }
    public boolean updateTamabotchiHydration(Tamabotchi tamabotchi) throws SQLException {
        Database db = Database.getInstance();
        int hydration = tamabotchi.getHunger() - 1;

        int hp = tamabotchi.getHp() - 4;
        Statement statement = db.getConnection().createStatement();

        switch (tamabotchi.getHappiness()) {
            case 80, 20, 40, 0, 60 -> {
                sql = "UPDATE tamabotchi SET hp = " + hp + " WHERE id = " + tamabotchi.getId();
                statement.executeUpdate(sql);
            }
        }
        sql = "UPDATE tamabotchi SET hydration = " + hydration + " WHERE id = " + tamabotchi.getId();
        statement.executeUpdate(sql);
        return true;
    }
    public boolean updateTamabotchiHappiness(Tamabotchi tamabotchi) throws SQLException {
        Database db = Database.getInstance();
        int happiness = tamabotchi.getHappiness() - 1;

        int hp = tamabotchi.getHp() - 4;
        Statement statement = db.getConnection().createStatement();

        switch (tamabotchi.getHappiness()) {
            case 80, 20, 40, 0, 60 -> {
                sql = "UPDATE tamabotchi SET hp = " + hp + " WHERE id = " + tamabotchi.getId();
                statement.executeUpdate(sql);
            }
        }
        sql = "UPDATE tamabotchi SET happiness = " + happiness + " WHERE id = " + tamabotchi.getId();
        statement.executeUpdate(sql);
        return true;
    }
}
