package io.github.v0ncent.rougelikeplugin.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class CommandUtil {

    public static boolean isSentByPlayer(CommandSender sender) {
        return sender instanceof Player;
    }
}
