package net.gr8bit.RoyalEnchantments.Listeners;

import net.gr8bit.RoyalEnchantments.Commands.ShardCmd;
import net.gr8bit.RoyalEnchantments.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by Matt on 6/8/16.
 */
public class InventoryListener implements Listener {

    @EventHandler
    public void invInteract(InventoryClickEvent e) {

        if(e.getInventory().equals(ShardCmd.getInv())) {
            Player p = (Player) e.getWhoClicked();

            e.setCancelled(true);
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aToggle All On")) {
                p.sendMessage("memes called");
                boolean doreopen = false;
                for (String et : Main.enchanttypes) {
                    boolean unlocked = Main.plugin.getConfig().getBoolean("royale." + p.getName() + "." + et + ".unlocked");
                    if (unlocked) {
                        Main.plugin.getConfig().set("royale." + p.getName() + "." + et + ".enabled", true);
                        Main.plugin.saveConfig();
                        doreopen = true;




                    }
                }
                if(doreopen) {
                    p.closeInventory();
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                        public void run() {
                            p.performCommand("shard");
                            p.sendMessage("reopen memes");

                        }
                    }, 0);
                }
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aToggle All Off")) {
                boolean doreopen = false;
                for (String et : Main.enchanttypes) {
                    boolean unlocked = Main.plugin.getConfig().getBoolean("royale." + p.getName() + "." + et + ".unlocked");
                    if (unlocked) {
                        Main.plugin.getConfig().set("royale." + p.getName() + "." + et + ".enabled", false);
                        Main.plugin.saveConfig();
                        doreopen =true;



                    }
                }
                if(doreopen) {
                    p.closeInventory();
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                        public void run() {
                            p.performCommand("shard");

                        }
                    }, 0);
                }
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§bPage 1")) {
                ShardCmd.InventoryPage.put(p.getName(), 0);
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                    public void run() {
                        p.performCommand("shard");

                    }
                }, 0);

            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§bPage 2")) {
                ShardCmd.InventoryPage.put(p.getName(), 1);
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                    public void run() {
                        p.performCommand("shard");

                    }
                }, 0);

            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§bPage 3")) {
                ShardCmd.InventoryPage.put(p.getName(), 2);
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                    public void run() {
                        p.performCommand("shard");

                    }
                }, 0);

            }

        }
    }


}
