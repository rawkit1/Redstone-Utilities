package com.enwash.rutils.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Ore extends BlockBase {

	public Ore(String name, Material materialIn) {
		super(name, materialIn);
		setHarvestLevel("pickaxe", 2);
		setHardness(8f);
		this.setResistance(5f);
		setSoundType(SoundType.STONE);
	}
	
}
