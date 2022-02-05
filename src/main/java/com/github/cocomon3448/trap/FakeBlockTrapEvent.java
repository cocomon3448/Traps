package com.github.cocomon3448.trap;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Objects;

public class FakeBlockTrapEvent implements Listener {

    private static ItemStack[] menuBlocks1 = {new ItemStack(Material.STONE), new ItemStack(Material.GRANITE), new ItemStack(Material.POLISHED_GRANITE), new ItemStack(Material.DIORITE), new ItemStack(Material.POLISHED_DIORITE), new ItemStack(Material.ANDESITE), new ItemStack(Material.POLISHED_ANDESITE), new ItemStack(Material.DEEPSLATE), new ItemStack(Material.COBBLED_DEEPSLATE), new ItemStack(Material.POLISHED_DEEPSLATE),
            new ItemStack(Material.CALCITE), new ItemStack(Material.TUFF), new ItemStack(Material.DRIPSTONE_BLOCK), new ItemStack(Material.GRASS_BLOCK), new ItemStack(Material.DIRT), new ItemStack(Material.COARSE_DIRT), new ItemStack(Material.PODZOL), new ItemStack(Material.ROOTED_DIRT), new ItemStack(Material.CRIMSON_NYLIUM),
            new ItemStack(Material.WARPED_NYLIUM), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.SPRUCE_PLANKS), new ItemStack(Material.BIRCH_PLANKS), new ItemStack(Material.JUNGLE_PLANKS), new ItemStack(Material.ACACIA_PLANKS), new ItemStack(Material.DARK_OAK_PLANKS), new ItemStack(Material.CRIMSON_PLANKS),
            new ItemStack(Material.WARPED_PLANKS), new ItemStack(Material.OAK_SAPLING), new ItemStack(Material.SPRUCE_SAPLING), new ItemStack(Material.BIRCH_SAPLING), new ItemStack(Material.JUNGLE_SAPLING), new ItemStack(Material.ACACIA_SAPLING), new ItemStack(Material.DARK_OAK_SAPLING), new ItemStack(Material.BEDROCK), new ItemStack(Material.SAND),
            new ItemStack(Material.RED_SAND), new ItemStack(Material.GRAVEL), new ItemStack(Material.COAL_ORE), new ItemStack(Material.DEEPSLATE_COAL_ORE), new ItemStack(Material.IRON_ORE), new ItemStack(Material.DEEPSLATE_IRON_ORE), new ItemStack(Material.COPPER_ORE), new ItemStack(Material.DEEPSLATE_COPPER_ORE),
            TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nextButton};
    private static ItemStack[] menuBlocks2 = {new ItemStack(Material.GOLD_ORE), new ItemStack(Material.DEEPSLATE_GOLD_ORE), new ItemStack(Material.REDSTONE_ORE), new ItemStack(Material.DEEPSLATE_REDSTONE_ORE), new ItemStack(Material.EMERALD_ORE), new ItemStack(Material.DEEPSLATE_EMERALD_ORE), new ItemStack(Material.LAPIS_ORE), new ItemStack(Material.DEEPSLATE_LAPIS_ORE), new ItemStack(Material.DIAMOND_ORE), new ItemStack(Material.DEEPSLATE_DIAMOND_ORE),
            new ItemStack(Material.NETHER_GOLD_ORE), new ItemStack(Material.NETHER_QUARTZ_ORE), new ItemStack(Material.ANCIENT_DEBRIS), new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.RAW_IRON_BLOCK), new ItemStack(Material.RAW_COPPER_BLOCK), new ItemStack(Material.RAW_GOLD_BLOCK), new ItemStack(Material.AMETHYST_BLOCK), new ItemStack(Material.BUDDING_AMETHYST),
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.COPPER_BLOCK), new ItemStack(Material.GOLD_BLOCK), new ItemStack(Material.DIAMOND_BLOCK), new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.EXPOSED_COPPER), new ItemStack(Material.WEATHERED_COPPER), new ItemStack(Material.OXIDIZED_COPPER), new ItemStack(Material.CUT_COPPER),
            new ItemStack(Material.EXPOSED_CUT_COPPER), new ItemStack(Material.WEATHERED_CUT_COPPER), new ItemStack(Material.OXIDIZED_CUT_COPPER), new ItemStack(Material.CUT_COPPER_STAIRS), new ItemStack(Material.EXPOSED_CUT_COPPER_STAIRS), new ItemStack(Material.WEATHERED_CUT_COPPER_STAIRS), new ItemStack(Material.OXIDIZED_CUT_COPPER_STAIRS), new ItemStack(Material.CUT_COPPER_SLAB), new ItemStack(Material.EXPOSED_CUT_COPPER_SLAB),
            new ItemStack(Material.WEATHERED_CUT_COPPER_SLAB), new ItemStack(Material.OXIDIZED_CUT_COPPER_SLAB), new ItemStack(Material.WAXED_COPPER_BLOCK), new ItemStack(Material.WAXED_EXPOSED_COPPER), new ItemStack(Material.WAXED_WEATHERED_COPPER), new ItemStack(Material.WAXED_OXIDIZED_COPPER), new ItemStack(Material.WAXED_CUT_COPPER), new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER),
            TrapLoader.prevButton, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nextButton};
    private static ItemStack[] menuBlocks3 = {new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER), new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER), new ItemStack(Material.WAXED_CUT_COPPER_STAIRS), new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER_STAIRS), new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER_STAIRS), new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER_STAIRS), new ItemStack(Material.WAXED_CUT_COPPER_SLAB), new ItemStack(Material.WAXED_EXPOSED_CUT_COPPER_SLAB), new ItemStack(Material.WAXED_WEATHERED_CUT_COPPER_SLAB), new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER_SLAB),
            new ItemStack(Material.OAK_LOG), new ItemStack(Material.SPRUCE_LOG), new ItemStack(Material.BIRCH_LOG), new ItemStack(Material.JUNGLE_LOG), new ItemStack(Material.ACACIA_LOG), new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.CRIMSON_STEM), new ItemStack(Material.WARPED_STEM), new ItemStack(Material.STRIPPED_OAK_LOG),
            new ItemStack(Material.STRIPPED_SPRUCE_LOG), new ItemStack(Material.STRIPPED_BIRCH_LOG), new ItemStack(Material.STRIPPED_JUNGLE_LOG), new ItemStack(Material.STRIPPED_ACACIA_LOG), new ItemStack(Material.STRIPPED_DARK_OAK_LOG), new ItemStack(Material.STRIPPED_CRIMSON_STEM), new ItemStack(Material.STRIPPED_WARPED_STEM), new ItemStack(Material.STRIPPED_OAK_WOOD), new ItemStack(Material.STRIPPED_SPRUCE_WOOD),
            new ItemStack(Material.STRIPPED_BIRCH_WOOD), new ItemStack(Material.STRIPPED_JUNGLE_WOOD), new ItemStack(Material.STRIPPED_ACACIA_WOOD), new ItemStack(Material.STRIPPED_DARK_OAK_WOOD), new ItemStack(Material.STRIPPED_CRIMSON_HYPHAE), new ItemStack(Material.STRIPPED_WARPED_HYPHAE), new ItemStack(Material.OAK_WOOD), new ItemStack(Material.SPRUCE_WOOD), new ItemStack(Material.BIRCH_WOOD),
            new ItemStack(Material.JUNGLE_WOOD), new ItemStack(Material.ACACIA_WOOD), new ItemStack(Material.DARK_OAK_WOOD), new ItemStack(Material.CRIMSON_HYPHAE), new ItemStack(Material.WARPED_HYPHAE), new ItemStack(Material.OAK_LEAVES), new ItemStack(Material.SPRUCE_LEAVES), new ItemStack(Material.BIRCH_LEAVES),
            TrapLoader.prevButton, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nextButton};
    private static ItemStack[] menuBlocks4 = {new ItemStack(Material.JUNGLE_LEAVES), new ItemStack(Material.ACACIA_LEAVES), new ItemStack(Material.DARK_OAK_LEAVES), new ItemStack(Material.AZALEA_LEAVES), new ItemStack(Material.FLOWERING_AZALEA_LEAVES),
            new ItemStack(Material.SPONGE), new ItemStack(Material.WET_SPONGE), new ItemStack(Material.GLASS), new ItemStack(Material.TINTED_GLASS), new ItemStack(Material.LAPIS_BLOCK),
            new ItemStack(Material.SANDSTONE), new ItemStack(Material.CHISELED_SANDSTONE), new ItemStack(Material.CUT_SANDSTONE), new ItemStack(Material.COBWEB), new ItemStack(Material.GRASS), new ItemStack(Material.FERN), new ItemStack(Material.AZALEA), new ItemStack(Material.FLOWERING_AZALEA), new ItemStack(Material.DEAD_BUSH),
            new ItemStack(Material.SEAGRASS), new ItemStack(Material.SEA_PICKLE), new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.ORANGE_WOOL), new ItemStack(Material.MAGENTA_WOOL), new ItemStack(Material.LIGHT_BLUE_WOOL), new ItemStack(Material.YELLOW_WOOL), new ItemStack(Material.LIME_WOOL), new ItemStack(Material.PINK_WOOL),
            new ItemStack(Material.GRAY_WOOL), new ItemStack(Material.LIGHT_GRAY_WOOL), new ItemStack(Material.CYAN_WOOL), new ItemStack(Material.PURPLE_WOOL), new ItemStack(Material.BLUE_WOOL), new ItemStack(Material.BROWN_WOOL), new ItemStack(Material.GREEN_WOOL), new ItemStack(Material.RED_WOOL), new ItemStack(Material.BLACK_WOOL),
            new ItemStack(Material.DANDELION), new ItemStack(Material.POPPY), new ItemStack(Material.BLUE_ORCHID), new ItemStack(Material.ALLIUM), new ItemStack(Material.AZURE_BLUET), new ItemStack(Material.RED_TULIP),
            new ItemStack(Material.ORANGE_TULIP), new ItemStack(Material.WHITE_TULIP),
            TrapLoader.prevButton, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nextButton};
    private static ItemStack[] menuBlocks5 = {new ItemStack(Material.PINK_TULIP), new ItemStack(Material.OXEYE_DAISY), new ItemStack(Material.CORNFLOWER), new ItemStack(Material.LILY_OF_THE_VALLEY), new ItemStack(Material.WITHER_ROSE), new ItemStack(Material.SPORE_BLOSSOM), new ItemStack(Material.BROWN_MUSHROOM), new ItemStack(Material.RED_MUSHROOM), new ItemStack(Material.CRIMSON_FUNGUS), new ItemStack(Material.WARPED_FUNGUS),
            new ItemStack(Material.CRIMSON_ROOTS), new ItemStack(Material.WARPED_ROOTS), new ItemStack(Material.NETHER_SPROUTS), new ItemStack(Material.WEEPING_VINES), new ItemStack(Material.TWISTING_VINES), new ItemStack(Material.SUGAR_CANE), new ItemStack(Material.KELP), new ItemStack(Material.MOSS_CARPET), new ItemStack(Material.MOSS_BLOCK),
            new ItemStack(Material.HANGING_ROOTS), new ItemStack(Material.BIG_DRIPLEAF), new ItemStack(Material.SMALL_DRIPLEAF), new ItemStack(Material.BAMBOO), new ItemStack(Material.OAK_SLAB), new ItemStack(Material.SPRUCE_SLAB), new ItemStack(Material.BIRCH_SLAB), new ItemStack(Material.JUNGLE_SLAB), new ItemStack(Material.ACACIA_SLAB),
            new ItemStack(Material.DARK_OAK_SLAB), new ItemStack(Material.CRIMSON_SLAB), new ItemStack(Material.WARPED_SLAB), new ItemStack(Material.STONE_SLAB), new ItemStack(Material.SMOOTH_STONE_SLAB), new ItemStack(Material.SANDSTONE_SLAB), new ItemStack(Material.CUT_SANDSTONE_SLAB), new ItemStack(Material.PETRIFIED_OAK_SLAB), new ItemStack(Material.COBBLESTONE_SLAB),
            new ItemStack(Material.BRICK_SLAB), new ItemStack(Material.STONE_BRICK_SLAB), new ItemStack(Material.NETHER_BRICK_SLAB), new ItemStack(Material.QUARTZ_SLAB), new ItemStack(Material.RED_SANDSTONE_SLAB), new ItemStack(Material.CUT_RED_SANDSTONE_SLAB), new ItemStack(Material.PURPUR_SLAB), new ItemStack(Material.PRISMARINE_SLAB),
            TrapLoader.prevButton, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu, TrapLoader.nullMenu};
    private static ItemStack[] settingMenu1 = {TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,
            TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.uninstallButton,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,
            TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,TrapLoader.nullMenu,};

    @EventHandler
    public static void onPlace(BlockPlaceEvent e) {
        Location loc = e.getBlock().getLocation();
        Player p = e.getPlayer();
        if (Objects.requireNonNull(p.getInventory().getItemInMainHand().getItemMeta()).equals(TrapLoader.fakeBlockTrap.getItemMeta())) {
            System.out.println("1e");
            Inventory Select_block = Bukkit.createInventory(p, 54, ChatColor.YELLOW + "Select One"+" [1] "+ "("+(loc.getBlockX())+" "+loc.getBlockY()+" "+(loc.getBlockZ())+")");
            Select_block.setContents(menuBlocks1);
            p.openInventory(Select_block);
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().contains("Select One")) {
            String str = e.getView().getTitle();
            String[] loc = str.substring(str.indexOf("(")+1, str.indexOf(")")).split(" ");
            double[] parsed = new double[3];
            for (int a = 0; a <= 2; a++) {
                parsed[a] = Double.parseDouble(loc[a]);
            }
            Location pLoc = new Location(player.getWorld(),parsed[0],parsed[1],parsed[2]);
            int pageNo = Integer.parseInt(str.substring(str.indexOf("[")+1, str.indexOf("]")));

            if (e.getCurrentItem().getItemMeta().equals(TrapLoader.nullMenu.getItemMeta())) {
                player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 5, 1);
            } else if (e.getCurrentItem().getItemMeta().equals(TrapLoader.nextButton.getItemMeta())) {
                Inventory Select_block = Bukkit.createInventory(player, 54, ChatColor.YELLOW + "Select One " +  "[" +(pageNo + 1) +  "]"+ " ("+(pLoc.getBlockX())+" "+pLoc.getBlockY()+" "+(pLoc.getBlockZ())+")");
                switch (pageNo + 1) {
                    case 2:
                        Select_block.setContents(menuBlocks2);
                        break;
                    case 3:
                        Select_block.setContents(menuBlocks3);
                        break;
                    case 4:
                        Select_block.setContents(menuBlocks4);
                        break;
                    case 5:
                        Select_block.setContents(menuBlocks5);
                        break;
                }
                player.openInventory(Select_block);
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);
            } else if (e.getCurrentItem().getItemMeta().equals(TrapLoader.prevButton.getItemMeta())) {
                Inventory Select_block = Bukkit.createInventory(player, 54, ChatColor.YELLOW + "Select One " +  "[" +(pageNo - 1) +  "]"+ " ("+(pLoc.getBlockX())+" "+pLoc.getBlockY()+" "+(pLoc.getBlockZ())+")");
                switch (pageNo - 1) {
                    case 1:
                        Select_block.setContents(menuBlocks1);
                        break;
                    case 2:
                        Select_block.setContents(menuBlocks2);
                        break;
                    case 3:
                        Select_block.setContents(menuBlocks3);
                        break;
                    case 4:
                        Select_block.setContents(menuBlocks4);
                        break;
                }
                player.openInventory(Select_block);
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);
            } else {
                pLoc = new Location(pLoc.getWorld(), pLoc.getX()+0.5, pLoc.getY(), pLoc.getZ()+0.5);
                FallingBlock fBlc = Objects.requireNonNull(pLoc.getWorld()).spawnFallingBlock(pLoc, e.getCurrentItem().getType(), (byte) -1);
                fBlc.setGravity(false);
                fBlc.setDropItem(false);
                fBlc.setHurtEntities(true);
                fBlc.setTicksLived(2147483647);
                player.playSound(player.getLocation(), Sound.BLOCK_GROWING_PLANT_CROP, 5, 1);
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount()-1);
                player.closeInventory();
            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().contains("Settings")) {
            if(e.getCurrentItem().getItemMeta().equals(TrapLoader.uninstallButton.getItemMeta())) {
                String str = e.getView().getTitle();
                String[] loc = str.substring(str.indexOf("(")+1, str.indexOf(")")).split(" ");
                double[] parsed = new double[3];
                for (int a = 0; a <= 2; a++) {
                    parsed[a] = Double.parseDouble(loc[a]);
                }
                Location fBlkLoc = new Location(player.getWorld(), parsed[0], parsed[1], parsed[2]);
                List<Entity> nearbyEntites = (List<Entity>) player.getWorld().getNearbyEntities(fBlkLoc, 0.001, 0.001, 0.001);
                System.out.println(nearbyEntites);
                FallingBlock fBlk = null;
                for (int i = 0; i< nearbyEntites.size(); i++) {
                    if(nearbyEntites.get(i) instanceof FallingBlock) {
                        nearbyEntites.get(i).remove();
                        player.playSound(player.getLocation(),Sound.BLOCK_GROWING_PLANT_CROP,5,1);
                        player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount()+1);
                        player.closeInventory();
                        break;
                    }
                }
            } else if (e.getCurrentItem().getItemMeta().equals(TrapLoader.nullMenu.getItemMeta())) {
                player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 5, 1);
            }
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onEntityClick(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        if (e.getRightClicked() instanceof FallingBlock && !e.getRightClicked().hasGravity()){

            FallingBlock fBlk = (FallingBlock) e.getRightClicked();
            Location fBlkLoc = fBlk.getLocation();
            Inventory settingMenu = Bukkit.createInventory(player, 27, ChatColor.GRAY+"Settings"+ "("+fBlkLoc.getX()+" "+fBlkLoc.getY()+" "+fBlkLoc.getZ()+")");
            settingMenu.setContents(settingMenu1);
            player.openInventory(settingMenu);
        }


    }
}
