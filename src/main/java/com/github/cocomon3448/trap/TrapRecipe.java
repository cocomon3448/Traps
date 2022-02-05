package com.github.cocomon3448.trap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class TrapRecipe {
    public static void init() {
        createFakeBlockTrapRecipe();
    }
    public static void createFakeBlockTrapRecipe() {
        NamespacedKey fakeBlockTrapKey = new NamespacedKey(Bukkit.getServer().getPluginManager().getPlugin("Trap"), "fakeBlockTrap");
        ShapedRecipe fakeBlockTrap = new ShapedRecipe(fakeBlockTrapKey,TrapLoader.fakeBlockTrap);
        fakeBlockTrap.shape("RRR","RIR","RRR");
        fakeBlockTrap.setIngredient('R', Material.REDSTONE);
        fakeBlockTrap.setIngredient('I', Material.IRON_BLOCK);
        Bukkit.addRecipe(fakeBlockTrap);
    }
}
