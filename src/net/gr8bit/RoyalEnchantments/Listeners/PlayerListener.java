package net.gr8bit.RoyalEnchantments.Listeners;

import net.gr8bit.RoyalEnchantments.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static net.gr8bit.RoyalEnchantments.Main.canUseAbility;


public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e)  {
        if(!Main.plugin.getConfig().contains("royale." + e.getPlayer().getUniqueId())) {
            Main.plugin.getConfig().set("royale." + e.getPlayer().getUniqueId() + ".shard", 0);

            for (String et : Main.enchanttypes) {
                Main.plugin.getConfig().set("royale." + e.getPlayer().getUniqueId() + "." + et + ".enabled", false);
                Main.plugin.getConfig().set("royale." +e.getPlayer().getUniqueId() + "." + et + ".level", 0);
                Main.plugin.getConfig().set("royale." +e.getPlayer().getUniqueId() + "." + et + ".unlocked", false);

            }
            Main.plugin.saveConfig();
        }
        Main.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
            @Override
            public void run() {
                try {
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        if(canUseAbility(p, "Messenger")) {
                            int level = Main.getLevel(p, "Messanger");
                            if(p.getInventory().getBoots() != null) {
                                if(level == 1) {
                                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,  999999, 1, false, true));

                                }
                            }





                        }
                    }
                } catch(Exception e) {}
            }
        }, 20, 100);
    }
}


//royale:
//  luqy:
//    shards: 30
//    autosmelt:
//      enabled: true
//      level: 4
//    jackhammer:
//      enabled: false
//      level: 0

