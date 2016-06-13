package net.gr8bit.RoyalEnchantments.Listeners;

import net.gr8bit.RoyalEnchantments.Commands.ShardCmd;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static net.gr8bit.RoyalEnchantments.Commands.ShardCmd.InventoryPage;
import static net.gr8bit.RoyalEnchantments.Commands.ShardCmd.ItemsPerPage;
import static net.gr8bit.RoyalEnchantments.Main.enchanttypes;
import static net.gr8bit.RoyalEnchantments.Main.plugin;
import static net.gr8bit.RoyalEnchantments.Main.removeShard;

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
                for (String et : enchanttypes) {
                    boolean unlocked = plugin.getConfig().getBoolean("royale." + p.getName() + "." + et + ".unlocked");
                    if (unlocked) {
                        plugin.getConfig().set("royale." + p.getName() + "." + et + ".enabled", true);
                        plugin.saveConfig();
                        doreopen = true;




                    }
                }
                if(doreopen) {
                    p.closeInventory();
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            p.performCommand("shard");
                            p.sendMessage("reopen memes");

                        }
                    }, 0);
                }
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aToggle All Off")) {
                boolean doreopen = false;
                for (String et : enchanttypes) {
                    boolean unlocked = plugin.getConfig().getBoolean("royale." + p.getName() + "." + et + ".unlocked");
                    if (unlocked) {
                        plugin.getConfig().set("royale." + p.getName() + "." + et + ".enabled", false);
                        plugin.saveConfig();
                        doreopen =true;



                    }
                }
                if(doreopen) {
                    p.closeInventory();
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            p.performCommand("shard");

                        }
                    }, 0);
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
                    public void run() {
                        p.performCommand("shard");

                    }
                }, 0);

            }
            int slot = e.getSlot();
            int row = slot/9;
            int index = (slot%9)-1;
            int ip = InventoryPage.getOrDefault(p.getName(), 0);
            int item = ip*ItemsPerPage + row;
            if (item >= 0 && item < enchanttypes.size()) {
                String et = enchanttypes.get(item);
                if(e.getCurrentItem().getData().toString().equals("STAINED_CLAY(14)")) {

                    plugin.getConfig().set("royale." + p.getName() + "." + et + ".unlocked", true);
                    plugin.getConfig().set("royale."+p.getName() + "."+et+".level", plugin.getConfig().getInt("royale."+p.getName() + "."+et+".level", 0) + 1);
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
