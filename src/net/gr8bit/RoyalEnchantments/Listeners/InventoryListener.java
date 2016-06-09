package net.gr8bit.RoyalEnchantments.Listeners;

import net.gr8bit.RoyalEnchantments.Commands.ShardCmd;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Matt on 6/8/16.
 */
public class InventoryListener implements Listener {

    @EventHandler
    public void invInteract(InventoryClickEvent e) {

        if(e.getInventory().equals(ShardCmd.getInv())) {

            e.setCancelled(true);
        }
    }


}
