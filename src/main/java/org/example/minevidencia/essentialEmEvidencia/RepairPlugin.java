package org.example.minevidencia.essentialEmEvidencia;

import org.bukkit.plugin.java.JavaPlugin;

public class RepairPlugin extends JavaPlugin {


    @Override
    public void onEnable() {
        getCommand("repair").setExecutor(new Repair());
    }
}
