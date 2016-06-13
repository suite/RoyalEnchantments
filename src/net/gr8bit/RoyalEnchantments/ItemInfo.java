package net.gr8bit.RoyalEnchantments;

import org.bukkit.Material;

/**
 * Created by Matt on 6/12/16.
 */
public class ItemInfo {
    public String getLore() {
        return lore;
    }

    public Material getMaterial() {
        return material;
    }

    public Integer[] getUpgradeamount() {
        return upgradeamount;
    }

    public Integer[] getChance() {
        return chance;
    }

    public Integer[] getSpeed() {
        return speed;
    }

    String lore;
    Material material;
    Integer[] upgradeamount;
    Integer[] chance;
    Integer[] speed;

    public ItemInfo(
            String loreIn,
            Material materialIn,
            Integer [] upgradeamountIn,
            Integer[] chanceIn,
            Integer[] speedIn
    ) {

        lore = loreIn;
        material = materialIn;
        upgradeamount = upgradeamountIn;
        chance = chanceIn;
        speed = speedIn;
    }
}
