package com.enwash.rutils.blocks.power;

import com.enwash.rutils.blocks.Machine;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PowerReceiver extends Machine {

	public static final PropertyBool POWERED = PropertyBool.create("powered");
	
	public PowerReceiver(String name, Material material) {
		super(name, material);
		setDefaultState(this.blockState.getBaseState().withProperty(POWERED, false));
	}
	
	public boolean checkPowerSources(World worldIn, IBlockState state, BlockPos pos) {
		if (worldIn.getBlockState(pos.add(0,-1,0)).getBlock() instanceof PowerEmitter && worldIn.getBlockState(pos.add(0,-1,0)).getBlock().getMetaFromState(worldIn.getBlockState(pos.add(0,-1,0))) == 1) return true;
		if (worldIn.getBlockState(pos.add(0,1,0)).getBlock() instanceof PowerEmitter && worldIn.getBlockState(pos.add(0,1,0)).getBlock().getMetaFromState(worldIn.getBlockState(pos.add(0,-1,0))) == 1) return true;
		if (worldIn.getBlockState(pos.add(1,0,0)).getBlock() instanceof PowerEmitter && worldIn.getBlockState(pos.add(1,0,0)).getBlock().getMetaFromState(worldIn.getBlockState(pos.add(0,-1,0))) == 1) return true;
		if (worldIn.getBlockState(pos.add(-1,0,0)).getBlock() instanceof PowerEmitter && worldIn.getBlockState(pos.add(-1,-1,0)).getBlock().getMetaFromState(worldIn.getBlockState(pos.add(0,-1,0))) == 1) return true;
		if (worldIn.getBlockState(pos.add(0,0,1)).getBlock() instanceof PowerEmitter && worldIn.getBlockState(pos.add(0,0,1)).getBlock().getMetaFromState(worldIn.getBlockState(pos.add(0,-1,0))) == 1) return true;
		if (worldIn.getBlockState(pos.add(0,0,-1)).getBlock() instanceof PowerEmitter && worldIn.getBlockState(pos.add(0,0,-1)).getBlock().getMetaFromState(worldIn.getBlockState(pos.add(0,-1,0))) == 1) return true;
		return false;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		IBlockState state1 = worldIn.getBlockState(pos).withProperty(POWERED, checkPowerSources((World) worldIn, worldIn.getBlockState(pos), pos));
		((World) worldIn).setBlockState(pos, state1);
		super.neighborChanged(state1, worldIn, pos, blockIn, fromPos);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {POWERED});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(POWERED, meta==1);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return state.getValue(POWERED) ? 1 : 0;
	}
	
}
