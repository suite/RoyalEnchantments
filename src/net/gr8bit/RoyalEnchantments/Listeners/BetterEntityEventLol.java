package net.gr8bit.RoyalEnchantments.Listeners;

import net.gr8bit.RoyalEnchantments.Main;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Created by Matt on 6/30/16.
 */
public class BetterEntityEventLol implements Listener {

    @EventHandler
    public void hitxD(EntityDamageByEntityEvent e) {
        Arrow a = (Arrow) e.getDamager();
        Player player = (Player) a.getShooter();
        if (e.getDamager() instanceof Arrow) {
            if (Main.willUseAbilityChance(player, "Explosive_Arrows")) {
                player.setHealth(player.getHealth()-20);
                e.getEntity().getWorld().createExplosion(e.getEntity().getLocation().getX(), e.getEntity().getLocation().getY(), e.getEntity().getLocation().getZ(), 1.0F, false, false);
            }
        }
    }
}
