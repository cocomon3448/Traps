package com.github.cocomon3448.trap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class TrapLoader{

    public static ItemStack fakeBlockTrap;
    public static ItemStack nullMenu;
    public static ItemStack nextButton;
    public static ItemStack prevButton;
    public static ItemStack uninstallButton;

    public static void init() {
        createFakeBlockTrap();
        createNullMenu();
        createNextButton();
        createPrevButton();
        createUninstallTrapButton();
    }

    private static void createFakeBlockTrap() {
        ItemStack item = new ItemStack(Material.IRON_BLOCK,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Fake Block");
        meta.setLore(Arrays.asList("Place the block, and set the block type","LOL"));
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        fakeBlockTrap = item;
    }
    private static void createNullMenu() {
        ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLACK+" ");
        item.setItemMeta(meta);
        nullMenu = item;
    }
    private static void createNextButton() {
        ItemStack item = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_AQUA +"NEXT PAGE");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        nextButton = item;
    }
    private static void createPrevButton() {
        ItemStack item = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_AQUA +"Prev Page");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        prevButton = item;
    }
    private static void createUninstallTrapButton() {
        ItemStack item = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED +"Uninstall");
        item.setItemMeta(meta);
        uninstallButton = item;
    }
}