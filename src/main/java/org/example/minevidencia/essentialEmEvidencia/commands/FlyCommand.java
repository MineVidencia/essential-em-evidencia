package org.example.minevidencia.essentialEmEvidencia.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.minevidencia.essentialEmEvidencia.manager.FlyManager;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player player)) return false;
        if (!player.hasPermission("essentialevidencia.fly")) return false;

        if (strings.length < 1) {
            if (!player.getAllowFlight()) {
                FlyManager.setFly(player, true);
                player.sendMessage("You are now flying!");
                return true;
            }
            FlyManager.setFly(player, false);
            player.sendMessage("You can't fly anymore!");
            return true;
        }
        Player target = Bukkit.getPlayer(strings[0]);
        if (target == null || !target.isOnline()) {
            player.sendMessage("Player is offline or don't exist");
            return false;
        }
        if (target.getAllowFlight()) {
            FlyManager.setFly(target, false);
            player.sendMessage("The player " + target.getName() + " can no longer fly");
            target.sendMessage("Your flight is now disabled");
            return true;
        }
        if (!target.getAllowFlight()) {
            FlyManager.setFly(target, true);
            player.sendMessage("The player " + target.getName() + " are now flying");
            target.sendMessage("You are now flying");
            return true;
        }

        if (strings.length > 2) {
            player.sendMessage("Use: /fly <player>");
            return false;
        }
        return false;
    }

}