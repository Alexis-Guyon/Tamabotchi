package fr.bxcchus.repositories;

import fr.bxcchus.database.Database;
import fr.bxcchus.entities.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    private static PlayerRepository INSTANCE;

    public static PlayerRepository getInstance() {
        if (INSTANCE == null) INSTANCE = new PlayerRepository();
        return INSTANCE;
    }

    private PlayerRepository() {}

    public List<Player> getPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();

        String uid;
        String username;

        Database db = Database.getInstance();
        Statement statement = db.getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM player");

        while (rs.next()) {
            uid = rs.getString("uid");
            username = rs.getString("username");
            players.add(new Player(uid, username));
        }
        return players;
    }

    public boolean addPlayer(Player player) throws SQLException {
        Database db = Database.getInstance();
        Statement statement = db.getConnection().createStatement();
        statement.executeUpdate("insert into player (uid, username)" + "values ('" + player.getUid() + "','" + player.getUsername() + "');");
        return true;
    }

    public boolean removePlayer(Player player) throws SQLException {
        Database db = Database.getInstance();
        Statement statement = db.getConnection().createStatement();
        statement.executeUpdate("delete from player where uid = " + player.getUid());
        return true;
    }
}
