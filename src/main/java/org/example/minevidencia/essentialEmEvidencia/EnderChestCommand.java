package org.example.minevidencia.essentialEmEvidencia;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class EnderChestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        if (commandSender instanceof Player){
            Inventory enderChest = ((Player) commandSender).getEnderChest();
            ((Player) commandSender).openInventory(enderChest);
            commandSender.sendMessage(ChatColor.GREEN + "Ender Chest aberto");
            return true;
        }

        Bukkit.getServer().getLogger().info("Apenas players podem usar o ender chest");
        return false;
    }
}
