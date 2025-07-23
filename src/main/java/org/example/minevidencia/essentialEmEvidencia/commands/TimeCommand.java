package org.example.minevidencia.essentialEmEvidencia.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.minevidencia.essentialEmEvidencia.manager.TimeManager;
import org.jetbrains.annotations.NotNull;

public class TimeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!commandSender.hasPermission("essentialevidencia.time")) {
            commandSender.sendMessage(ChatColor.RED + "Você não tem permissão para usar este comando.");
            return true;
        }

        if (strings.length == 0) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "Do console, você precisa especificar um tempo e um mundo. Ex: /time day world");
                return true;
            }
            Player player = (Player) commandSender;
            long currentTicks = player.getWorld().getTime();

            player.sendMessage(ChatColor.GOLD + "O tempo atual é: " + TimeManager.tickToHour(currentTicks));
            return true;
        }

        if (strings.length == 1) {
            if (!(commandSender instanceof Player)){
                commandSender.sendMessage(ChatColor.RED + "Você precisa especificar o tempo e o mundo.");
                return true;
            }
            String timeInput = strings[0];

            try {
                long ticks = TimeManager.parseTimeToTicks(timeInput);
                Player player = (Player) commandSender;
                player.getWorld().setTime(ticks);
                player.sendMessage(ChatColor.GREEN + "Tempo alterado para " + timeInput + ".");

            } catch (IllegalArgumentException e) {
                commandSender.sendMessage(ChatColor.RED + "Valor de tempo '" + strings[0] + "' é inválido.");
            }
            return true;
        }

        if (strings.length == 2) {
            return true;
        }

        return false;
    }
}
