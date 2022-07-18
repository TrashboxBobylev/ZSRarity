package com.trashboxbobylev.zsrarity;

import com.teamacronymcoders.base.materialsystem.MaterialSystem;
import com.teamacronymcoders.base.materialsystem.materialparts.MaterialPart;
import com.teamacronymcoders.contenttweaker.modules.materials.brackethandler.MaterialPartDefinition;
import com.teamacronymcoders.contenttweaker.modules.materials.materialparts.CTMaterialPart;
import com.teamacronymcoders.contenttweaker.modules.materials.materialparts.IMaterialPart;
import crafttweaker.CraftTweakerAPI;
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
        CraftTweakerAPI.logInfo(str);
        rarityMap.put(str, rarity);
    }

    @ZenMethod
    public static void setRarity(IMaterialPart part, String rarity){
        String str = new MaterialPartDefinition(MaterialSystem.getMaterialPart(part.getMaterial().getUnlocalizedName() + "_" + part.getPart().getShortUnlocalizedName())).toCommandString();
        CraftTweakerAPI.logInfo(str);
        rarityMap.put(str, rarity);
    }
}
