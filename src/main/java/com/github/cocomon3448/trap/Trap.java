package com.github.cocomon3448.trap;

import org.bukkit.plugin.java.JavaPlugin;

public class Trap extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        TrapLoader.init();
        TrapRecipe.init();
        getServer().getPluginManager().registerEvents(new FakeBlockTrapEvent(), this);
        getServer().getLogger().info("Traps Plugin Enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getLogger().info("Traps Plugin Disabled");
    }
}
