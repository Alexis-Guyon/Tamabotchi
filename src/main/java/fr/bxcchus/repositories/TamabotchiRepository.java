package fr.bxcchus.repositories;

import fr.bxcchus.database.Database;
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

        Database db = Database.getInstance();
        Statement statement = db.getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM tamabotchi JOIN player ON player_id = player.uid JOIN race ON race_id = race.id");

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

            Race race = new Race(raceId, raceName);
            Player player = new Player(playerUid, playerUsername);
            tamabotchis.add(new Tamabotchi(id, name, lvl, hp, happiness, hydration, hunger, race, player));
        }
        return tamabotchis;
    }

    public boolean addTamabotchi(Tamabotchi tamabotchi) throws SQLException {
        Database db = Database.getInstance();
        Statement statement = db.getConnection().createStatement();
        statement.executeUpdate("insert into tamabotchi (id, name, level, hp, happiness, hydration, hunger, race_id, player_id) VALUES(" + 0 + ",'" + tamabotchi.getName() + "'," + tamabotchi.getLvl() + "," + tamabotchi.getHp() + "," + tamabotchi.getHappiness() + "," + tamabotchi.getHydration() + "," + tamabotchi.getHunger() + "," + tamabotchi.getRace().getId() + ",'" + tamabotchi.getPlayer().getUid() +"');");
        return true;
    }

    public boolean removeTamabotchi(Tamabotchi tamabotchi) throws SQLException {
        Database db = Database.getInstance();
        Statement statement = db.getConnection().createStatement();
        statement.executeUpdate("delete from tamabotchi where id = " + tamabotchi.getId());
        return true;
    }
}
