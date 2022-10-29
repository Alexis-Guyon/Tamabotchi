package fr.bxcchus.commands;

import fr.bxcchus.entities.Player;
import fr.bxcchus.entities.Tamabotchi;
import fr.bxcchus.managers.PlayerManager;
import fr.bxcchus.managers.TamabotchieManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.SQLException;
import java.util.Objects;

public class CreateCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        MessageChannelUnion channel = event.getMessage().getChannel();
        User author = event.getMessage().getAuthor();
        String[] message = event.getMessage().getContentRaw().split(" ");
        String name;

        if (event.getAuthor().equals(event.getJDA().getSelfUser())) return;
        if (message.length == 1 && message[0].equalsIgnoreCase("!create")) {
            channel.sendMessage("Syntax: !create [name]").queue();
        } else if (message.length == 2 && message[0].equalsIgnoreCase("!create")){
            name = message[1];
            System.out.println(name);
            System.out.println(author.getIdLong());

            try {
                if (TamabotchieManager.getInstance().getTamabotchis().isEmpty() && PlayerManager.getInstance().getPlayers().isEmpty()) {
                    PlayerManager.getInstance().createPlayer(author.getId(), author.getName());
                    createTamabotchi(author.getId(), author.getName(), name, channel);
                    return;
                }

                for (Tamabotchi tamabotchi : TamabotchieManager.getInstance().getTamabotchis()) {
                    if (Objects.equals(tamabotchi.getPlayer().getUid(), author.getId())) {
                        channel.sendMessage(author.getName() + " you already have a Tamabotchi.\nUse: !show").queue();
                    } else {
                        if (!tamabotchi.getPlayer().getUid().contains(author.getId())) {
                            PlayerManager.getInstance().createPlayer(author.getId(), author.getName());
                        }
                        createTamabotchi(author.getId(), author.getName(), name, channel);
                    }
                    return;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else if (message.length > 2 && message[0].equalsIgnoreCase("!create")) {
            channel.sendMessage("Error: The name need to be collapsed").queue();
        } else {
            return;
        }
    }

    public void createTamabotchi(String id, String playerName, String tamabotchiName, MessageChannelUnion channel) throws SQLException {
        EmbedBuilder eb = new EmbedBuilder();
        System.out.println(tamabotchiName + " " + playerName);
        TamabotchieManager.getInstance().createTamabotchie(1, tamabotchiName, 1, 100, 100, 100, 100, 1, "Common", id, playerName);
        eb.setTitle("Creation..");
        eb.setDescription("Tamabotchi created");
        eb.addField("Name:", tamabotchiName, false);
        eb.addField("Race:", "Common", false);
        eb.addField("Level:", 1 + "", false);
        eb.addField("HP:", "100%", false);
        eb.addField("Happiness:", "100%", false);
        eb.addField("Hydration:", "100%", false);
        eb.addField("Hunger:", "100%", false);
        eb.addField("Owner:", playerName, false);
        channel.sendMessageEmbeds(eb.build()).queue();
        return;
    }
}
