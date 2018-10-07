package com.enwash.rutils;



import com.enwash.rutils.init.MDRLOreDict;
import com.enwash.rutils.proxy.CommonProxy;
import com.enwash.rutils.tabs.Tab;
import com.enwash.rutils.util.Reference;
import com.enwash.rutils.util.handlers.RegistryHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.Config.RangeInt;
import net.minecraftforge.common.config.Config.RequiresMcRestart;
import net.minecraftforge.common.config.Config.Type;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	@Instance
	public static Main instance;
	public static final CreativeTabs tab = new Tab("tab");
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		RegistryHandler.preInitRegistries();
		
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		RegistryHandler.initRegistries();
		MDRLOreDict.initOres();
	}
		
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
		
	}
	
	@Config(modid = Reference.MOD_ID, type = Type.INSTANCE, name = Reference.MOD_ID + "_types")
    public static class CONFIG_TYPES
    {
        public static class BlockConfig
        {
        	public static int extraTicksPerManipulator = 50;
        	public static int manipulatorRadius = 4;
        }
    }
	
}
