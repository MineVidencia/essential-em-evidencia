package org.example.minevidencia.essentialEmEvidencia;

import org.bukkit.plugin.java.JavaPlugin;
import org.example.minevidencia.essentialEmEvidencia.commands.FlyCommand;

public final class EssentialEmEvidencia extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(new FlyCommand());
    }

    @Override
    public void onDisable() {
    }
}
