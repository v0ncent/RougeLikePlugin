package io.github.v0ncent.rougelikeplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetCoords implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        final Player executor = ((Player) sender).getPlayer();

        if (executor == null) {
            return false;
        }

        if (args.length > 1) {
            return false;
        }

        final Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            return false;
        }


        executor.sendMessage(
                String.format("Player %s is currently at x: %f y: %f z: %f",
                        target.getName(),
                        target.getLocation().getX(),
                        target.getLocation().getY(),
                        target.getLocation().getZ())
        );

        return true;
    }
}
