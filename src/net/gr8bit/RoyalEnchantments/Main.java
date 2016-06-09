package net.gr8bit.RoyalEnchantments;

import net.gr8bit.RoyalEnchantments.Commands.ShardCmd;
import net.gr8bit.RoyalEnchantments.Listeners.BlockListener;
import net.gr8bit.RoyalEnchantments.Listeners.InventoryListener;
import net.gr8bit.RoyalEnchantments.Listeners.PlayerListener;
import net.gr8bit.RoyalEnchantments.Utils.GlowUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

/**
 * Created by Matt on 6/8/16.
 */
public class Main extends JavaPlugin {

    public static JavaPlugin plugin;
    public static ArrayList<String> enchanttypes = new ArrayList<String>();

    @Override
    public void onEnable() {
        registerEvents(this, new InventoryListener(), new PlayerListener(), new BlockListener());
        plugin = this;
        getCommand("shard").setExecutor(new ShardCmd());
        enchanttypes.add("Auto_Smelt");
        enchanttypes.add("Jackhammer");
        enchanttypes.add("Plant_Breeder");
        enchanttypes.add("Messanger");
        enchanttypes.add("Arrow_Formation");

    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static void giveShard(Player p, int amount) {
        plugin.getConfig().set(p.getName() + ".shards", plugin.getConfig().getInt(p.getName() + ".shards", 0) + amount);

    }
    public static void createDisplay(Material material, Inventory inv, int Slot, String name, ArrayList<String> lore, boolean glow) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        if (glow) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        }
        item.setItemMeta(meta);
        if(glow) {
            item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
        }


        inv.setItem(Slot, item);

    }

}
