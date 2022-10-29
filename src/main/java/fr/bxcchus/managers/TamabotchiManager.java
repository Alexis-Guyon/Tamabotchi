package fr.bxcchus.managers;

import fr.bxcchus.entities.Death;
import fr.bxcchus.entities.Player;
import fr.bxcchus.entities.Race;
import fr.bxcchus.entities.Tamabotchi;
import fr.bxcchus.repositories.TamabotchiRepository;

import java.sql.SQLException;
import java.util.List;

public class TamabotchiManager {
    private static TamabotchiManager INSTANCE;

    public static TamabotchiManager getInstance() {
        if(INSTANCE == null) INSTANCE = new TamabotchiManager();
        return INSTANCE;
    }
    private TamabotchiManager() {}

    public boolean createTamabotchie(int id, String name, int level, int hp, int happiness, int hydration, int hunger, int raceId, String raceName, String uid, String username, int deathId, String cause, int poopness) throws SQLException {
        Race race = new Race(raceId, raceName);
        Player player = new Player(uid, username);
        Death death = new Death(deathId, cause);
        Tamabotchi tamabotchi = new Tamabotchi(id, name, level, hp, happiness, hydration, hunger, race, player, death, poopness);
        TamabotchiRepository.getInstance().addTamabotchi(tamabotchi);
        return true;

    }
    public boolean deleteTamabotchi(int id, String name, int level, int hp, int happiness, int hydration, int hunger, int raceId, String raceName, String uid, String username, int deathId, String cause, int poopness) throws SQLException {
        Race race = new Race(raceId, raceName);
        Player player = new Player(uid, username);
        Death death = new Death(deathId, cause);
        Tamabotchi tamabotchi = new Tamabotchi(id, name, level, hp, happiness, hydration, hunger, race, player, death, poopness);
        TamabotchiRepository.getInstance().removeTamabotchi(tamabotchi);
        return true;
    }
    public boolean updateTamabotchiPoop(int id, String name, int level, int hp, int happiness, int hydration, int hunger, int raceId, String raceName, String uid, String username, int deathId, String cause, int poopness) throws SQLException {
        Race race = new Race(raceId, raceName);
        Player player = new Player(uid, username);
        Death death = new Death(deathId, cause);
        Tamabotchi tamabotchi = new Tamabotchi(id, name, level, hp, happiness, hydration, hunger, race, player, death, poopness);
        TamabotchiRepository.getInstance().updateTamabotchiPoop(tamabotchi);
        return true;
    }
    public boolean updateTamabotchiHydration(int id, String name, int level, int hp, int happiness, int hydration, int hunger, int raceId, String raceName, String uid, String username, int deathId, String cause, int poopness) throws SQLException {
        Race race = new Race(raceId, raceName);
        Player player = new Player(uid, username);
        Death death = new Death(deathId, cause);
        Tamabotchi tamabotchi = new Tamabotchi(id, name, level, hp, happiness, hydration, hunger, race, player, death, poopness);
        TamabotchiRepository.getInstance().updateTamabotchiHydration(tamabotchi);
        return true;
    }
    public boolean updateTamabotchiHappiness(int id, String name, int level, int hp, int happiness, int hydration, int hunger, int raceId, String raceName, String uid, String username, int deathId, String cause, int poopness) throws SQLException {
        Race race = new Race(raceId, raceName);
        Player player = new Player(uid, username);
        Death death = new Death(deathId, cause);
        Tamabotchi tamabotchi = new Tamabotchi(id, name, level, hp, happiness, hydration, hunger, race, player, death, poopness);
        TamabotchiRepository.getInstance().updateTamabotchiHappiness(tamabotchi);
        return true;
    }

    public boolean updateTamabotchiHunger(int id, String name, int level, int hp, int happiness, int hydration, int hunger, int raceId, String raceName, String uid, String username, int deathId, String cause, int poopness) throws SQLException {
        Race race = new Race(raceId, raceName);
        Player player = new Player(uid, username);
        Death death = new Death(deathId, cause);
        Tamabotchi tamabotchi = new Tamabotchi(id, name, level, hp, happiness, hydration, hunger, race, player, death, poopness);
        TamabotchiRepository.getInstance().updateTamabotchiHunger(tamabotchi);
        return true;
    }


    public List<Tamabotchi> getTamabotchis() throws SQLException {
        return TamabotchiRepository.getInstance().getTamabotchis();
    }
}
