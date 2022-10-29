package fr.bxcchus.commands;

import fr.bxcchus.entities.Tamabotchi;
import fr.bxcchus.managers.TamabotchiManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.SQLException;
import java.util.Objects;

public class ShowCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        MessageChannelUnion channel = event.getMessage().getChannel();
        User author = event.getMessage().getAuthor();
        String message = event.getMessage().getContentRaw();

        if (message.equalsIgnoreCase("!show")) {
            try {
                if (TamabotchiManager.getInstance().getTamabotchis().isEmpty()) {
                    channel.sendMessage("No Tamabotchi found..").queue();
                }
                for (Tamabotchi tamabotchi : TamabotchiManager.getInstance().getTamabotchis()) {
                    if (Objects.equals(tamabotchi.getPlayer().getUid(), author.getId())) {
                        showTamabotchi(channel, tamabotchi);
                    } else {
                        channel.sendMessage("No Tamabotchi found..").queue();
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void showTamabotchi(MessageChannelUnion channel, Tamabotchi tamabotchi) throws SQLException {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Show command");
        eb.setDescription(tamabotchi.getName() + "'s information's");
        eb.addField("Name:", tamabotchi.getName(), false);
        eb.addField("Race:", tamabotchi.getRace().getName(), false);
        eb.addField("Level:", tamabotchi.getLvl() + "", false);
        eb.addField("HP:", tamabotchi.getHp() + "%", false);
        eb.addField("Happiness:", tamabotchi.getHappiness() + "%", false);
        eb.addField("Hydration:", tamabotchi.getHydration() + "%", false);
        eb.addField("Hunger:", tamabotchi.getHunger() + "%", false);
        eb.addField("Poopness:", tamabotchi.getPoopness() + "%", false);

        eb.addField("Owner:", tamabotchi.getPlayer().getUsername(), false);
        channel.sendMessageEmbeds(eb.build()).queue();
        return;
    }
}
