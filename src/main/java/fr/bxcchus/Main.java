package fr.bxcchus;

import fr.bxcchus.commands.CreateCommand;
import fr.bxcchus.commands.DeleteCommand;
import fr.bxcchus.commands.PingCommand;
import fr.bxcchus.commands.ShowCommand;
import fr.bxcchus.database.Database;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;


public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        JDABuilder.createLight(DiscordToken.TOKEN,
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.DIRECT_MESSAGES,
                        GatewayIntent.MESSAGE_CONTENT)
                .setActivity(Activity.competing("Tamabotchi WIP..."))
                .addEventListeners(new PingCommand())
                .addEventListeners(new CreateCommand())
                .addEventListeners(new ShowCommand())
                .addEventListeners(new DeleteCommand())
                .build();

    }
}