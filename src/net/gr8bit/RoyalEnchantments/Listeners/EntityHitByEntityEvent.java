package net.gr8bit.RoyalEnchantments.Listeners;

import net.gr8bit.RoyalEnchantments.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static net.gr8bit.RoyalEnchantments.Main.plugin;

/**
 * Created by Matt on 6/14/16.
 */
public class EntityHitByEntityEvent implements Listener {

    private final BlockFace[] surrounding = new BlockFace[]{BlockFace.NORTH,
            BlockFace.NORTH_EAST,
            BlockFace.EAST,
            BlockFace.SOUTH_EAST,
            BlockFace.SOUTH,
            BlockFace.SOUTH_WEST,
            BlockFace.WEST,
            BlockFace.NORTH_WEST};

    @EventHandler
    public void entityByEntity(EntityDamageByEntityEvent e) {

        if (Main.willUseAbilityChance(((Player)e.getDamager()), "Mob_Swatter")) {
            if (e.getEntity() instanceof Monster){
                ((Monster) e.getEntity()).setHealth(0.00);



            }

        }
            Player pa = (Player) e.getEntity();
            Player pd = (Player) e.getDamager();


        //   ((TNTPrimed) tnt).setFuseTicks(0);

            ItemStack[] armor = pa.getInventory().getArmorContents();

            if (Main.willUseAbilityChance(pd, "Piercing")) {
                e.setCancelled(true);
                pa.getInventory().setArmorContents(null);
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        double health = pa.getHealth() - e.getDamage();
                        pa.damage(health);
                        if (health < 0) {
                            pa.damage(0);
                        }

                    }
                }, 10);


                pa.getInventory().setArmorContents(armor);

            }
            if (Main.willUseAbilityChance(pd, "Frostbite")) {
                int level = Main.getLevel(pd, "Frostbite");
                if (level == 1) {
                    trapPlayer(pa, Material.ICE);
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999999, 999999999));
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            pa.removePotionEffect(PotionEffectType.SLOW);
                            trapPlayer(pa, Material.AIR);
                        }
                    }, 20);

                } else if (level == 2) {
                    trapPlayer(pa, Material.ICE);
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999999, 999999999));
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            pa.removePotionEffect(PotionEffectType.SLOW);
                            trapPlayer(pa, Material.AIR);
                        }
                    }, 22);

                } else if (level == 3) {
                    trapPlayer(pa, Material.ICE);
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999999, 999999999));
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            pa.removePotionEffect(PotionEffectType.SLOW);
                            trapPlayer(pa, Material.AIR);
                        }
                    }, 23);

                } else if (level == 4) {
                    trapPlayer(pa, Material.ICE);
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999999, 999999999));
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            pa.removePotionEffect(PotionEffectType.SLOW);
                            trapPlayer(pa, Material.AIR);
                        }
                    }, 25);

                }
            }
            if (Main.willUseAbilityChance(pd, "Voltage")) {
                pa.getWorld().strikeLightning(pa.getLocation());
            }
            if (Main.willUseAbilityChance(pd, "Wolf_Tamer")) {
                Wolf wolf = (Wolf) pd.getWorld().spawnEntity(pd.getLocation(), EntityType.WOLF);

                // Just to make sure it's a normal wolf.
                wolf.setAdult();
                wolf.setTamed(true);
                wolf.setOwner(pd);
                wolf.setTarget(pa);

                // We don't want extra wolves.
                wolf.setBreed(false);

                // Clarify the owner.
                wolf.setCustomName(ChatColor.YELLOW + pd.getName() + "'s Wolf");
                wolf.setCustomNameVisible(true);


                // Misc.
                wolf.setHealth(wolf.getMaxHealth());
                wolf.setCanPickupItems(false);
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        wolf.setHealth(0.00);
                    }
                }, 10 * 20);
            }
            if (Main.willUseAbilityChance(pd, "Enemy_Decay")) {
                if (Main.getLevel(pd, "Enemy_Decay") == 1) {
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5*20, 1));
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5*20, 1));
                } else if (Main.getLevel(pd, "Enemy_Decay") == 2) {
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 6*20, 1));
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 6*20, 1));
                } else if (Main.getLevel(pd, "Enemy_Decay") == 3) {
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 8*20, 1));
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 8*20, 1));
                }
            }

            if (Main.willUseAbilityChance(pd, "Savage")) {
                if (Main.getLevel(pd, "Savage") == 1) {
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 5 * 20, 1));
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 5 * 20, 1));
                    pd.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 5 * 20, 1));
                    pd.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 5 * 20, 1));

                } else if (Main.getLevel(pd, "Savage") == 2) {
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 6 * 20, 1));
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 6 * 20, 1));
                    pd.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 6 * 20, 1));
                    pd.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 6 * 20, 1));

                } else if (Main.getLevel(pd, "Savage") == 3) {
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 7 * 20, 1));
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 7 * 20, 1));
                    pd.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 7 * 20, 1));
                    pd.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 7 * 20, 1));

                } else if (Main.getLevel(pd, "Savage") == 4) {
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 8 * 20, 1));
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 8 * 20, 1));
                    pd.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 8 * 20, 1));
                    pd.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 8 * 20, 1));

                } else if (Main.getLevel(pd, "Savage") == 5) {
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 10 * 20, 1));
                    pa.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 10 * 20, 1));
                    pd.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 10 * 20, 1));
                    pd.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 10 * 20, 1));

                }
            }
            if (Main.willUseAbilityChance(pd, "Life_Steal")) {
                double healthgave = e.getDamage();
                pd.setHealth(pd.getHealth() + healthgave);
            }
        }









        public void trapPlayer(Player player, Material material)
        {
            Location[] locs = new Location[]{player.getLocation(),
                    player.getLocation().add(0,1,0),
                    player.getLocation().add(0,2,0)};
            for(Location loc : locs)
            {
                for(BlockFace bf : surrounding)
                {
                    loc.getBlock().getRelative(bf, 1).setType(material);
                }
            }
            // Also block above the player
            player.getLocation().add(0,2,0).getBlock().setType(material);

        }
    }

