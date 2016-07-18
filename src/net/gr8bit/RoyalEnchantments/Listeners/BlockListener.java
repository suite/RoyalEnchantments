package net.gr8bit.RoyalEnchantments.Listeners;

import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.massivecore.ps.PS;
import net.gr8bit.RoyalEnchantments.ActionBar;
import net.gr8bit.RoyalEnchantments.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matt on 6/8/16.
 */
public class BlockListener implements Listener {

    Material dropitem;


    @EventHandler
    public void blockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (Main.willUseAbilityChance(e.getPlayer(), "Auto_Smelt")) {


            if (e.getBlock().getType().equals(Material.GOLD_ORE)) {
                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
                e.getBlock().setType(Material.AIR);
                ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &33 Shards&b!"));
                actionBar.sendToPlayer(p);
                Main.giveShard(e.getPlayer(), 3);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);

            } else if (e.getBlock().getType().equals(Material.IRON_ORE)) {
                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
                e.getBlock().setType(Material.AIR);
                ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &32 Shards&b!"));
                actionBar.sendToPlayer(p);
                Main.giveShard(e.getPlayer(), 2);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);

            } else if (e.getBlock().getType().equals(Material.SAND)) {
                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.GLASS));
                e.getBlock().setType(Material.AIR);

            } else if (e.getBlock().getType().equals(Material.NETHERRACK)) {
                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.NETHER_BRICK));
                e.getBlock().setType(Material.AIR);

            }


        }
        if (!p.getGameMode().equals(GameMode.CREATIVE)) {
            if (Main.willUseAbilityChance(e.getPlayer(), "Jackhammer")) {

                e.setCancelled(true);
                int level = Main.getLevel(e.getPlayer(), "Jackhammer");
                int x = e.getBlock().getLocation().getBlockX();
                int z = e.getBlock().getLocation().getBlockZ();
                int y = e.getBlock().getLocation().getBlockY();

                        if (e.getBlock().getType().equals(Material.COAL_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &31 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 1);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);
                        } else if (e.getBlock().getType().equals(Material.IRON_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &32 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 2);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);
                        } else if (e.getBlock().getType().equals(Material.GOLD_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &33 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 3);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);
                        } else if (e.getBlock().getType().equals(Material.LAPIS_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &33 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 3);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);
                        } else if (e.getBlock().getType().equals(Material.GLOWING_REDSTONE_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &32 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 2);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);
                        } else if (e.getBlock().getType().equals(Material.DIAMOND_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &38 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 8);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);
                        } else if (e.getBlock().getType().equals(Material.EMERALD_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &310 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 10);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);
                        } else if (e.getBlock().getType().equals(Material.QUARTZ_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &33 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 2);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 3);
                        }
                e.getBlock().breakNaturally();


                        Block aa = new Location(e.getPlayer().getWorld(), x + 1, y, z).getBlock();
                        Block bb = new Location(e.getPlayer().getWorld(), x, y, z + 1).getBlock();
                        Block cc = new Location(e.getPlayer().getWorld(), x + 1, y, z + 1).getBlock();
                        if (!aa.getType().equals(Material.BEDROCK) && (!bb.getType().equals(Material.BEDROCK) && (!cc.getType().equals(Material.BEDROCK)))) {
                            if (!aa.getType().toString().toLowerCase().contains("ore")) {
                                aa.breakNaturally();
                            }
                            if (!bb.getType().toString().toLowerCase().contains("ore")) {
                                bb.breakNaturally();
                            }
                            if (!cc.getType().toString().toLowerCase().contains("ore")) {
                                cc.breakNaturally();
                            }
                        }

                        if (level > 2) {
                            Block dd = new Location(e.getPlayer().getWorld(), x - 1, y, z).getBlock();
                            Block ee = new Location(e.getPlayer().getWorld(), x, y, z - 1).getBlock();
                            Block ff = new Location(e.getPlayer().getWorld(), x + 1, y, z - 1).getBlock();
                            Block gg = new Location(e.getPlayer().getWorld(), x - 1, y, z - 1).getBlock();
                            Block hh = new Location(e.getPlayer().getWorld(), x - 1, y, z + 1).getBlock();
                            if (!dd.getType().equals(Material.BEDROCK) && (!ee.getType().equals(Material.BEDROCK) && (!ff.getType().equals(Material.BEDROCK) && (!gg.getType().equals(Material.BEDROCK) && (!hh.getType().equals(Material.BEDROCK)))))) {
                                if (!dd.getType().toString().toLowerCase().contains("ore")) {
                                    dd.breakNaturally();
                                }
                                if (!ee.getType().toString().toLowerCase().contains("ore")) {
                                    ee.breakNaturally();
                                }
                                if (!ff.getType().toString().toLowerCase().contains("ore")) {
                                    ff.breakNaturally();
                                }
                                if (!gg.getType().toString().toLowerCase().contains("ore")) {
                                    gg.breakNaturally();
                                }
                                if (!hh.getType().toString().toLowerCase().contains("ore")) {
                                    hh.breakNaturally();
                                }
                            }


                        }

                    }
                }
                Location location2 = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
                Faction faction2 = BoardColl.get().getFactionAt(PS.valueOf(location2));
                if (!faction2.getName().equalsIgnoreCase("Safezone") || (!faction2.getName().equalsIgnoreCase("Warzone") || !(MPlayer.get(p).isInEnemyTerritory()))) {
                    if (!e.getBlock().hasMetadata("blockplaced")) {
                        if (e.getBlock().getType().equals(Material.COAL_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &31 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 1);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);
                        } else if (e.getBlock().getType().equals(Material.IRON_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &32 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 2);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);
                        } else if (e.getBlock().getType().equals(Material.GOLD_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &33 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 3);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);
                        } else if (e.getBlock().getType().equals(Material.LAPIS_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &33 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 3);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);
                        } else if (e.getBlock().getType().equals(Material.GLOWING_REDSTONE_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &32 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 2);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);
                        } else if (e.getBlock().getType().equals(Material.DIAMOND_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &38 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 8);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);
                        } else if (e.getBlock().getType().equals(Material.EMERALD_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &310 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 10);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 1);
                        } else if (e.getBlock().getType().equals(Material.QUARTZ_ORE)) {
                            ActionBar actionBar = new ActionBar(ChatColor.translateAlternateColorCodes('&', "&bYou collected &33 Shards&b!"));
                            actionBar.sendToPlayer(p);
                            Main.giveShard(e.getPlayer(), 2);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 10, 3);
                        }
                    }
                }

                    }
                }




            /*

            Coal Ore - 1
Iron Ore - 2
Gold Ore - 4
Lapis Lazuli Ore - 3
Redstone Ore - 2
Diamond Ore - 10
Emerald Ore - 15
Nether Quartz Ore - 2
             */



                        /*
                        new Integer [] {10,20,30,40,50}

                        Gold Ore - Gold Ingot
                        Iron Ore - Iron Ingot
                        Sand - Glass
                        Netherrack - NetherBrick
                         */







