package net.gr8bit.RoyalEnchantments.Commands;

import net.gr8bit.RoyalEnchantments.ItemInfo;
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
    public static Map<String, ItemInfo> ItemMap;

    public static Map<String, Integer> InventoryPage;
    public static int ItemsPerPage = 5;
    static {
        ItemMap = new HashMap<String, ItemInfo>();
        ItemMap.put("Auto_Smelt", new ItemInfo(
                /*
                INVENTORY ONE
                 */
                "§7Automatically smelt ores to ingots, sand to glass, and netherrack to netherbrick!",
                Material.COAL,
                new Integer [] {400,150,200, 250,400},
                new Integer [] {10,20,30,40,50},
                new Integer [] {400,150,200, 250,400}
        ));
        ItemMap.put("Jackhammer", new ItemInfo(
                "§7Mine multiple blocks at once with this craft enhancement!",
                Material.DIAMOND_PICKAXE,
                new Integer [] {800,400,600,800},
                new Integer [] {0,0,0, 0,0},
                new Integer [] {400,150,200, 250,400}
        ));
        ItemMap.put("Plant_Breeder", new ItemInfo(
                "§7When tilling the ground, you may find your self suprised to see automatically planted seeds!",
                Material.GOLD_HOE,
                new Integer [] {175,100,200},
                new Integer [] {0,0,0, 0,0},
                new Integer [] {400,150,200, 250,400}
        ));
        ItemMap.put("Messanger", new ItemInfo(
                "§7Basically like power walking, except without effort! This increases your movement spead.",
                Material.DIAMOND_BOOTS,
                new Integer [] {200,50,100,150,200},
                new Integer [] {0,0,0, 0,0},
                new Integer [] {400,150,200, 250,400}
        ));
        ItemMap.put("Arrow_Formation", new ItemInfo(
                "§7Shoot multiple arrows at one time in special formations!",
                Material.BOW,
                new Integer [] {400,600,800,1000,200},
                new Integer [] {0,0,0, 0,0},
                new Integer [] {400,150,200, 250,400}
        ));
          /*
                INVENTORY TWO
                 */
        ItemMap.put("Piercing", new ItemInfo(
                "§7fill in",
                Material.CHAINMAIL_CHESTPLATE,
                new Integer [] {500,200,350,550},
                new Integer [] {0,0,0, 0,0},
                new Integer [] {400,150,200, 250,400}
        ));
        ItemMap.put("Life_Steal", new ItemInfo(
                "§7fill in",
                Material.RED_ROSE,
                new Integer [] {400,300,500,800},
                new Integer [] {0,0,0, 0,0},
                new Integer [] {400,150,200, 250,400}
        ));
        ItemMap.put("Frostbite", new ItemInfo(
                "§7fill in",
                Material.ICE,
                new Integer [] {400,350,400,700},
                new Integer [] {0,0,0, 0,0},
                new Integer [] {400,150,200, 250,400}
        ));
        ItemMap.put("Voltage", new ItemInfo(
                "§7fill in",
                Material.DIAMOND_SWORD,
                new Integer [] {600,450,600,900},
                new Integer [] {0,0,0,0,0},
                new Integer [] {400,150,200, 250,400}
        ));
        ItemMap.put("Wolf_Tamer", new ItemInfo(
                "§7fill in",
                Material.BONE,
                new Integer [] {600,400,500},
                new Integer [] {0,0,0,0,0},
                new Integer [] {400,150,200, 250,400}
        ));
          /*
                INVENTORY THREE
                 */
        ItemMap.put("After_Effects", new ItemInfo(
                "§7fill in",
                Material.TNT,
                new Integer [] {200,200,300,300,400},
                new Integer [] {0,0,0,0,0},
                new Integer [] {400,150,200, 250,400}
        ));
        ItemMap.put("Savage", new ItemInfo(
                "§7fill in",
                Material.BLAZE_POWDER,
                new Integer [] {750,400,500,600,800},
                new Integer [] {0,0,0,0,0},
                new Integer [] {400,150,200, 250,400}
        ));
        ItemMap.put("Enemy_Decay", new ItemInfo(
                "§7fill in",
                Material.DEAD_BUSH,
                new Integer [] {400,400,500},
                new Integer [] {0,0,0,0,0},
                new Integer [] {400,150,200, 250,400}
        ));
        ItemMap.put("Explosive_Arrows", new ItemInfo(
                "§7fill in",
                Material.ARROW,
                new Integer [] {500,350,500},
                new Integer [] {0,0,0,0,0},
                new Integer [] {400,150,200, 250,400}
        ));
        ItemMap.put("Mob_Swatter", new ItemInfo(
                "§7fill in",
                Material.SIGN,
                new Integer [] {200,250,450,500},
                new Integer [] {0,0,0,0,0},
                new Integer [] {400,150,200, 250,400}
        ));



        InventoryPage = new HashMap<String, Integer>();
        
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        try {
            Player p = (Player)commandSender;
            int shards = Main.plugin.getConfig().getInt("royale." + p.getName() + ".shard");

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
                        lore.add(ItemMap.get(et).getLore());
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
                            Main.createDisplay(ItemMap.get(et).getMaterial(), inv, 9 * line, "§a" + et.replace("_", " "), lore, enabled, 0, 1);
                        else
                            Main.createDisplay(ItemMap.get(et).getMaterial(), inv, 9 * line, "§c" + et.replace("_", " "), lore, enabled, 0, 1);
                        int clayamount = ItemMap.get(et).getUpgradeamount().length;
                        int level = Main.plugin.getConfig().getInt("royale." + p.getName() + "." + et + ".level");

                        try {
                            for (int i = 0; i < clayamount; i++) {
                                int clayshort = 9;
                                String title = "§c";

                                ArrayList<String> claylore = new ArrayList<String>();
                                if (shards >= ItemMap.get(et).getUpgradeamount()[i]) {
                                    if (i == level) {
                                        //red

                                        clayshort = 14;
                                        title = "§c";
                                        claylore.add("§7Status: §cLocked");
                                        claylore.add("§7Price: §3♦" +ItemMap.get(et).getUpgradeamount()[i]);
                                        claylore.add(" ");
                                        if(ItemMap.get(et).getChance()[i] != 0) {
                                            claylore.add("§7Chance: §6"+ItemMap.get(et).getChance()[i].toString() +"%");
                                        }

                                    }

                                } else {

                                    clayshort = 9;
                                    if(clayshort == 14 || i == level) {
                                        claylore.add("§7Status: §cInsuffcient Shards");
                                        claylore.add("§7Price: §3♦" + ItemMap.get(et).getUpgradeamount()[i]);
                                        claylore.add(" ");
                                        if (ItemMap.get(et).getChance()[i] != 0) {
                                            claylore.add("§7Chance: §6" + ItemMap.get(et).getChance()[i].toString() + "%");

                                        }
                                    }
                                }
                                if (i < level) {
                                    //green
                                    clayshort = 5;
                                    title = "§a";

                                    claylore.add("§7Status: §aUnlocked");
                                    claylore.add(" ");
                                    if(ItemMap.get(et).getChance()[i] != 0) {
                                        claylore.add("§7Chance: §6"+ItemMap.get(et).getChance()[i].toString() +"%");

                                    }

                                }
                                if(i > level) {
                                    claylore.add("§7Status: §cUnavailable");
                                    claylore.add("§7Price: §3♦" + ItemMap.get(et).getUpgradeamount()[i]);
                                    claylore.add("");
                                    if (ItemMap.get(et).getChance()[i] != 0) {
                                        claylore.add("§7Chance: §6" + ItemMap.get(et).getChance()[i].toString() + "%");

                                    }
                                    claylore.add("§7§oUnlock Previous Level");
                                }





                                Main.createDisplay(Material.STAINED_CLAY, inv, 9 * line + 1 + i, title + et.replace("_", " ") + " Lv. " + (i + 1), claylore, false, clayshort, 1);


                            }
                        }catch(Throwable e) {
                            e.printStackTrace();
                        }


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
