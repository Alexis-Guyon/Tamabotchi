package fr.bxcchus.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private static Database instance;
    private Connection connection;

    //
    public static Database getInstance() {
        if(instance == null) instance = new Database();
        return instance;
    }


    private Database() {
        try {
            String connectionUrl = "jdbc:mysql://localhost:3306/tamabotchidb";
            connection = DriverManager.getConnection(connectionUrl, "root", "root");
            System.out.println("MariaDB Ready!");

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM tamabotchidb.tamabotchi JOIN player ON player_id = player.id");
            while (rs.next()) {
                System.out.println("id:");
                System.out.println(rs.getString("id"));
                System.out.println();

                System.out.println("name:");
                System.out.println(rs.getString("name"));
                System.out.println();

                System.out.println("level:");
                System.out.println(rs.getString("level"));
                System.out.println();

                System.out.println("hp:");
                System.out.println(rs.getString("hp"));
                System.out.println();

                System.out.println("happiness:");
                System.out.println(rs.getString("happiness"));
                System.out.println();

                System.out.println("hydration:");
                System.out.println(rs.getString("hydration"));
                System.out.println();

                System.out.println("hunger:");
                System.out.println(rs.getString("hunger"));
                System.out.println();

                System.out.println("player_id:");
                System.out.println(rs.getString("player_id"));
                System.out.println();

                System.out.println("player_username:");
                System.out.println(rs.getString("player.username"));


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
