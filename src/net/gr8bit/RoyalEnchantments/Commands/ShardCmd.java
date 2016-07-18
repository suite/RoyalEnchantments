package net.gr8bit.RoyalEnchantments.Commands;

import net.gr8bit.RoyalEnchantments.ItemInfo;
import net.gr8bit.RoyalEnchantments.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static net.gr8bit.RoyalEnchantments.Main.plugin;


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
                "§7Automatically smelt ores to ingots,\n§7sand to glass, and\n§7netherrack to netherbrick!",

                Material.COAL,
                new Integer [] {400,150,200, 250,400},
                new Integer [] {10,20,30,40,50},
                new Integer [] {0,0,0, 0,0},
                "","",""
        ));
        ItemMap.put("Jackhammer", new ItemInfo(
                "§7Mine multiple blocks at once\n§7with this craft enhancement!",
                Material.DIAMOND_PICKAXE,
                new Integer [] {800,400,600,800},
                new Integer [] {15,25,20,30},
                new Integer [] {0,0,0, 0,0},
                "╸┇╸,╸┇╸,┇┇┇,┇┇┇","",""
        ));
        ItemMap.put("Plant_Breeder", new ItemInfo(
                "§7When tilling the ground, you may\n§7find your self suprised to\n§7see seeds dropped on the floor!",
                Material.GOLD_HOE,
                new Integer [] {175,100,200},
                new Integer [] {10,20,30},
                new Integer [] {0,0,0, 0,0},
                "","",""
        ));
        ItemMap.put("Messenger", new ItemInfo(
                "§7Basically like power walking,\n§7except without effort! This increases\n§7your movement speed.",
                Material.DIAMOND_BOOTS,
                new Integer [] {200,50,100,150,200},
                new Integer [] {100,100,100,100,100},
                new Integer [] {11,12,13, 14,15}
                ,"","",""
        ));
        ItemMap.put("Arrow_Formation", new ItemInfo(
                "§7Shoot multiple arrows at one\n§7time in special formations!",
                Material.BOW,
                new Integer [] {400,600,800,1000,200},
                new Integer [] {20,40,35, 35,40},
                new Integer [] {0,0,0, 0,0}
                ,"","¦,¦,∴,∷,∷",""
        ));
          /*
                INVENTORY TWO
                 */
        ItemMap.put("Piercing", new ItemInfo(
                "§7The ability to bypass any armor protection,\n§7when using any weapon on your opponent!",
                Material.CHAINMAIL_CHESTPLATE,
                new Integer [] {500,200,350,550},
                new Integer [] {5,10,20, 35},
                new Integer [] {0,0,0, 0,0}
                ,"","",""
        ));
        ItemMap.put("Life_Steal", new ItemInfo(
                "§7A chance to steal the life equal to\n§7the damage done by damage\n§7inflicted on a opponent!",
                Material.RED_ROSE,
                new Integer [] {400,300,500,800},
                new Integer [] {10,20,30, 40},
                new Integer [] {0,0,0, 0,0}
                ,"","",""
        ));
        ItemMap.put("Frostbite", new ItemInfo(
                "§7Freeze your opponents in a little\n§7ice block and laugh at them!",
                Material.ICE,
                new Integer [] {400,350,400,700},
                new Integer [] {10,15,20, 25},
                new Integer [] {0,0,0, 0,0}
                ,"","","1,1.2,1.3,1.5"
        ));
        ItemMap.put("Voltage", new ItemInfo(
                "§7You become Thor with this ability...\n§7With every hit, you have a chance\n§7to strike your opponent with lightning!",
                Material.DIAMOND_SWORD,
                new Integer [] {600,450,600,900},
                new Integer [] {5,10,15,20},
                new Integer [] {0,0,0, 0,0}
                ,"","",""
        ));
        ItemMap.put("Wolf_Tamer", new ItemInfo(
                "§7Whenever you strike a hit with a\n§7bow, sword, or axe, you have a\n§7chance to spawn in a wolf to\n§7help attack on your behalf!",
                Material.BONE,
                new Integer [] {600,400,500},
                new Integer [] {10,15,20},
                new Integer [] {0,0,0, 0,0},"","",""
        ));
          /*
                INVENTORY THREE
                 */
        ItemMap.put("After_Effects", new ItemInfo(
                "§7Once upon a tragic death... You\n§7may explode into a million\n§7pieces and demolish your surroundings!",
                Material.TNT,
                new Integer [] {200,200,300,300,400},
                new Integer [] {20,30,40,55,75},
                new Integer [] {0,0,0, 0,0},"","",""
        ));
        ItemMap.put("Savage", new ItemInfo(
                "§7You're crazy, you really want\n§7to fight with levitation\n§7and hint of mining fatigue!?!",
                Material.BLAZE_POWDER,
                new Integer [] {750,400,500,600,800},
                new Integer [] {20,20,25,30,30},
                new Integer [] {0,0,0, 0,0},"","","5,6,7,8,10"
        ));
        ItemMap.put("Enemy_Decay", new ItemInfo(
                "§7Encourage a quicker death for your\n§7opponents... This can give\n§7them the wither and posion effects!",
                Material.DEAD_BUSH,
                new Integer [] {400,400,500},
                new Integer [] {10,15,15},
                new Integer [] {0,0,0, 0,0},"","","5,6,8"
        ));
        ItemMap.put("Explosive_Arrows", new ItemInfo(
                "§7Whenever you hit an opponent tnt\n§7might drop and send them flying!",
                Material.ARROW,
                new Integer [] {500,350,500},
                new Integer [] {15,20,30},
                new Integer [] {0,0,0, 0,0},"","",""
        ));
        ItemMap.put("Mob_Swatter", new ItemInfo(
                "§7With this handy dandy tool you\n§7might instant kill any\n§7mobs that cross your path!",
                Material.SIGN,
                new Integer [] {200,250,450,500},
                new Integer [] {25,35,45,60},
                new Integer [] {0,0,0, 0,0},"","",""
        ));



        InventoryPage = new HashMap<String, Integer>();
        
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        try {
            Player p = (Player) commandSender;
            int shards = plugin.getConfig().getInt("royale." + p.getUniqueId() + ".shard");

            if (args.length == 0) {
                if (command.getName().equalsIgnoreCase("shard")) {
                    int ip = InventoryPage.getOrDefault(p.getName(), 0);
                    inv = Bukkit.createInventory(null, 54, "Royal Enchantment Menu");
                    int line = 0;
                    int totalunlocked = 0;
                    int totalenabled = 0;
                    for (String et : Main.enchanttypes.subList(ip * ItemsPerPage, (ip + 1) * ItemsPerPage)) {
                        boolean enabled = plugin.getConfig().getBoolean("royale." + p.getUniqueId() + "." + et + ".enabled");
                        boolean unlocked = plugin.getConfig().getBoolean("royale." + p.getUniqueId() + "." + et + ".unlocked");
                        ArrayList<String> lore = new ArrayList<String>();
                        lore.add(" ");
                        String[] lines = ItemMap.get(et).getLore().split("\n");
                        for (String newline : lines)
                            lore.add(newline);

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
                        if (enabled)
                            lore.add("§7§oClick to Disable!");
                        Main.createDisplay(Material.ARROW, inv, 46, "§bPage 1", null, false, 0, 1);
                        Main.createDisplay(Material.ARROW, inv, 47, "§bPage 2", null, false, 0, 2);
                        Main.createDisplay(Material.ARROW, inv, 48, "§bPage 3", null, false, 0, 3);
                        if (ip == 0) {
                            Main.createDisplay(Material.ARROW, inv, 46, "§bPage 1", null, true, 0, 1);

                        } else if (ip == 1) {
                            Main.createDisplay(Material.ARROW, inv, 47, "§bPage 2", null, true, 0, 2);

                        } else if (ip == 2) {
                            Main.createDisplay(Material.ARROW, inv, 48, "§bPage 3", null, true, 0, 3);

                        }

                        if (unlocked)
                            Main.createDisplay(ItemMap.get(et).getMaterial(), inv, 9 * line, "§a" + et.replace("_", " "), lore, enabled, 0, 1);
                        else
                            Main.createDisplay(ItemMap.get(et).getMaterial(), inv, 9 * line, "§c" + et.replace("_", " "), lore, enabled, 0, 1);
                        int clayamount = ItemMap.get(et).getUpgradeamount().length;
                        int level = plugin.getConfig().getInt("royale." + p.getUniqueId() + "." + et + ".level");

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
                                        claylore.add("§7Price: §3♦" + ItemMap.get(et).getUpgradeamount()[i]);
                                        claylore.add(" ");


                                    }

                                } else {

                                    clayshort = 9;
                                    if (clayshort == 14 || i == level) {
                                        claylore.add("§7Status: §cInsuffcient Shards");
                                        claylore.add("§7Price: §3♦" + ItemMap.get(et).getUpgradeamount()[i]);
                                        claylore.add(" ");
                                    }
                                }
                                if (i < level) {
                                    //green
                                    clayshort = 5;
                                    title = "§a";

                                    claylore.add("§7Status: §aUnlocked");
                                    claylore.add(" ");

                                }
                                if (i > level) {
                                    claylore.add("§7Status: §cUnavailable");
                                    claylore.add("§7Price: §3♦" + ItemMap.get(et).getUpgradeamount()[i]);
                                    claylore.add("");
                                    claylore.add("§7§oUnlock Previous Level");
                                }

                                if (ItemMap.get(et).getChance()[i] != 0) {
                                    claylore.add("§7Chance: §6" + ItemMap.get(et).getChance()[i].toString() + "%");
                                }
                                if (ItemMap.get(et).getType() != "") {

                                    String[] typearray = ItemMap.get(et).getType().split(",");
                                    claylore.add("§7Type: §6" + typearray[i].toString());
                                }
                                if (ItemMap.get(et).getSpeed()[i] != 0) {
                                    double speedamt = ItemMap.get(et).getSpeed()[i] * 0.1;
                                    DecimalFormat numberFormat = new DecimalFormat("#.0");

                                    claylore.add("§7Speed: §6" + numberFormat.format(speedamt) + "x");
                                }
                                if (ItemMap.get(et).getFormation() != "") {

                                    String[] typearray2 = ItemMap.get(et).getFormation().split(",");
                                    claylore.add("§7Formation: §6" + typearray2[i].toString());
                                }
                                if (ItemMap.get(et).getDuration() != "") {

                                    String[] typearray3 = ItemMap.get(et).getDuration().split(",");
                                    claylore.add("§7Duration: §b" + typearray3[i].toString() + " seconds");
                                }
                                /*
                                HERE DO WORK HERE!HERE DO WORK HERE!HERE DO WORK HERE!
                                HERE DO WORK HERE!HERE DO WORK HERE!HERE DO WORK HERE!
                                HERE DO WORK HERE!HERE DO WORK HERE!HERE DO WORK HERE!
                                HERE DO WORK HERE!HERE DO WORK HERE!HERE DO WORK HERE!
                                HERE DO WORK HERE!HERE DO WORK HERE!HERE DO WORK HERE!
                                HERE DO WORK HERE!HERE DO WORK HERE!HERE DO WORK HERE!
                                 */


                                Main.createDisplay(Material.STAINED_CLAY, inv, 9 * line + 1 + i, title + et.replace("_", " ") + " Lv. " + (i + 1), claylore, false, clayshort, 1);


                            }
                        } catch (Throwable e) {
                            e.printStackTrace();
                        }


                        line += 1;


                    }
                    for (String et : Main.enchanttypes) {
                        boolean enabled = plugin.getConfig().getBoolean("royale." + p.getUniqueId() + "." + et + ".enabled");
                        boolean unlocked = plugin.getConfig().getBoolean("royale." + p.getUniqueId() + "." + et + ".unlocked");

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
                    Main.createDisplay(Material.STAINED_GLASS_PANE, inv, 53, "§cToggle All Off", toggleofflore, false, 14, 1);
                    p.openInventory(inv);


                }


            } else if (args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("set")) {
                if (p.isOp()){
                    Player target = Bukkit.getPlayer(args[1]);
                if (target != null) {
                    if (args[2].matches("^-?\\d+$")) {
                        if (args[0].equalsIgnoreCase("add")) {
                            Main.giveShard(target, Integer.parseInt(args[2]));
                            p.sendMessage("§bYou just §aadded " + args[2] + " shards §bfrom " + target.getName());
                            target.sendMessage("§bYou received §a" +args[2] +" Shards§b!\n");
                        }
                        if (args[0].equalsIgnoreCase("remove")) {
                            Main.removeShard(target, Integer.parseInt(args[2]));
                            p.sendMessage("§bYou just §cremoved " + args[2] + " shards §bfrom " + target.getName());
                            target.sendMessage("§c"+args[2] +" Shards§b were removed from your account.\n");
                        }
                        if (args[0].equalsIgnoreCase("set")) {
                            Main.setShard(target, Integer.parseInt(args[2]));
                            p.sendMessage("§bYou just §3set " + args[2] + " shards §bfrom " + target.getName());
                            target.sendMessage("§bYour shards were §3set to "+ args[2]+"§b.\n");
                        }


                    }
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer not found! &7&oPlease try again with a correct username!"));
                }



            }
        } else if(args[0].equalsIgnoreCase("help")) {
                if(p.isOp()) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&7&m-----------------&5 Royal &6Enchantments &7&m-----------------\n" +
                            "&9/shard help &7- Displays this menu\n" +
                            "&9/shard &7- Opens the Enchantment Shop\n" +
                            "&9/shard {player} &7- Display a player's total shards\n" +
                            "&9/shard {add/remove/set} {player} {amount} &7- Edit a player's shards\n" +
                            "&9/shard reset {player} &7- &cWARNING &7Reset a players Account\n" +
                            "&7&m-----------------&5 Royal &6Enchantments &7&m----------"));
                }
            }else if(args[0].equalsIgnoreCase("reset")) {
                if (p.isOp()) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target != null) {
                        plugin.getConfig().set("royale." + target.getUniqueId(),null);
                        p.sendMessage("§cYou just reset the Royal Enchantments Account of §c§n" + target.getName() +"§c!");
                        target.sendMessage("§cYour Custom Enchantments Levels and Shards were RESET!");
                    } else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer not found! &7&oPlease try again with a correct username!"));

                    }


                }
            }
            Player payingto = Bukkit.getServer().getPlayer(args[0]);
            if (payingto != null) {
                if(args[0].equalsIgnoreCase(payingto.getName())) {
                    if (p.isOp() || p.hasPermission("royal.shard.vip")) {

                            int shardamt = Main.plugin.getConfig().getInt("royale." + payingto.getUniqueId() + ".shard");
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&b" + payingto.getName() + " has &3" + shardamt + " shards."));

                    }

                }
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer not found! &7&oPlease try again with a correct username!"));

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
