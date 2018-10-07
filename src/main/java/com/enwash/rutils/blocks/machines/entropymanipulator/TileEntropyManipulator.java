package com.enwash.rutils.blocks.machines.entropymanipulator;

import java.util.Random;

import com.enwash.rutils.Main;
import com.enwash.rutils.init.MDRLBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntropyManipulator extends TileEntity implements ITickable {

	public TileEntropyManipulator() {
		
	}
	
	public static int EXTRA_TICKS = Main.CONFIG_TYPES.BlockConfig.extraTicksPerManipulator - 3;
	public static int TICK_RADIUS = 4;
	
	@Override
	public void update() {
		if (this.getWorld().getBlockState(this.getPos()).getBlock() == MDRLBlocks.ENTROPY_MANIPULATOR && this.getBlockMetadata() == 1) tickBlocks(this.getWorld(), this.getPos(), EXTRA_TICKS);
	}
	
	// Extra tick section
	
	public static BlockPos getBlockPosFromRadius(BlockPos pos, int radius, Random r) {
		int x = r.nextInt(2 * radius + 1) - radius;
		int y = r.nextInt(256);
		int z = r.nextInt(2 * radius + 1) - radius;
		BlockPos ret = new BlockPos(pos.getX() + x, y, pos.getZ() + z);
		return ret;
	}
	
	public static void tickBlocks(World worldIn, BlockPos pos, int num) {
		for (int i = 0; i < num; i++ ) {
		    BlockPos randomPos = getBlockPosFromRadius(pos, TICK_RADIUS, worldIn.rand);
		        IBlockState state = worldIn.getBlockState(randomPos );
		        if (state.getBlock() != MDRLBlocks.ENTROPY_MANIPULATOR) state.getBlock().randomTick(worldIn, randomPos , state, worldIn.rand);
		    }
	}

}
