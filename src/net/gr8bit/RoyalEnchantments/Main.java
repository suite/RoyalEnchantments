package net.gr8bit.RoyalEnchantments;

import net.gr8bit.RoyalEnchantments.Commands.ShardCmd;
import net.gr8bit.RoyalEnchantments.Listeners.*;
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
import org.bukkit.scheduler.BukkitTask;
import net.gr8bit.RoyalEnchantments.Main;


import java.util.ArrayList;

/**
 * Created by Matt on 6/8/16.
 */
public class Main extends JavaPlugin {

    public static JavaPlugin plugin;
    public static ArrayList<String> enchanttypes = new ArrayList<String>();
    public static ArrayList<Material> seedtype = new ArrayList<Material>();


    @Override
    public void onEnable() {
        registerEvents(this,
                new InventoryListener(),
                new PlayerListener(),
                new BlockListener(),
                new ArrowEvent(),
                new EntityHitByEntityEvent(),
                new PlayerDeathListener(),
                new PlantInteract(),
                new BlockPlaceListener(),
                new BetterEntityEventLol());

        plugin = this;

        seedtype.add(Material.BEETROOT_SEEDS);
        seedtype.add(Material.MELON_SEEDS);
        seedtype.add(Material.PUMPKIN_SEEDS);

        getCommand("shard").setExecutor(new ShardCmd());
        enchanttypes.add("Auto_Smelt");
        enchanttypes.add("Jackhammer");
        enchanttypes.add("Plant_Breeder");
        enchanttypes.add("Messenger");
        enchanttypes.add("Arrow_Formation");

        enchanttypes.add("Piercing");
        enchanttypes.add("Life_Steal");
        enchanttypes.add("Frostbite");
        enchanttypes.add("Voltage");
        enchanttypes.add("Wolf_Tamer");

        enchanttypes.add("After_Effects");
        enchanttypes.add("Savage");
        enchanttypes.add("Enemy_Decay");
        enchanttypes.add("Explosive_Arrows");
        enchanttypes.add("Mob_Swatter");

        BukkitTask TaskName = new RunnableClass().runTaskTimer(this, 20, 20);





    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static void giveShard(Player p, int amount) {
        plugin.getConfig().set("royale."+p.getUniqueId() + ".shard", plugin.getConfig().getInt("royale."+p.getUniqueId() + ".shard", 0) + amount);
        plugin.saveConfig();

    }
    public static void removeShard(Player p, int amount) {
        plugin.getConfig().set("royale."+p.getUniqueId() + ".shard", plugin.getConfig().getInt("royale."+p.getUniqueId() + ".shard", 0) - amount);
        plugin.saveConfig();

    }
    public static void setShard(Player p, int amount) {
        plugin.getConfig().set("royale."+p.getUniqueId() + ".shard", amount);
        plugin.saveConfig();

    }
    public static void createDisplay(Material material, Inventory inv, int Slot, String name, ArrayList<String> lore, boolean glow, int datavalue, int amount) {
        ItemStack item = new ItemStack(material, amount, (short) datavalue);

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

    public static boolean canUseAbility(Player p, String ability) {
        boolean enabled = Main.plugin.getConfig().getBoolean("royale." + p.getUniqueId() + "." + ability + ".enabled");
        boolean unlocked = Main.plugin.getConfig().getBoolean("royale." + p.getUniqueId() + "." + ability + ".unlocked");
        if(enabled && unlocked) {
            return true;
        } else {
            return false;
        }
    }
    public static int getLevel(Player p, String ability) {
        int level = Main.plugin.getConfig().getInt("royale." + p.getUniqueId() + "." + ability + ".level");
        return level;

    }
    public static boolean willUseAbilityChance(Player p, String ability) {
        if (Main.canUseAbility(p, ability)) {
            int level = Main.getLevel(p, ability);
            double random = Math.random();
            double chance = ShardCmd.ItemMap.get(ability).getChance()[level - 1] / 100.00;
            return (random <= chance);

        } else {
            return false;
        }
    }





}
