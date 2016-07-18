package net.gr8bit.RoyalEnchantments.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;

import static net.gr8bit.RoyalEnchantments.Main.plugin;

/**
 * Created by Matt on 6/20/16.
 */
public class BlockPlaceListener implements Listener {

    @EventHandler
    public void placeBlock(BlockPlaceEvent e) {
        if(e.getBlock().getType().toString().toLowerCase().contains("ore")) {
            e.getBlock().setMetadata("blockplaced",new FixedMetadataValue(plugin,Boolean.valueOf(true)));
        }
    }
}
