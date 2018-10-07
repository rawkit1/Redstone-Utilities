package com.enwash.rutils.blocks.power;

import java.util.Random;

import com.enwash.rutils.Main;
import com.enwash.rutils.init.MDRLBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TilePowerEmitter extends TileEntity implements ITickable {

	public TilePowerEmitter() {
		
	}

	@Override
	public void update() {
		if (this.getWorld().getBlockState(this.getPos()).getBlock() instanceof PowerEmitter)this.getBlockType().randomTick(this.getWorld(), pos, this.getWorld().getBlockState(this.getPos()), this.getWorld().rand);
	}

}
