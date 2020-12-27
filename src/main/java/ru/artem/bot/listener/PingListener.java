package ru.artem.bot.listener;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

public class PingListener extends BotListener {

    public PingListener() {
        super("ping");
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (!isValidCommand(event)) {
            return;
        }
        String authorTag = event.getAuthor().getAsMention();
        TextChannel channel = event.getChannel();
        channel.sendMessage(authorTag + " pong!").queue();
    }
}
