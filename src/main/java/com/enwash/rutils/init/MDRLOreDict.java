package com.enwash.rutils.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MDRLOreDict {
	public static void initOres() {
		for (int i = 0; i < 9; i++) {
			OreDictionary.registerOre("plantMatter", new ItemStack(Blocks.RED_FLOWER, 1, i));
		}
		//OreDictionary.registerOre("entropyManipulator", Blocks.YELLOW_FLOWER);
	}
}