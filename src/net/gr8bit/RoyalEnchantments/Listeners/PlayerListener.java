package net.gr8bit.RoyalEnchantments.Listeners;

import net.gr8bit.RoyalEnchantments.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;




public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e)  {
        if(!Main.plugin.getConfig().contains("royale." + e.getPlayer().getName())) {
            Main.plugin.getConfig().set("royale." + e.getPlayer().getName() + ".shard", 0);

            for (String et : Main.enchanttypes) {
                Main.plugin.getConfig().set("royale." + e.getPlayer().getName() + "." + et + ".enabled", false);
                Main.plugin.getConfig().set("royale." +e.getPlayer().getName() + "." + et + ".level", 0);
                Main.plugin.getConfig().set("royale." +e.getPlayer().getName() + "." + et + ".unlocked", false);

            }
            Main.plugin.saveConfig();
        }
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

