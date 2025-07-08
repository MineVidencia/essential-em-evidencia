package org.example.minevidencia.essentialEmEvidencia.manager;

import org.bukkit.entity.Player;

public class FlyManager {
    public static void setFly(Player player, boolean can) {
        player.setAllowFlight(can);
        player.setFlying(can);
    }
}