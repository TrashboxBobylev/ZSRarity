package com.trashboxbobylev.zsrarity;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.mc1120.actions.ActionSetStackTranslation;
import crafttweaker.mc1120.game.MCGame;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenExpansion("crafttweaker.item.IItemStack")
public class ZenRarityExpansion {
    @ZenMethod
    public static void setRarity(IItemStack itemStack, String colorName){
        String key = CraftTweakerMC.getItemStack(itemStack).getItem().getUnlocalizedNameInefficiently(
                CraftTweakerMC.getItemStack(itemStack)
        ) + ".name";
        String key2 = CraftTweakerMC.getItemStack(itemStack).getUnlocalizedName();
        if (key2.contains("specialflower")){
            key = key2;
        }
        String ogName = I18n.translateToLocal( key + ".name");

        if (ogName.startsWith("\u00A7") && ogName.substring(1).matches("[0-9a-f]")) {
            setDisplayName(key, ogName.substring(1).replaceFirst("[0-9a-f]", ""));
        }
        setDisplayName(key, TextFormatting.getValueByName(colorName) + itemStack.getDisplayName());
    }

    private static void setDisplayName(String key, String value){
        ActionSetStackTranslation action = new ActionSetStackTranslation(null, key, value);
        MCGame.TRANSLATION_ACTIONS.add(action);
        CraftTweakerAPI.apply(action);
    }
}
