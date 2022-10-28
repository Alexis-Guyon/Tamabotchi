package fr.bxcchus.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        if(message.getContentRaw().equalsIgnoreCase("!Ping")) {
            message.getChannel().sendMessage("Pong!").queue();
        }
    }
}
