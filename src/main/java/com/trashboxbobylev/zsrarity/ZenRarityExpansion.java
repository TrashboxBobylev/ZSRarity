package com.trashboxbobylev.zsrarity;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenExpansion("crafttweaker.item.IItemStack")
public class ZenRarityExpansion {
    @ZenMethod
    public static void setRarity(IItemStack itemStack, String colorName){
        String ogName = I18n.translateToLocal(CraftTweakerMC.getItemStack(itemStack).getItem().getUnlocalizedNameInefficiently(
                CraftTweakerMC.getItemStack(itemStack)
        ) + ".name");
        if (ogName.startsWith("\u00A7") && ogName.substring(1).matches("[0-9a-f]")) {
            itemStack.setDisplayName(ogName.substring(1).replaceFirst("[0-9a-f]", ""));
        }

        itemStack.setDisplayName(TextFormatting.getValueByName(colorName) + itemStack.getDisplayName());
    }
}
