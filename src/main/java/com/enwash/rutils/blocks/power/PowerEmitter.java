package com.enwash.rutils.blocks.power;

import java.util.Random;

import com.enwash.rutils.blocks.Machine;
import com.enwash.rutils.blocks.machines.entropymanipulator.TileEntropyManipulator;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PowerEmitter extends Machine {
	
	public static final PropertyBool POWERED = PropertyBool.create("powered");
	
	public PowerEmitter(String name, Material material) {
		super(name, material);
		setDefaultState(this.blockState.getBaseState().withProperty(POWERED, true));
	}
	
	public boolean isPowered(IBlockState state, World worldIn, BlockPos pos) {
		return true;
	}
	
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		IBlockState state1 = worldIn.getBlockState(pos).withProperty(POWERED, isPowered(state, worldIn, pos));
		((World) worldIn).setBlockState(pos, state1);
		//super.randomTick(worldIn, pos, state, rand);
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
	
	@Override
	public boolean hasTileEntity(IBlockState state) 
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) 
	{
		return new TilePowerEmitter();
	}
	
}
