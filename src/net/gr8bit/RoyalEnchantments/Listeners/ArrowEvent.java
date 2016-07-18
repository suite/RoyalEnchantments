package net.gr8bit.RoyalEnchantments.Listeners;

import net.gr8bit.RoyalEnchantments.Main;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matt on 6/14/16.
 */
public class ArrowEvent implements Listener {

    @EventHandler
    public void onPlayerShootArrow(EntityShootBowEvent e) {
        if (e.getEntity() instanceof Player) {

            Player p = (Player) e.getEntity();
            int level = Main.getLevel(p, "Arrow_Formation");
            if ((e.getEntity() instanceof Player)) {
                if (e.getForce() == 1.0) {

                    if (Main.willUseAbilityChance(p, "Arrow_Formation")) {
                        if (p.getInventory().containsAtLeast(new ItemStack(Material.ARROW), 2)) {
                            Arrow arrow = p.launchProjectile(Arrow.class);
                            arrow.setShooter(p);
                            arrow.setVelocity(p.getLocation().getDirection().setY(arrow.getVelocity().getY() + 0.1));

                        }


                        if (level > 2) {
                            if (p.getInventory().containsAtLeast(new ItemStack(Material.ARROW), 3)) {
                                Arrow arrow2 = p.launchProjectile(Arrow.class);
                                arrow2.setShooter(p);

                                double yawradleft = (p.getLocation().getYaw() + 10.0) * Math.PI / 180;
                                double xvel = -Math.sin(yawradleft);
                                double zvel = Math.cos(yawradleft);
                                arrow2.setVelocity(p.getLocation().getDirection().setX(xvel).setZ(zvel));

                            }


                        }
                        if (level > 3) {
                            if (p.getInventory().containsAtLeast(new ItemStack(Material.ARROW), 4)) {
                                Arrow arrow2 = p.launchProjectile(Arrow.class);
                                arrow2.setShooter(p);

                                double yawradleft = (p.getLocation().getYaw() - 10.0) * Math.PI / 180;
                                double xvel = -Math.sin(yawradleft);
                                double zvel = Math.cos(yawradleft);
                                arrow2.setVelocity(p.getLocation().getDirection().setX(xvel).setZ(zvel));
                            }


                        }
                        if (level < 3) {
                            p.getInventory().removeItem(new ItemStack(Material.ARROW, 2));
                        } else if (level == 3) {
                            p.getInventory().removeItem(new ItemStack(Material.ARROW, 3));
                        } else if (level > 3) {
                            p.getInventory().removeItem(new ItemStack(Material.ARROW, 4
                            ));
                        }
                    }
                }

            }

        }
    }

}

