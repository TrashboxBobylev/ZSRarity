package com.trashboxbobylev.zsrarity;

import com.teamacronymcoders.contenttweaker.modules.materials.brackethandler.MaterialPartDefinition;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.HashMap;

@ZenClass("zsrarity.MaterialPartRarity")
@ModOnly("contenttweaker")
@ZenRegister()
public class MaterialPartRarity {

    public static HashMap<String, String> rarityMap = new HashMap<>();

    @ZenMethod
    public static void setRarity(MaterialPartDefinition definition, String rarity){
        String str = definition.toCommandString();
        rarityMap.put(str, rarity);
    }
}
