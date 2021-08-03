package com.trashboxbobylev.zsrarity;

import crafttweaker.mc1120.CraftTweaker;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RarityHandler {
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent e){
        Item base = e.getItemStack().getItem();
        if (ZenRarityExpansion.customRarities.containsKey(base)){
            e.getToolTip().set(0,
                    ZenRarityExpansion.customRarities.get(base) + e.getToolTip().get(0));
        }
    }
}
