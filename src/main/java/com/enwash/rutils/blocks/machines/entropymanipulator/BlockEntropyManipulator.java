package com.enwash.rutils.blocks.machines.entropymanipulator;

import java.util.List;
import java.util.Random;

import com.enwash.rutils.Main;
import com.enwash.rutils.blocks.power.PowerReceiver;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockEntropyManipulator extends PowerReceiver {
	
	public BlockEntropyManipulator(String name, Material material) {
		super(name, material);
	}
	
	@Override
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
		super.addInformation(stack, player, tooltip, advanced);
		String radius = Integer.toString(Main.CONFIG_TYPES.BlockConfig.manipulatorRadius * 2 + 1);
		tooltip.add(TextFormatting.DARK_PURPLE + "Increases the tick rate in a " + radius + "x" + radius + " square");
		tooltip.add(TextFormatting.DARK_PURPLE + "Must be surrounded by redstone blocks for power");
	}
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
		if (stateIn.getValue(POWERED)) {
	        double d0 = pos.getX() + 0.5D;
	        double d1 = pos.getY() + 0.5D;
	        double d2 = pos.getZ() + 0.5D;
	        for (int x = -1; x < 2; x++) {
	        	for (int y = -1; y < 2; y++) {
	        		for (int z = -1; z < 2; z++) {
	        			worldIn.spawnParticle(EnumParticleTypes.REDSTONE, d0+x, d1+y, d2+z, 1, 0, 0);
	                }
	            }
	        }
		}
    }
	
	// Tile entity
	
	@Override
	public boolean hasTileEntity(IBlockState state) 
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) 
	{
		return new TileEntropyManipulator();
	}
	
}