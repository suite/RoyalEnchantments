package net.gr8bit.RoyalEnchantments.Commands;

import net.gr8bit.RoyalEnchantments.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

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
    static Map<String, Integer[]> UpgradeAmount;
    public static Map<String, Integer> InventoryPage;
    static int ItemsPerPage = 5;
    static {
        LoreMap = new HashMap<String, String>();
        LoreMap.put("Auto_Smelt", "§7Automatically smelt ores to ingots, sand to glass, and netherrack to netherbrick!");
        LoreMap.put("Jackhammer", "§7Mine multiple blocks at once with this craft enhancement!");
        LoreMap.put("Plant_Breeder", "§7Phen tilling the ground, you may find your self suprised to see automatically planted seeds!");
        LoreMap.put("Messanger", "§7Basically like power walking, except without effort! This increases your movement spead.");
        LoreMap.put("Arrow_Formation", "§7Shoot multiple arrows at one time in special formations!");

        LoreMap.put("Piercing", "§7Automatically smelt ores to ingots, sand to glass, and netherrack to netherbrick!");
        LoreMap.put("Life_Steal", "§7Mine multiple blocks at once with this craft enhancement!");
        LoreMap.put("Frostbite", "§7Phen tilling the ground, you may find your self suprised to see automatically planted seeds!");
        LoreMap.put("Voltage", "§7Basically like power walking, except without effort! This increases your movement spead.");
        LoreMap.put("Wolf_Tamer", "§7Shoot multiple arrows at one time in special formations!");

        LoreMap.put("After_Effects", "§7Automatically smelt ores to ingots, sand to glass, and netherrack to netherbrick!");
        LoreMap.put("Savage", "§7Mine multiple blocks at once with this craft enhancement!");
        LoreMap.put("Enemy_Decay", "§7When tilling the ground, you may find your self surprised to see automatically planted seeds!");
        LoreMap.put("Explosive_Arrows", "§7Basically like power walking, except without effort! This increases your movement spead.");
        LoreMap.put("Mob_Swatter", "§7Shoot multiple arrows at one time in special formations!");

        MaterialMap = new HashMap<String, Material>();
        MaterialMap.put("Auto_Smelt", Material.COAL);
        MaterialMap.put("Jackhammer", Material.DIAMOND_PICKAXE);
        MaterialMap.put("Plant_Breeder", Material.GOLD_HOE);
        MaterialMap.put("Messanger", Material.DIAMOND_BOOTS);
        MaterialMap.put("Arrow_Formation", Material.BOW);

        MaterialMap.put("Piercing", Material.CHAINMAIL_CHESTPLATE);
        MaterialMap.put("Life_Steal", Material.RED_ROSE);
        MaterialMap.put("Frostbite", Material.ICE);
        MaterialMap.put("Voltage", Material.DIAMOND_SWORD);
        MaterialMap.put("Wolf_Tamer", Material.BONE);

        MaterialMap.put("After_Effects", Material.TNT);
        MaterialMap.put("Savage", Material.BLAZE_POWDER);
        MaterialMap.put("Enemy_Decay", Material.DEAD_BUSH);
        MaterialMap.put("Explosive_Arrows", Material.ARROW);
        MaterialMap.put("Mob_Swatter", Material.SIGN);

        UpgradeAmount = new HashMap<String, String>();
        UpgradeAmount.put("Auto_Smelt", new Integer [] {400,150,200, 250,400});
        UpgradeAmount.put("Jackhammer", new Integer [] {800,400,600,800});
        UpgradeAmount.put("Plant_Breeder", new Integer [] {175,100,200});
        UpgradeAmount.put("Messanger", new Integer [] {200,50,100,150,200});
        UpgradeAmount.put("Arrow_Formation", new Integer [] {400,600,800,1000,200});

        UpgradeAmount.put("Piercing", new Integer [] {500,200,350,550});
        UpgradeAmount.put("Life_Steal", new Integer [] {400,300,500,800});
        UpgradeAmount.put("Frostbite", new Integer [] {400,350,400,700});
        UpgradeAmount.put("Voltage", new Integer [] {600,450,600,900});
        UpgradeAmount.put("Wold_Tamer", new Integer [] {600,400,500});

        UpgradeAmount.put("After_Effects", new Integer [] {200,200,300,300,400});
        UpgradeAmount.put("Savage", new Integer [] {750,400,500,600,800});
        UpgradeAmount.put("Enemy_Decay", new Integer [] {400,400,500});
        UpgradeAmount.put("Explosive_Arrows", new Integer [] {500,350,500});
        UpgradeAmount.put("Mob_Swatter", new Integer [] {200,250,450,500});


        InventoryPage = new HashMap<String, Integer>();
        
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player)commandSender;
        int shards = Main.plugin.getConfig().getInt("royale." + p.getName() + ".shard");
        try {
            if(args.length == 0) {
                if (command.getName().equalsIgnoreCase("shard")) {
                    int ip = InventoryPage.getOrDefault(p.getName(), 0);
                    inv = Bukkit.createInventory(null, 54, "Royal Enchantment Menu");
                    int line = 0;
                    int totalunlocked = 0;
                    int totalenabled = 0;
                    for (String et : Main.enchanttypes.subList(ip*ItemsPerPage, (ip+1)*ItemsPerPage)) {
                        boolean enabled = Main.plugin.getConfig().getBoolean("royale." + p.getName() + "." + et + ".enabled");
                        boolean unlocked = Main.plugin.getConfig().getBoolean("royale." + p.getName() + "." + et + ".unlocked");
                        ArrayList<String> lore = new ArrayList<String>();
                        lore.add(" ");
                        lore.add(LoreMap.get(et));
                        lore.add(" ");
                        if (enabled && unlocked) {
                            lore.add("§aEnabled");

                        } else if (!enabled && unlocked) {
                            lore.add("§cDisabled");
                            lore.add("§7§oClick to Enable!");
                        }
                        if (!unlocked) {
                            lore.add("§cPurchase to Enable");
                        }
                        if(enabled)
                            lore.add("§7§oClick to Disable!");
                        Main.createDisplay(Material.ARROW, inv, 46, "§bPage 1", null, false, 0, 1);
                        Main.createDisplay(Material.ARROW, inv, 47, "§bPage 2", null, false, 0, 2);
                        Main.createDisplay(Material.ARROW, inv, 48, "§bPage 3", null, false, 0, 3);
                        if(ip == 0) {
                            Main.createDisplay(Material.ARROW, inv, 46, "§bPage 1", null, true, 0, 1);

                        } else  if(ip == 1) {
                            Main.createDisplay(Material.ARROW, inv, 47, "§bPage 2", null, true, 0, 2);

                        }else  if(ip == 2) {
                            Main.createDisplay(Material.ARROW, inv, 48, "§bPage 3", null, true, 0, 3);

                        }
                        if(unlocked)
                            Main.createDisplay(MaterialMap.get(et), inv, 9 * line, "§a" + et.replace("_", " "), lore, enabled, 0, 1);
                        else
                            Main.createDisplay(MaterialMap.get(et), inv, 9 * line, "§c" + et.replace("_", " "), lore, enabled, 0, 1);




                        line += 1;



                    }
                    for (String et : Main.enchanttypes) {
                        boolean enabled = Main.plugin.getConfig().getBoolean("royale." + p.getName() + "." + et + ".enabled");
                        boolean unlocked = Main.plugin.getConfig().getBoolean("royale." + p.getName() + "." + et + ".unlocked");

                        if (enabled && unlocked)
                            totalenabled++;
                        if (unlocked)
                            totalunlocked++;
                    }


                    ArrayList<String> shardlore = new ArrayList<String>();
                    shardlore.add("§7Shards: §3♦" + shards);
                    shardlore.add(" ");
                    shardlore.add("§7Unlocked: §6" + totalunlocked + "§7/§615");
                    shardlore.add("§7Enabled §a" + totalenabled + "§7/§a15");
                    Main.createDisplay(Material.PRISMARINE_SHARD, inv, 50, "§aYour Account:", shardlore, false, 0, 1);
                    ArrayList<String> toggleonlore = new ArrayList<String>();
                    toggleonlore.add("§7Enabled All Purchased Enchantments");
                    toggleonlore.add("§7Requires §6VIP");
                    Main.createDisplay(Material.STAINED_GLASS_PANE, inv, 52, "§aToggle All On", toggleonlore, false, 5, 1);
                    ArrayList<String> toggleofflore = new ArrayList<String>();
                    toggleofflore.add("§7Disable All Purchased Enchantments");
                    toggleofflore.add("§7Requires §6VIP");
                    Main.createDisplay(Material.STAINED_GLASS_PANE, inv, 53, "§aToggle All Off", toggleofflore, false, 14, 1);
                    p.openInventory(inv);


                }


            }else if(args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("set")) {
                Player target = Bukkit.getPlayer(args[1]);
                if(target != null) {
                        if(args[2].matches("^-?\\d+$")) {
                            if(args[0].equalsIgnoreCase("add")) {
                                Main.giveShard(target, Integer.parseInt(args[2]));
                            } else  if(args[0].equalsIgnoreCase("remove")) {
                                Main.removeShard(target, Integer.parseInt(args[2]));
                            } else  if(args[0].equalsIgnoreCase("set")) {
                                Main.setShard(target, Integer.parseInt(args[2]));
                            }






                    }
                }

                for (String et : Main.enchanttypes) {
                    int shardamount = Main.plugin.getConfig().getInt("royale." + p.getName() + "." + et + ".shard");

                }



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
