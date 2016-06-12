package net.gr8bit.RoyalEnchantments;

import org.bukkit.Material;

/**
 * Created by Matt on 6/12/16.
 */
public class ItemInfo {
    String lore;
    Material material;
    Integer[] upgradeamount;
    int chance;
    int speed;

    public ItemInfo(
            String loreIn,
            Material materialIn,
            Integer [] upgradeamountIn,
            int chanceIn,
            int speedIn
    ) {

        lore = loreIn;
        material = materialIn;
        upgradeamount = upgradeamountIn;
        chance = chanceIn;
        speed = speedIn;
    }
}
