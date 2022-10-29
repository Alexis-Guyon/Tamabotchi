package fr.bxcchus;

import fr.bxcchus.commands.CreateCommand;
import fr.bxcchus.commands.DeleteCommand;
import fr.bxcchus.commands.PingCommand;
import fr.bxcchus.commands.ShowCommand;
import fr.bxcchus.database.Database;
import fr.bxcchus.events.TamabotchiHappinessEvent;
import fr.bxcchus.events.TamabotchiHungerEvent;
import fr.bxcchus.events.TamabotchiHydrationEvent;
import fr.bxcchus.events.TamabotchiPoopnessEvent;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.Timer;


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
        Timer timer = new Timer();
        timer.schedule(new TamabotchiPoopnessEvent(), 1000, 50000);
        timer.schedule(new TamabotchiHungerEvent(), 1000, 10000);
        timer.schedule(new TamabotchiHydrationEvent(), 1000, 10000);
        timer.schedule(new TamabotchiHappinessEvent(), 1000, 30000);

    }
}