package com.enwash.rutils.init;


import java.util.ArrayList;
import java.util.List;

import com.enwash.rutils.items.ItemBase;
import com.enwash.rutils.items.MultiTool;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class MDRLItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	
	//public static final Item ITEM_404 = new ItemBase("item_404");
	//public static final Item SEWING_KIT = new CraftTool("sewing_kit", 16);
	
	// ITEMS
	//public static final ToolMaterial MAT_DRILL_BASIC = EnumHelper.addToolMaterial("mat_drill_basic", 2, 500, 15.0F, 2.0F, 0).setRepairItem(new ItemStack(MDRLItems.DRILL_BATTERY, 1));
	public static final Item REDSTONE_MULTITOOL = new MultiTool("redstone_multitool");
}