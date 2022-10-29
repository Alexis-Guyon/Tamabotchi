package fr.bxcchus.managers;

import fr.bxcchus.entities.Player;
import fr.bxcchus.entities.Race;
import fr.bxcchus.entities.Tamabotchi;
import fr.bxcchus.repositories.TamabotchiRepository;

import java.sql.SQLException;
import java.util.List;

public class TamabotchieManager {
    private static TamabotchieManager INSTANCE;

    public static TamabotchieManager getInstance() {
        if(INSTANCE == null) INSTANCE = new TamabotchieManager();
        return INSTANCE;
    }
    private TamabotchieManager() {}

    public boolean createTamabotchie(int id, String name, int level, int hp, int happiness, int hydration, int hunger, int raceId, String raceName, String uid, String username) throws SQLException {
        Race race = new Race(raceId, raceName);
        Player player = new Player(uid, username);
        Tamabotchi tamabotchi = new Tamabotchi(id, name, level, hp, happiness, hydration, hunger, race, player);
        TamabotchiRepository.getInstance().addTamabotchi(tamabotchi);
        return true;

    }
    public boolean deleteTamabotchi(int id, String name, int level, int hp, int happiness, int hydration, int hunger, int raceId, String raceName, String uid, String username) throws SQLException {
        Race race = new Race(raceId, raceName);
        Player player = new Player(uid, username);
        Tamabotchi tamabotchi = new Tamabotchi(id, name, level, hp, happiness, hydration, hunger, race, player);
        TamabotchiRepository.getInstance().removeTamabotchi(tamabotchi);
        return true;
    }

    public List<Tamabotchi> getTamabotchis() throws SQLException {
        return TamabotchiRepository.getInstance().getTamabotchis();
    }
}
