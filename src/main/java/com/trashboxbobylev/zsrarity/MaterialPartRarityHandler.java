package com.trashboxbobylev.zsrarity;

import com.blamejared.mtlib.helpers.LogHelper;
import crafttweaker.annotations.ModOnly;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

import static com.trashboxbobylev.zsrarity.MaterialPartRarity.rarityMap;

@ModOnly("contenttweaker")
@Mod.EventBusSubscriber
public class MaterialPartRarityHandler {
    @SubscribeEvent
    public static void handleTooltip(ItemTooltipEvent itemTooltipEvent){
        IItemStack item = CraftTweakerMC.getIItemStack(itemTooltipEvent.getItemStack()).amount(1);
        String commandString = item.toCommandString();
        if (rarityMap.containsKey(commandString)) {
            LogHelper.logInfo(String.format("Color %s as %s", item, rarityMap.get(commandString)));
            ArrayList<String> tooltips = (ArrayList<String>) itemTooltipEvent.getToolTip();
            tooltips.set(0, TextFormatting.getValueByName(rarityMap.get(commandString)) + tooltips.get(0));
        }
    }
}