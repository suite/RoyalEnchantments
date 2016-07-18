package net.gr8bit.RoyalEnchantments.Listeners;

import net.gr8bit.RoyalEnchantments.Commands.ShardCmd;
import net.gr8bit.RoyalEnchantments.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static net.gr8bit.RoyalEnchantments.Commands.ShardCmd.InventoryPage;
import static net.gr8bit.RoyalEnchantments.Commands.ShardCmd.ItemsPerPage;
import static net.gr8bit.RoyalEnchantments.Main.*;

/**
 * Created by Matt on 6/8/16.
 */
public class InventoryListener implements Listener {

    @EventHandler
    public void invInteract(InventoryClickEvent e) {
        if(e.getInventory().getName().equalsIgnoreCase("Royal Enchantment Menu")) {
            e.setCancelled(true);
        }

        if(e.getInventory().equals(ShardCmd.getInv())) {
            Player p = (Player) e.getWhoClicked();
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aToggle All On")) {
                if (p.hasPermission("royal.shard.vip")) {
                    boolean doreopen = false;
                    for (String et : enchanttypes) {
                        boolean unlocked = plugin.getConfig().getBoolean("royale." + p.getUniqueId() + "." + et + ".unlocked");
                        if (unlocked) {
                            plugin.getConfig().set("royale." + p.getUniqueId() + "." + et + ".enabled", true);
                            plugin.saveConfig();
                            doreopen = true;


                        }
                    }
                    if (doreopen) {
                        p.closeInventory();
                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                            public void run() {
                                p.performCommand("shard");

                            }
                        }, 0);
                    }
                }
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cToggle All Off")) {
                if (p.hasPermission("royal.shard.vip")) {
                    boolean doreopen = false;
                    for (String et : enchanttypes) {
                        boolean unlocked = plugin.getConfig().getBoolean("royale." + p.getUniqueId() + "." + et + ".unlocked");
                        if (unlocked) {
                            plugin.getConfig().set("royale." + p.getUniqueId() + "." + et + ".enabled", false);
                            plugin.saveConfig();
                            doreopen = true;


                        }
                    }
                    if (doreopen) {
                        p.closeInventory();
                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                            public void run() {
                                p.performCommand("shard");

                            }
                        }, 0);
                    }
                }
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§bPage 1")) {
                InventoryPage.put(p.getName(), 0);
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {
                        p.performCommand("shard");

                    }
                }, 0);

            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§bPage 2")) {
                InventoryPage.put(p.getName(), 1);
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {
                        p.performCommand("shard");

                    }
                }, 0);

            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§bPage 3")) {
                InventoryPage.put(p.getName(), 2);
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run(

                    ) {
                        p.performCommand("shard");

                    }
                }, 0);

            }



            String enchanttype = e.getCurrentItem().getItemMeta().getDisplayName().replace(" ", "_");
            for(String enchantypez : enchanttypes) {
                if(enchantypez.equals(ChatColor.stripColor(enchanttype))) {
                    boolean unlocked = plugin.getConfig().getBoolean("royale." + p.getUniqueId() + "." + ChatColor.stripColor(enchanttype)
                            + ".unlocked");
                    boolean enabled = plugin.getConfig().getBoolean("royale." + p.getUniqueId() + "." + ChatColor.stripColor(enchanttype)
                            + ".enabled");
                    if (unlocked && !enabled) {

                        Main.plugin.getConfig().set("royale." + p.getUniqueId() + "." + ChatColor.stripColor(enchanttype)
                                + ".enabled", true);
                        plugin.saveConfig();
                        p.closeInventory();


                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                            public void run() {
                                p.performCommand("shard");


                            }
                        }, 10);
                    } else   if (unlocked && enabled) {
                        Main.plugin.getConfig().set("royale." + p.getUniqueId() + "." + ChatColor.stripColor(enchanttype)
                                + ".enabled", false
                        );
                        plugin.saveConfig();
                        p.closeInventory();

                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                            public void run() {
                                p.performCommand("shard");


                            }
                        }, 10);



                    }
                }



            }
            int slot = e.getSlot();
            int row = slot/9;
            int index = (slot%9)-1;
            int ip = InventoryPage.getOrDefault(p.getName(), 0);
            int item = ip*ItemsPerPage + row;
            if (item >= 0 && item < enchanttypes.size()) {
                String et = enchanttypes.get(item);
                if(e.getCurrentItem().getData().toString().equals("STAINED_CLAY(14)")) {

                    plugin.getConfig().set("royale." + p.getUniqueId() + "." + et + ".unlocked", true);
                    plugin.getConfig().set("royale."+p.getUniqueId() + "."+et+".level", plugin.getConfig().getInt("royale."+p.getUniqueId() + "."+et+".level", 0) + 1);
                    removeShard(p, ShardCmd.ItemMap.get(et).getUpgradeamount()[index]);

                    plugin.saveConfig();
                    p.closeInventory();



                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {
                        p.performCommand("shard");

                    }
                }, 0);

            }

        }
    }


}
