package com.enwash.rutils.tabs;

import com.enwash.rutils.init.MDRLBlocks;
import com.enwash.rutils.init.MDRLItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Tab extends CreativeTabs {

	public Tab(String label) {super("machines");}
	@Override
	public ItemStack getTabIconItem() { return new ItemStack(MDRLBlocks.ENTROPY_MANIPULATOR); }
	
}
