package net.gr8bit.RoyalEnchantments.Listeners;

import net.gr8bit.RoyalEnchantments.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by Matt on 6/16/16.
 */
public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (Main.willUseAbilityChance(p, "After_Effects")) {
            p.getWorld().createExplosion(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 1.0F, false, false);
        }
    }

}
