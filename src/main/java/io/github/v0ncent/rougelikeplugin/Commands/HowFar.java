package io.github.v0ncent.rougelikeplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HowFar implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!CommandUtil.isSentByPlayer(sender)) return false;

        final Player executor = ((Player) sender).getPlayer();

        if (executor == null) return false;

        if (args.length > 1) return false;

        final Player target = Bukkit.getPlayer(args[0]);

        if (target == null) return false;

        if (!executor.getWorld().getEnvironment().equals(target.getWorld().getEnvironment())) {
            executor.sendMessage("Player is currently in %s", target.getWorld().getEnvironment().toString());
            return true;
        }

        executor.sendMessage(
                String.format(
                        "Player %s is %f blocks away from you",
                        target.getName(),
                        Math.sqrt((int) target.getLocation().getX()^2 + (int) target.getLocation().getZ()^2)

                )
        );

        return true;
    }

}
