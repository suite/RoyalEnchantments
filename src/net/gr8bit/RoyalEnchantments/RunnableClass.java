package net.gr8bit.RoyalEnchantments;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import static net.gr8bit.RoyalEnchantments.Main.canUseAbility;

/**
 * Created by Matt on 6/13/16.
 */
public class RunnableClass extends BukkitRunnable {


        public void run() {
            try {
               for(Player p : Bukkit.getOnlinePlayers()) {
                   if (canUseAbility(p, "Messenger")) {
                       int level = Main.getLevel(p, "Messenger");
                       if (p.getInventory().getBoots() != null) {
                           p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999999, 1));
                           if(level == 1) {
                               p.setWalkSpeed(0.28F + 1.1F);

                           } else if(level == 2) {
                               p.setWalkSpeed(0.28F+ 1.2F);

                           } else if(level == 3) {
                               p.setWalkSpeed(0.28F + 1.3F);

                           } else if(level == 4) {
                               p.setWalkSpeed(0.28F + 1.4F);

                           } else if(level == 5) {
                               p.setWalkSpeed(0.28F + 1.5F);

                           }


                       } else {
                           p.removePotionEffect(PotionEffectType.SPEED);
                           p.setWalkSpeed(0.2F);
                       }



                   } else {
                       p.removePotionEffect(PotionEffectType.SPEED);
                       p.setWalkSpeed(0.2F);

                   }

               }

            } catch(Exception e) {}
        }
    }



