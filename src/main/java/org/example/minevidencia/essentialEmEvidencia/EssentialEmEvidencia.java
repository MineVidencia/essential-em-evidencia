package org.example.minevidencia.essentialEmEvidencia;

import org.bukkit.plugin.java.JavaPlugin;
import org.example.minevidencia.essentialEmEvidencia.commands.FlyCommand;
import org.example.minevidencia.essentialEmEvidencia.commands.TimeCommand;

import java.util.Objects;

public final class EssentialEmEvidencia extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(new FlyCommand());
        Objects.requireNonNull(getCommand("repair")).setExecutor(new Repair());
        getCommand("enderchest").setExecutor(new EnderChestCommand());
        getCommand("time").setExecutor(new TimeCommand());
    }

    @Override
    public void onDisable() {
    }
}
