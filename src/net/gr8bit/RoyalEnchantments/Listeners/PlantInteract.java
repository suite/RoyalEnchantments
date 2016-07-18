package net.gr8bit.RoyalEnchantments.Listeners;

import net.gr8bit.RoyalEnchantments.Main;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matt on 6/13/16.
 */
public class PlantInteract implements Listener {




    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK))//(e.getClickedBlock().equals(Material.DIRT) || e.getClickedBlock().equals(Material.GRASS)) ) {
        {
            if (e.getClickedBlock().getType().equals(Material.DIRT) || e.getClickedBlock().getType().equals(Material.GRASS)) {
                if (e.getPlayer().getItemInHand().getType().toString().toLowerCase().contains("hoe")) {
                    if (Main.willUseAbilityChance(e.getPlayer(), "Plant_Breeder")) {
                        if (!e.getClickedBlock().getRelative(BlockFace.UP).getType().equals(Material.LONG_GRASS)) {
                            double rand = Math.random();
                            if (rand <= 0.20) {
                                e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), new ItemStack(Material.BEETROOT_SEEDS));

                            } else if (rand <= 0.30) {
                                e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), new ItemStack(Material.SEEDS));

                            } else if (rand <= 0.40) {
                                e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), new ItemStack(Material.PUMPKIN_SEEDS));

                            }

                        }
                    }

                }

            }
        }
    }

}
