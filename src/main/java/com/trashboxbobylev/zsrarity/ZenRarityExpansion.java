package com.trashboxbobylev.zsrarity;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.mc1120.CraftTweaker;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.HashMap;

@ZenRegister
@ZenExpansion("crafttweaker.item.IItemStack")
public class ZenRarityExpansion {
    public static HashMap<Item, TextFormatting> customRarities = new HashMap<>();

    @ZenMethod
    public static void setRarity(IItemStack itemStack, String colorName){
        customRarities.put(CraftTweakerMC.getItemStack(itemStack).getItem(), TextFormatting.getValueByName(colorName));
        CraftTweaker.LOG.info(CraftTweakerMC.getItemStack(itemStack).getItem().toString() +
                " " + TextFormatting.getValueByName(colorName).toString());
    }
}
