package ru.artem.bot.listener;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.List;

public abstract class BotListener extends ListenerAdapter {
    protected List<String> commands;
    protected String prefix;

    public BotListener(String... commands) {
        this.commands = Arrays.asList(commands);
        this.prefix = ";"; // TODO: allow using custom prefix
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    protected boolean isValidSuffix(String userCmd) {
        userCmd = userCmd.strip().substring(1);
        for (String command : commands) {
            if (command.equals(userCmd)) {
                return true;
            }
        }
        return false;
    }

    protected boolean isValidCommand(GuildMessageReceivedEvent event) {
        String msgText = event.getMessage().getContentRaw();
        User author = event.getAuthor();
        return isValidSuffix(msgText) && !author.isBot();
    }
}
