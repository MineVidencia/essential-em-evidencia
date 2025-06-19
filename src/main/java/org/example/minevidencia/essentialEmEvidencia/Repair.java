package org.example.minevidencia.essentialEmEvidencia;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Repair implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String name, String[] args) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "Apenas jogadores podem usar este comando.");
            return true;
        }

        Player player = (Player) commandSender;

        if (args.length == 0 || args[0].equalsIgnoreCase("hand")) {
            ItemStack item = player.getInventory().getItemInMainHand();

            if (item == null || item.getType() == Material.AIR) {
                player.sendMessage(ChatColor.RED + "Você precisa estar segurando um item.");
                return true;
            }

            if(item.getType().getMaxDurability() > 0){
                if(item.getDurability() > 0){
                    item.setDurability((short) 0);
                    player.sendMessage(ChatColor.GREEN + "Item reparado com sucesso!");
                } else {
                    player.sendMessage(ChatColor.YELLOW + "Este item não precisa de reparo");
                }
                return true;
            } else {
                player.sendMessage(ChatColor.RED + "Esse item não pode ser reparado!");
            }
            return true;

        } else if (args[0].equalsIgnoreCase("all")) {
            ItemStack[] contents = player.getInventory().getContents();
            int reparados = 0;

            for (ItemStack item : contents) {
                if (item != null && item.getType().getMaxDurability() > 0 && item.getDurability() > 0) {
                    item.setDurability((short) 0);
                    reparados++;
                }
            }

            if (reparados == 0) {
                player.sendMessage(ChatColor.YELLOW + "Sem itens para reparar.");
            } else {
                player.sendMessage(ChatColor.GREEN + "Reparados " + reparados + " item(s) com sucesso!");
            }
            return true;

        } else {
            player.sendMessage(ChatColor.RED + "Uso correto: /repair [hand] ou [all]");
            return true;
        }
    }
}
