package com.enwash.rutils.init;

import java.util.ArrayList;
import java.util.List;

import com.enwash.rutils.blocks.machines.entropymanipulator.BlockEntropyManipulator;
import com.enwash.rutils.blocks.machines.entropymanipulator.Transmitter;
import com.enwash.rutils.blocks.power.PowerEmitter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MDRLBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final Block ENTROPY_MANIPULATOR = new BlockEntropyManipulator("entropy_manipulator", Material.IRON);
	public static final Block REDSTONE_TRANSMITTER = new Transmitter("redstone_transmitter", Material.IRON);
	public static final Block INF_GENERATOR = new PowerEmitter("powergen", Material.IRON);
}