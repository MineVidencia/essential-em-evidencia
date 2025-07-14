package org.example.minevidencia.essentialEmEvidencia.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TimeCommand implements CommandExecutor {

    Player p = null;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player player){
            p = (Player) commandSender;
        }

        if (!commandSender.hasPermission("essentialevidencia.time")) {
            commandSender.sendMessage(ChatColor.RED + "Você não tem permissão para usar este comando.");
            Bukkit.getServer().getLogger().info("Você não tem permissão para usar este comando.");
            return false;
        }

        if (strings.length == 0) {
            if (!(commandSender instanceof Player player)){
                Bukkit.getServer().getLogger().info("Você precisa especificar o tempo e o mundo.");
                return false;
            }
            Long ticks = (p.getLocation().getWorld().getTime());
            p.sendMessage(tickToHour(ticks));
            return true;
        }
        if (strings.length == 1) {
            if (!(commandSender instanceof Player player)){
                commandSender.sendMessage(ChatColor.RED + "Você precisa especificar o tempo e o mundo.");
                return false;
            }

        }
        if (strings.length == 2) {

        }

        return false;
    }

    public String tickToHour(Long ticks) {
        double horasDecimais = ticks / 1000.0;
        int horas = (int) horasDecimais;
        int minutos = (int) Math.round((horasDecimais - horas) * 60);

        return (horas + ":" + minutos);
    }
}
