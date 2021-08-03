package com.trashboxbobylev.zsrarity;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ZSRarity.MODID, name = ZSRarity.NAME, version = ZSRarity.VERSION, dependencies = "required-after:crafttweaker")
public class ZSRarity
{
    public static final String MODID = "zsrarity";
    public static final String NAME = "ZSRarity";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public static void preinit(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(RarityHandler.class);
    }
}
