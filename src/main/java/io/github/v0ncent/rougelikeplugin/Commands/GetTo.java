package io.github.v0ncent.rougelikeplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetTo implements CommandExecutor{
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

        double x1 = executor.getLocation().getX();
        double z1 = executor.getLocation().getZ();

        double x2 = target.getLocation().getX();
        double z2 = target.getLocation().getZ();

        double differenceOfX = x2 - x1;
        double differenceOfZ = z2 - z1;

        executor.sendMessage("To get to " + target.getName() + " go:");

        if (differenceOfX > 0) {
            executor.sendMessage(String.format("%d blocks East",Math.round(Math.abs(differenceOfX))));
        } else {
            executor.sendMessage(String.format("%d blocks West", Math.round(Math.abs(differenceOfX))));
        }

        executor.sendMessage("Then");

        if (differenceOfZ > 0) {
            executor.sendMessage(String.format("%d blocks South", Math.round(Math.abs(differenceOfZ))));
        } else {
            executor.sendMessage(String.format("%d blocks North", Math.round(Math.abs(differenceOfZ))));
        }

        executor.sendMessage(String.format("%s is currently at y level %d",target.getName(), Math.round(target.getLocation().getY())));

        return true;
    }
}
