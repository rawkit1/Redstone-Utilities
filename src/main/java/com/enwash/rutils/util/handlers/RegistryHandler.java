package com.enwash.rutils.util.handlers;

import com.enwash.rutils.blocks.machines.entropymanipulator.TileEntropyManipulator;
import com.enwash.rutils.init.MDRLBlocks;
import com.enwash.rutils.init.MDRLItems;
import com.enwash.rutils.util.ICanHazModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(MDRLItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(MDRLBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : MDRLItems.ITEMS)
		{
			if(item instanceof ICanHazModel)
			{
				((ICanHazModel)item).registerModels();
			}
		}
		
		for(Block block : MDRLBlocks.BLOCKS)
		{
			if(block instanceof ICanHazModel)
			{
				((ICanHazModel)block).registerModels();
			}
		}
	}
	public static void preInitRegistries()
	{
		GameRegistry.registerTileEntity(TileEntropyManipulator.class, "rutils:entropymanipulator");
	}
	
	public static void initRegistries() {
		RecipeHandler.initRecipes();
	}
	
	public static void otherRegistries() {
		
	}
}