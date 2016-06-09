package net.gr8bit.RoyalEnchantments.Commands;

import net.gr8bit.RoyalEnchantments.Main;
import net.gr8bit.RoyalEnchantments.Utils.GlowUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matt on 6/8/16.
 */
public class ShardCmd implements CommandExecutor {


    static Inventory inv;
    static Map<String, String> LoreMap;
    static Map<String, Material> MaterialMap;

    static {
        LoreMap = new HashMap<String, String>();
        LoreMap.put("Auto_Smelt", "§7Automatically smelt ores to ingots, sand to glass, and netherrack to netherbrick!");
        LoreMap.put("Jackhammer", "§7Jacky McHammerface");
        LoreMap.put("Plant_Breeder", "Plant Breeder brreeeeeeeeds plants");
        LoreMap.put("Messanger", "Messanger should be spelled Messenger");
        LoreMap.put("Arrow_Formation", "Arrow Formation for formation of arrows and other things that are good");
        
        MaterialMap = new HashMap<String, Material>();
        MaterialMap.put("Auto_Smelt", Material.COAL);
        MaterialMap.put("Jackhammer", Material.DIAMOND_PICKAXE);
        MaterialMap.put("Plant_Breeder", Material.GOLD_HOE);
        MaterialMap.put("Messanger", Material.DIAMOND_BOOTS);
        MaterialMap.put("Arrow_Formation", Material.BOW);
        
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player)commandSender;
        int shards = Main.plugin.getConfig().getInt(p.getName() + ".shards");
        try {
            if (command.getName().equalsIgnoreCase("shard")) {
                inv = Bukkit.createInventory(null, 54, "Royal Enchantment Menu");
                int line = 0;
                for (String et : Main.enchanttypes) {
                    boolean enabled = Main.plugin.getConfig().getBoolean("royale." + p.getName() + "." + et + ".enabled");
                    ArrayList<String> lore = new ArrayList<String>();
                    lore.add(" ");
                    lore.add(LoreMap.get(et));
                    lore.add(" ");
                    if (enabled) {
                        lore.add("§aEnabled");

                    } else {
                        lore.add("§cDisabled");
                        lore.add(ChatColor.ITALIC + "§7Click to Enable!");
                    }


                    Main.createDisplay(MaterialMap.get(et), inv, 9 * line, "§c" + et.replace("_", " "), lore, enabled);
                    line += 1;
                }
                p.openInventory(inv);


            }

        } catch (Throwable e){
            e.printStackTrace();
        }

        return false;
    }

    public static Inventory getInv() {
        return inv;
    }
}
