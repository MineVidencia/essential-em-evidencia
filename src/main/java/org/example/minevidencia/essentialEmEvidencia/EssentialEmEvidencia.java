package org.example.minevidencia.essentialEmEvidencia;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class EssentialEmEvidencia extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("repair")).setExecutor(new Repair());
    }

    @Override
    public void onDisable() {
    }
}
