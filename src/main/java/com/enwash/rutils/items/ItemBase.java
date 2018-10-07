package com.enwash.rutils.items;

import com.enwash.rutils.Main;
import com.enwash.rutils.init.MDRLItems;
import com.enwash.rutils.util.ICanHazModel;

import net.minecraft.item.Item;

public class ItemBase extends Item implements ICanHazModel {

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tab);
		MDRLItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

	
}
