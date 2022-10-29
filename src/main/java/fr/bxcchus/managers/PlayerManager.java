package fr.bxcchus.managers;

import fr.bxcchus.entities.Player;
import fr.bxcchus.repositories.PlayerRepository;

import java.sql.SQLException;
import java.util.List;

public class PlayerManager {
    private static PlayerManager INSTANCE;

    public static PlayerManager getInstance() {
        if (INSTANCE == null) INSTANCE = new PlayerManager();
        return INSTANCE;
    }

    private PlayerManager() {}

    public boolean createPlayer(String uid, String username) throws SQLException {
        Player player = new Player(uid, username);
        PlayerRepository.getInstance().addPlayer(player);
        return true;

    }
    public boolean removePlayer(String uid, String username) throws SQLException {
        Player player = new Player(uid, username);
        PlayerRepository.getInstance().removePlayer(player);
        return true;
    }

    public List<Player> getPlayers() throws SQLException {
        return PlayerRepository.getInstance().getPlayers();
    }
}
