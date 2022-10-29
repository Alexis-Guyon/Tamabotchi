package fr.bxcchus.commands;

import fr.bxcchus.entities.Tamabotchi;
import fr.bxcchus.managers.PlayerManager;
import fr.bxcchus.managers.TamabotchiManager;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.SQLException;
import java.util.Objects;

public class DeleteCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        MessageChannelUnion channel = event.getMessage().getChannel();
        User author = event.getMessage().getAuthor();
        String message = event.getMessage().getContentRaw();

        if (message.equalsIgnoreCase("!delete")) {
            try {
                for (Tamabotchi tamabotchi : TamabotchiManager.getInstance().getTamabotchis()) {
                    if (Objects.equals(tamabotchi.getPlayer().getUid(), author.getId())) {
                        deleteTamabotchi(channel, tamabotchi);
                    } else {
                        channel.sendMessage("No Tamabotchi found..").queue();
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void deleteTamabotchi(MessageChannelUnion channel, Tamabotchi tamabotchi) throws SQLException {
        TamabotchiManager.getInstance().deleteTamabotchi(tamabotchi.getId(), tamabotchi.getName(), tamabotchi.getLvl(), tamabotchi.getHp(), tamabotchi.getHappiness(), tamabotchi.getHydration(), tamabotchi.getHunger(), tamabotchi.getRace().getId(), tamabotchi.getRace().getName(), tamabotchi.getPlayer().getUid(), tamabotchi.getPlayer().getUsername(), tamabotchi.getDeath().getId(), tamabotchi.getDeath().getCause(), tamabotchi.getPoopness());
        PlayerManager.getInstance().removePlayer(tamabotchi.getPlayer().getUid(), tamabotchi.getPlayer().getUsername());
        channel.sendMessage(tamabotchi.getName() + " is deleted").queue();
        return;
    }
}
